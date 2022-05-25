package com.example.demo.service;

import com.example.demo.model.Jouer;
import com.example.demo.repository.JouerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JouerService {
    @Autowired
    private JouerRepository jouerRepository;

    public Optional<Jouer> getJouerById(int id){
        return jouerRepository.findById(id);
    }
    public Jouer saveJouer(Jouer jouer){
        return jouerRepository.save(jouer);
    }

    public Iterable<Jouer> getJouers(){
        return jouerRepository.findAll();
    }

    public Integer[] getDim(int id){
        return new Integer[]{4,5};
    }
}
