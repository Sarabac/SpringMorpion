package com.example.demo.service;

import com.example.demo.model.Partie;
import com.example.demo.repository.PartieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PartieServiceTest {

    @Autowired
    private PartieService partieService;
    @Test
    void contextLoads() {
    }

    @Test
    void partieTest(){
        Partie p1 = new Partie();

        Timestamp debut = Timestamp.valueOf(LocalDateTime.now());
        long duration = Duration.ofMinutes(30).toMillis();
        Timestamp fin = new Timestamp(debut.getTime() + duration);

        p1.setNbjoueur(2);
        p1.setNbx(3);
        p1.setNby(3);
        p1.setDebut(debut);
        p1.setFin(fin);

        p1 = partieService.savePartie(p1);

        System.out.println(p1);

    }
}