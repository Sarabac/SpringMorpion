package com.example.demo.service;

import com.example.demo.model.Joueur;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
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
        j1.setMarque('X');
        j1 = joueurService.saveJoueur(j1);
        assertEquals( 'X', j1.getMarque());
        j1.setMarque('P');
        assertEquals( 'P', j1.getMarque());
        joueurService.saveJoueur(j1);

        j2 = joueurService.saveJoueur(j2);
        assertTrue(j2.getId()>j1.getId());

        j3 = joueurService.getJoueurById(1).get();
        assertEquals( 'P', j3.getMarque());
    }
}