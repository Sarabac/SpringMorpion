package com.example.demo.service;

import com.example.demo.model.Jouer;
import com.example.demo.model.Joueur;
import com.example.demo.model.Partie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JouerServiceTest {

    @Autowired
    private JouerService jouerService;
    @Autowired
    private JoueurService joueurService;
    @Autowired
    private PartieService partieService;

    @Test
    void contextLoads() {
    }

    @Test
    @Transactional
    void relationsJouerTest(){
        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        Partie p1 = new Partie();
        Jouer jeu1 = new Jouer();
        Jouer jeu2 = new Jouer();

        j1.setNom("Jean");
        j1.setPwd("secret");
        j1 = joueurService.saveJoueur(j1);

        j2.setNom("Marie");
        j2.setPwd("mystere");
        j2 = joueurService.saveJoueur(j2);

        p1.setNbjoueur(2);
        p1.setNbx(3);
        p1.setNby(3);
        p1 = partieService.savePartie(p1);

        jeu1.setJoueur(j1);
        jeu1.setPartie(p1);
        jeu1 = jouerService.saveJouer(jeu1);

        jeu2.setJoueur(j2);
        jeu2.setPartie(p1);
        jeu2 = jouerService.saveJouer(jeu2);

        System.out.println(jeu1);
        System.out.println(jeu2);


    }

}