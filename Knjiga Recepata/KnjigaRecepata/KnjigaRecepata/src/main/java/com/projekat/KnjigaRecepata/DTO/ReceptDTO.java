package com.projekat.KnjigaRecepata.DTO;
// ono sto ovde radimo je da pravimo dto klasu koja zapravo prikazuje samo
// sta mi zelimo da se prikaze korisniku
public class ReceptDTO {
    private String naziv;
    private String vremePripreme;
    private String videoRecept;
    // konstruktor
    public ReceptDTO(){}
    public ReceptDTO(String naziv, String vremePripreme, String videoRecept){
        this.naziv = naziv;
        this.vremePripreme = vremePripreme;
        this.videoRecept = videoRecept;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getVremePripreme() {
        return vremePripreme;
    }

    public String getVideoRecept() {
        return videoRecept;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setVremePripreme(String vremePripreme) {
        this.vremePripreme = vremePripreme;
    }

    public void setVideoRecept(String videoRecept) {
        this.videoRecept = videoRecept;
    }
}

