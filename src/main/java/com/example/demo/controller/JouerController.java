package com.example.demo.controller;

import com.example.demo.model.Marque;
import com.example.demo.service.JouerService;
import com.example.demo.service.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/jouer")
public class JouerController {
    @Autowired
    private JouerService jouerService;

    @Autowired
    private MarqueService marqueService;

    @GetMapping("/{id}/dim")
    public int[] dim(@PathVariable("id") final int id){
        return new int[]{5,7};
    }

    @PostMapping("/{id}/marque")
    public Marque saveMarque(@RequestBody Marque marque, @PathVariable("id") int id){
        Optional<Marque> optMarque = marqueService.save(marque, id);
        return optMarque.orElseGet(Marque::new);
    }


}
