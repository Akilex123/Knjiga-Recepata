package com.projekat.KnjigaRecepata.Repositorijumi;

import com.projekat.KnjigaRecepata.Entiteti.Kategorija;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KategorijaRepository extends JpaRepository<Kategorija,Long> {
}
