package com.projekat.KnjigaRecepata.Entiteti;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Kategorija {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long kategorija_id;

    private String vrstaObroka;

    public long getKategorija_id() {
        return kategorija_id;
    }

    public String getVrstaObroka() {
        return vrstaObroka;
    }

    public void setKategorija_id(long kategorija_id) {
        this.kategorija_id = kategorija_id;
    }

    public void setVrstaObroka(String vrstaObroka) {
        this.vrstaObroka = vrstaObroka;
    }
}
