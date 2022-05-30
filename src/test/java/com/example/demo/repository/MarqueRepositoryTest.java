package com.example.demo.repository;

import com.example.demo.model.Jouer;
import com.example.demo.model.Marque;
import com.example.demo.model.Partie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Sql(scripts = "/serviceDataTest.sql")
class MarqueRepositoryTest {

    @Autowired
    private PartieRepository partieRepository;
    @Autowired
    private JouerRepository jouerRepository;

    @Autowired
    private MarqueRepository marqueRepository;

    @Test
    public void verifiePositionUniquesPartPartie(){
        Partie p1 = new Partie();
        Partie p2 = new Partie();
        p1.setNby(4);
        p1.setNbx(6);
        p1 = partieRepository.save(p1);

        Jouer t1 = new Jouer();
        t1.setPartie(p1);
        t1 = jouerRepository.save(t1);

        Jouer t2 = new Jouer();
        t2.setPartie(p1);
        t2 = jouerRepository.save(t2);

        Marque m1 = new Marque();
        m1.setY(1);
        m1.setX(2);
        m1.setJouer(t1);
        m1 = marqueRepository.save(m1);

        Marque m2 = new Marque();
        m2.setY(1);
        m2.setX(3);
        m2.setJouer(t1);
        m2 = marqueRepository.save(m2);

        int count = marqueRepository.nbMarqueSamePositionByJouerId(
                m1.getJouer().getId(),
                m1.getX(),
                m1.getY()
        );
        assertEquals(1, count);

        Marque m3 = new Marque();
        m3.setY(1);
        m3.setX(2);
        m3.setJouer(t2);
        m3 = marqueRepository.save(m3);

        count = marqueRepository.nbMarqueSamePositionByJouerId(
                m1.getJouer().getId(),
                m1.getX(),
                m1.getY()
        );
        assertEquals(2, count);
    }

}