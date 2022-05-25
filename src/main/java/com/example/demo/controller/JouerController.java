package com.example.demo.controller;

import com.example.demo.service.JouerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/jouer-api")
public class JouerController {
    @Autowired
    private JouerService jouerService;

    @GetMapping("/{id}/dim")
    public int[] dim(@PathVariable("id") final int id){
        return new int[]{5,7};
    }


}
