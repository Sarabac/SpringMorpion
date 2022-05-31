package com.example.demo.controller;

import com.example.demo.model.Jouer;
import com.example.demo.model.Marque;
import com.example.demo.model.Partie;
import com.example.demo.service.JouerService;
import com.example.demo.service.MarqueService;
import com.example.demo.service.PartieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/jouer")
public class JouerController {
    @Autowired
    private JouerService jouerService;

    @Autowired
    private MarqueService marqueService;

    @Autowired
    private PartieService partieService;

    @GetMapping("/{id}/dim")
    public Integer[] dim(@PathVariable("id") final int id){
        Integer[] retour = new Integer[]{null, null};
        Optional<Jouer> optionalJouer =  jouerService.getJouerById(id);
        if(optionalJouer.isPresent()){
            Partie partie = optionalJouer.get().getPartie();
            retour = partieService.getDim(partie);
        }
        return retour;
    }

    @PostMapping("/{id}/marque")
    public Marque saveMarque(@RequestBody Marque marque, @PathVariable("id") int id){
        Optional<Marque> optMarque = marqueService.save(marque, id);
        return optMarque.orElseGet(Marque::new);
    }


}
