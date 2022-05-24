package com.example.demo.service;

import com.example.demo.model.Joueur;
import com.example.demo.repository.JoueurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JoueurService {

    @Autowired
    private JoueurRepository joueurRepository;

    public Optional<Joueur> getJoueurById(Integer id){
        return joueurRepository.findById(id);
    }

    public Iterable<Joueur> getJoueurs(){
        return joueurRepository.findAll();
    }

    public Joueur saveJoueur(Joueur joueur){
        return joueurRepository.save(joueur);
    }
}
