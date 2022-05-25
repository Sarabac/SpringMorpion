package com.example.demo.controller;

import com.example.demo.model.Partie;
import com.example.demo.service.PartieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PartieController {
    @Autowired
    private PartieService partieService;

    @GetMapping("/Parties")
    public String getParties(){
        return "parties";
    }
}
