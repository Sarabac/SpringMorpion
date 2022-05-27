package com.example.demo.controller;

import static org.hamcrest.CoreMatchers.is;

import com.example.demo.service.JouerService;
import com.example.demo.service.PartieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(controllers = JouerController.class)
class JouerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JouerService jouerService;


    @Test
    void dimtest()throws Exception{
        mockMvc.perform(get("/api/jouer/4/dim"))
                .andExpect(status().isOk());
              //  .andExpect(jsonPath("$[0]", is(5)));

    }

}