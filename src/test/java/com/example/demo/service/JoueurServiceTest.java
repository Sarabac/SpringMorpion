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
        j1 = joueurService.addJoueur(j1);
        System.out.println(j1.getId());
        j2 = joueurService.addJoueur(j2);
        System.out.println(j2.getId());
    }
}