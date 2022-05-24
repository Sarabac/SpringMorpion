package com.example.demo.service;

import com.example.demo.model.Marque;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Timestamp;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MarqueServiceTest {

    @Autowired
    private MarqueService marqueService;

    @Test
    void contextLoads() {
    }

    void enregistrement_marque(){

        Marque m1 = new Marque();
        m1.setX(1);
        m1.setY(2);
        m1.setCreation(Timestamp.valueOf("2022-02-05 14:40:30"));
        m1 = marqueService.saveMarque(m1);
        System.out.println(m1);
        assertTrue(m1.getId() != 0);
    }
}