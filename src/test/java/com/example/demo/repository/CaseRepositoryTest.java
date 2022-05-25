package com.example.demo.repository;

import com.example.demo.model.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Sql(scripts = "/serviceDataTest.sql")
class CaseRepositoryTest {

    @Autowired
    private CaseRepository caseRepository;
    @Autowired
    private PartieRepository partieRepository;
    @Autowired
    private JouerRepository jouerRepository;
    @Autowired
    private JoueurRepository joueurRepository;
    @Autowired
    private MarqueRepository marqueRepository;

    @Test
    void testPrimaire(){

        Iterable<Case> cases = caseRepository.findAll();
        System.out.println(cases);

        Partie p1 = new Partie();
        Partie p2 = new Partie();
        p1 =partieRepository.save(p1);
        p2 =partieRepository.save(p2);


        Joueur j1 = new Joueur();
        Joueur j2 = new Joueur();
        Joueur j3 = new Joueur();
        j1 = joueurRepository.save(j1);
        j2 = joueurRepository.save(j2);
        j3 = joueurRepository.save(j3);

        System.out.println(j1);

        Jouer t1 = new Jouer();
        Jouer t2 = new Jouer();
        Jouer t3 = new Jouer();
        t1.setPartie(p1);
        t2.setPartie(p1);
        t3.setPartie(p2);
        t1.setJoueur(j1);
        t2.setJoueur(j2);
        t3.setJoueur(j3);
        t1.setSymbole('P');
        t1.setSymbole('M');
        t1.setSymbole('F');
        t1.setCouleur("blue");
        t1 = jouerRepository.save(t1);
        t2 = jouerRepository.save(t2);
        t3 = jouerRepository.save(t3);

        System.out.println("ID du joueur "+
                t1.getJoueur().getId());

        Marque m1 = new Marque();
        m1.setJouer(t1);
        m1.setX(1);
        m1.setY(1);
        marqueRepository.save(m1);
        m1.setJouer(t2);
        m1.setX(2);
        m1.setY(0);
        marqueRepository.save(m1);

        System.out.println("ID depuis marque: "+
                m1.getJouer().getJoueur().getId());

        cases = caseRepository.findByPartieId(p1.getId());
        System.out.println(cases);

        t1.setJoueur(j3);
        jouerRepository.save(t1);
        cases = caseRepository.findByPartieId(p1.getId());
        System.out.println(cases);

        System.out.println(jouerRepository.findById(t1.getId()));

    }

}