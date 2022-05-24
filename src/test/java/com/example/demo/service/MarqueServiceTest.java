package com.example.demo.service;

import com.example.demo.model.Jouer;
import com.example.demo.model.Marque;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Sql(scripts = "/serviceDataTest.sql")
class MarqueServiceTest {

    @Autowired
    private MarqueService marqueService;

    @Autowired
    private JouerService jouerService;

    @Test
    void contextLoads() {
    }

    @Test
    void enregistrement_marque(){

        Marque m1 = new Marque();
        Jouer jeu = new Jouer();
        m1.setX(1);
        m1.setY(2);
        m1.setCreation(Timestamp.valueOf("2022-02-05 14:40:30"));
        m1 = marqueService.saveMarque(m1);

        jeu.setSymbole('X');
        jeu.setCouleur("red");
        jeu = jouerService.saveJouer(jeu);

        m1.setJouer(jeu);
        m1 = marqueService.saveMarque(m1);

        System.out.println(m1);
        assertTrue(m1.getId() != 0);
    }
}