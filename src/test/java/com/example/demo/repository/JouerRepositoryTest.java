package com.example.demo.repository;

import com.example.demo.model.Jouer;
import com.example.demo.model.Partie;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Sql(scripts = "/serviceDataTest.sql")
class JouerRepositoryTest {

    @Autowired
    private PartieRepository partieRepository;
    @Autowired
    private JouerRepository jouerRepository;

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

    }

}