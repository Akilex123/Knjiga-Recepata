package com.projekat.KnjigaRecepata.Controlleri;

import com.projekat.KnjigaRecepata.Entiteti.Kategorija;
import com.projekat.KnjigaRecepata.Servisi.KategorijaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/kategorija")
public class KategorijaController {
    private final KategorijaService kategorijaService;

    @Autowired
    public KategorijaController(KategorijaService kategorijaService){
        this.kategorijaService = kategorijaService;
    }

    @GetMapping
    public List<Kategorija> sveKategorije(){
       return kategorijaService.sveKategorije();
    }

    @PostMapping
    public void dodajKategoriju (@RequestBody Kategorija kategorija){
        kategorijaService.dodajKategoriju(kategorija);
    }


    @DeleteMapping("/{id}")
    public void obrisiKategoriju(@PathVariable Long id){
        kategorijaService.obrisiKategoriju(id);
    }
}
