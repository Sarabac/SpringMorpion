package com.example.demo.controller;

import com.example.demo.model.Partie;
import com.example.demo.service.PartieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PartieController {
    @Autowired
    private PartieService partieService;

    @GetMapping("/Parties")
    public String getParties(Model model){
        int[] nb = new int[]{1,4};
        model.addAttribute("nombre", nb);
        return "parties";
    }
}
