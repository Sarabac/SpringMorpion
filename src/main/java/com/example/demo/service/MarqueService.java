package com.example.demo.service;

import com.example.demo.model.Marque;
import com.example.demo.repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MarqueService {

    @Autowired
    private MarqueRepository marqueRepository;

    public Optional<Marque> getMarqueById(int id){
        return marqueRepository.findById(id);
    }

    public Marque saveMarque(Marque marque){
        return marqueRepository.save(marque);
    }


}
