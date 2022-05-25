package com.example.demo.repository;

import com.example.demo.model.Case;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Test
    void testPrimaire(){

        Iterable<Case> cases = caseRepository.findAll();
        System.out.println(cases);


    }

}