package com.projekat.KnjigaRecepata.HendlovanjeGresaka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandling {

    // ubacicemo i logovanje da bismo mi znali sta se desava kada se izvrsava kod
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandling.class);

    // potreban exceotion kada nesto nije pronadjeno
    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<Map<String, Object>> elementNijeNadjen(NoSuchElementException ex){
        // dodajemo logger
        logger.warn("Element nije pronadjen: {}", ex.getMessage());

        // pravimo mapu da bi nam vracalo poruku i status zajedno
        Map<String,Object> body = new HashMap<>();
        // dodajemo poruku
        body.put("poruka",ex.getMessage());
        // dodajemo status koji postoji i njegovu vrednost za gresku (404)
        body.put("status", HttpStatus.NOT_FOUND.value());
        // vracamo json sa statusom 404 i bodijem koji smo napravili
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(body);
    }

    // potreban nam je exception kada podaci nisu u redu
    // (npr. nesto je ostavljeno prazno a ne sme biti ili nije u range koji smo oznacili da mora biti)
    @ExceptionHandler (MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> pogresniPodaci(MethodArgumentNotValidException ex){

        logger.warn("Greska je u validaciji podataka");

        // ovde nam je u mapi kljuc ime polja a vrednost poruka greske
        Map<String, String> greske = new HashMap<>();

        // imamo prvo Binding koji dohvata sve podatke vezane za validaciju
        // onda imamo sve greske na pojedinim poljima
        // zatim svaku gresku dodajemo u mapu
        // zatim u greske dodajemo ime polja gde je greska i poruku validacije
        ex.getBindingResult().getFieldErrors().forEach(greska ->{
            greske.put(greska.getField(), greska.getDefaultMessage());
        });

        // na kraju vracamo to sa kodom greske (400)

        return new ResponseEntity<>(greske, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler (Exception.class)
    // potreban nam je i generalni hendler za ostale greske
    public ResponseEntity<Map<String,Object>> generalniHendler(Exception ex){

        logger.error("Doslo je do neocekivane greske.", ex);
        // napravicemo mapu koja vraca poruku i kod greske
        Map<String, Object> body = new HashMap<>();
        body.put("poruka", "Doslo je do greske.");
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(body);
    }
}
