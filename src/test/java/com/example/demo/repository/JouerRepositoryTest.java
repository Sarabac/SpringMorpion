package com.example.demo.repository;

import com.example.demo.model.Case;
import com.example.demo.model.Jouer;
import com.example.demo.model.Marque;
import com.example.demo.model.Partie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
@Transactional
class JouerRepositoryTest {

    @Autowired
    private PartieRepository partieRepository;
    @Autowired
    private JouerRepository jouerRepository;

    @Autowired
    private MarqueRepository marqueRepository;

    @Test
    void arraytest(){
        Partie p1 = new Partie();
        Partie p2 = new Partie();
        p1.setNby(4);
        p1.setNbx(6);
        p1 = partieRepository.save(p1);

        Jouer t1 = new Jouer();
        t1.setPartie(p1);
        t1 = jouerRepository.save(t1);

        Marque m1 = new Marque();
        m1.setY(1);
        m1.setX(2);
        m1.setJouer(t1);
        m1 = marqueRepository.save(m1);

        Iterable<Case> c1 = jouerRepository.findCaseByPartieId(p1.getId());

        c1.forEach(case2 -> {System.out.println(case2.getX());});
    }


}