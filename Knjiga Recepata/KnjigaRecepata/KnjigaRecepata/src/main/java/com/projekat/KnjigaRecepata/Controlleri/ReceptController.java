package com.projekat.KnjigaRecepata.Controlleri;

import com.projekat.KnjigaRecepata.DTO.VideoDTO;
import com.projekat.KnjigaRecepata.Entiteti.Recept;
import com.projekat.KnjigaRecepata.Servisi.ReceptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/recepti")
public class ReceptController {
    private final ReceptService receptService;

    @Autowired // konstruktor koji spaja rikvestove sa servisom
    public ReceptController (ReceptService receptService){
        this.receptService = receptService;
    }
    @GetMapping
    public List<Recept> sviRecepti(){
        return receptService.sviRecepti();

    }
    @PostMapping
    public void dodajRecept(@RequestBody Recept recept){ // @RB zapravo konvertuje json u java objekat i zato nam je on potreban
        receptService.dodajRecept(recept);
    }
    @GetMapping("/{id}")
    public Recept nadjiRecept(@PathVariable Long id){
        return receptService.nadjiRecept(id);
    }
    @PutMapping("/{id}")
    public void promeniRecept(@PathVariable Long id, @RequestBody Recept recept){
        receptService.promeniRecept(id, recept);
    }
    @DeleteMapping("/{id}")
    public void obrisiRecept(@PathVariable Long id){
        receptService.obrisiRecept(id);
    }

    @PutMapping("/{id}/kategorija/{kategorija_id}")
    public void dodajKategorijuReceptu (@PathVariable Long id, @PathVariable Long kategorija_id){
        receptService.dodajKategorijuReceptu(id,kategorija_id);
    }
    @GetMapping("/kategorija/{kategorija_id}")
    public List<Recept> sviReceptiPoKategoriji(@PathVariable Long kategorija_id){
        return receptService.sviReceptiPoKategoriji(kategorija_id);
    }
    @PutMapping("/{id}/video")
    public ResponseEntity<String> dodajVideo(@PathVariable Long id, @RequestBody VideoDTO videoDTO){
        receptService.dodajVideoReceptu(id, videoDTO.getVideoRecept());
        return ResponseEntity.ok("Video recepta je usppesno dodat");
    }
}
