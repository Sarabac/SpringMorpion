package com.example.demo.service;

import com.example.demo.model.Jouer;
import com.example.demo.model.Partie;
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
        Integer[] retour = new Integer[]{null, null};
        Optional<Jouer> optJouer = jouerRepository.findById(id);
        if(optJouer.isPresent()){
            Jouer jouer = optJouer.get();
            Partie partie = jouer.getPartie();
            if(partie != null){
                retour = new Integer[]{partie.getNbx(), partie.getNby()};
            }
        }
        return retour;
    }
    public void cliquer(int jouerId, int x, int y){

    }
}
