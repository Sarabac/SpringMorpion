package com.example.demo.service;

import com.example.demo.repository.PartieRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PartieServiceTest {

    @Autowired
    private PartieRepository partieRepository;
    @Test
    void contextLoads() {
    }
}