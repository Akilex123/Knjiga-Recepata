package com.projekat.KnjigaRecepata.Repositorijumi;

import com.projekat.KnjigaRecepata.Entiteti.Kategorija;
import com.projekat.KnjigaRecepata.Entiteti.Recept;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReceptRepository extends JpaRepository<Recept, Long> {
    // ovde kao parametar uzimamo parametar kategorija vrste Kategorija
    // zato sto spring prepoznaje da u receptu imamo ovaj parametar i da je on
    // zapravo povezan preko kategorija_id, ne moramo mi to manuelno da radimo
    // ali jeste malo zbunjujuce...
    List<Recept> findByKategorija(Kategorija kategorija);
}
