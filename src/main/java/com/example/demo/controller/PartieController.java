package com.example.demo.controller;

import com.example.demo.model.Partie;
import com.example.demo.service.PartieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PartieController {
    @Autowired
    private PartieService partieService;

    @GetMapping("/Parties")
    public Iterable<Partie> getParties(){
        return partieService.getParties();
    }
}
