package com.example.demo.service;

import com.example.demo.model.Joueur;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Sql(scripts = "/serviceDataTest.sql")
class JoueurServiceTest {

    @Autowired
    private JoueurService joueurService;

    @Test
    void contextLoads() {
    }


    @Test
    void initBDTest() {
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        Joueur j3;
        j1.setNom("Jean");
        j1 = joueurService.saveJoueur(j1);
        assertEquals( "Jean", j1.getNom());
        j1.setNom("Paula");
        assertEquals( "Paula", j1.getNom());
        joueurService.saveJoueur(j1);

        j2 = joueurService.saveJoueur(j2);
        assertTrue(j2.getId()>j1.getId());
    }

    @Test
    void getJoueursTest(){
        joueurService.getJoueurs().forEach(System.out::println);
    }
}