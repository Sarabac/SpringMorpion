package com.example.demo.service;

import com.example.demo.model.Partie;
import com.example.demo.repository.PartieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PartieService {

    @Autowired
    private PartieRepository partieRepository;

    public Optional<Partie> getPartieById(int id){
        return partieRepository.findById(id);
    }

    public Partie savePartie(Partie partie){
        return partieRepository.save(partie);
    }
}
