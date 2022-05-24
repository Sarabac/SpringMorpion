package com.example.demo.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.example.demo.service.PartieService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.StatusAssertions;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest(controllers = PartieController.class)
class PartieControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PartieService partieService;

    @Test
    void getPartiesTest() throws Exception{
        mockMvc.perform(get("/Parties")).andExpect(status().isOk());
    }

}