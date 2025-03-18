package com.projekat.KnjigaRecepata.Servisi;

import com.projekat.KnjigaRecepata.Entiteti.Kategorija;
import com.projekat.KnjigaRecepata.Entiteti.Recept;
import com.projekat.KnjigaRecepata.Repositorijumi.KategorijaRepository;
import com.projekat.KnjigaRecepata.Repositorijumi.ReceptRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class ReceptService {
    @Autowired
    private ReceptRepository receptRepository;
    private KategorijaRepository kategorijaRepository;


    // konstruktor gde spajamo servis sa repositorijem iliti bazom nad kojom cemo vrsiti operacije
    public ReceptService (ReceptRepository receptRpository, KategorijaRepository kategorijaRepository){
        this.receptRepository = receptRpository;
        this.kategorijaRepository = kategorijaRepository;
    }
    public List<Recept> sviRecepti(){
        return receptRepository.findAll();
    }

    public void dodajRecept(Recept recept){
        receptRepository.save(recept);
    }

    public void promeniRecept(Long id,Recept recept){
        Recept postojiRecept = receptRepository.findById(id).
                orElseThrow(()-> new NoSuchElementException("Recept sa ovim id ne postoji!"));
        postojiRecept.setNaziv(recept.getNaziv());
        postojiRecept.setVremePripreme(recept.getVremePripreme());
        receptRepository.save(postojiRecept);
    }

    public Recept nadjiRecept(Long id){
        return receptRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Recept sa tim ID nije pronadjen."));
    }

    public void obrisiRecept(Long id) {
        receptRepository.deleteById(id);
    }
    public void dodajKategorijuReceptu (Long id, Long kategorija_id){
        // nadjem recept u bazi ako postoji
        Recept recept = receptRepository.findById(id).
                orElseThrow(()-> new NoSuchElementException("Ne postoji recept sa tim id!"));
        // nadjem kategoriju u bazi ako postoji
        Kategorija kategorija = kategorijaRepository.findById(kategorija_id).
                orElseThrow(()-> new NoSuchElementException("Ne postoji kategorija sa tim id!"));
        // preko setera receptu dodeljujem kategoriju koju sam pronasao iznad
        recept.setKategorija(kategorija);
        // cuvam ono sto sam dodelio
        receptRepository.save(recept);
    }

    public void dodajVideoReceptu(Long id, String videoRecept){
        Recept recept = receptRepository.findById(id).orElseThrow(()-> new NoSuchElementException("Ne postoji recept sa tim id!"));
        recept.setVideoRecept(videoRecept);
        receptRepository.save(recept);

    }

    public List<Recept> sviReceptiPoKategoriji(Long kategorija_id){
        Kategorija kategorija = kategorijaRepository.findById(kategorija_id).
                orElseThrow(()-> new NoSuchElementException("Nema kategorije sa tim id!"));
        // ako smo nasli kategoriju sa odredjenim id, vracamo listu recepata
        // preko metode koju smo definisali u repositoriju
        return receptRepository.findByKategorija(kategorija);
    }
}
