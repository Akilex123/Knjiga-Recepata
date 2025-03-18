package com.projekat.KnjigaRecepata.Entiteti;

import jakarta.persistence.*;

@Entity
public class Recept {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String naziv;
    private String vremePripreme;
    private String videoRecept;

    @ManyToOne
    @JoinColumn(name = "kategorija_id")
    Kategorija kategorija;

    public Long getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getVremePripreme() {
        return vremePripreme;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setVremePripreme(String vremePripreme) {
        this.vremePripreme = vremePripreme;
    }

    public Kategorija getKategorija() {
        return kategorija;
    }

    public void setKategorija(Kategorija kategorija) {
        this.kategorija = kategorija;
    }

    public String getVideoRecept() {
        return videoRecept;
    }

    public void setVideoRecept(String videoRecept) {
        this.videoRecept = videoRecept;
    }
}
