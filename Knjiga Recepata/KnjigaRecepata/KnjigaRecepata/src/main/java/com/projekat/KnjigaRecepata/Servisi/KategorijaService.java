package com.projekat.KnjigaRecepata.Servisi;

import com.projekat.KnjigaRecepata.Entiteti.Kategorija;
import com.projekat.KnjigaRecepata.Repositorijumi.KategorijaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KategorijaService {
    @Autowired
    private KategorijaRepository kategorijaRepository;

    public KategorijaService (KategorijaRepository kategorijaRepository){
        this.kategorijaRepository = kategorijaRepository;
    }

    public List<Kategorija> sveKategorije(){
        return kategorijaRepository.findAll();
    }

    public void dodajKategoriju (Kategorija kategorija){
        kategorijaRepository.save(kategorija);
    }

    public void obrisiKategoriju(Long id){
        kategorijaRepository.deleteById(id);
    }


}
