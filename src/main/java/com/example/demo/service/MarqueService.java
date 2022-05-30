package com.example.demo.service;

import com.example.demo.model.Jouer;
import com.example.demo.model.Marque;
import com.example.demo.repository.MarqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional
public class MarqueService {

    @Autowired
    private MarqueRepository marqueRepository;

    @Autowired
    private JouerService jouerService;

    public Optional<Marque> getMarqueById(int id){
        return marqueRepository.findById(id);
    }

    public Marque saveMarque(Marque marque){
        return marqueRepository.save(marque);
    }

    public Boolean sansDoublon(Marque marque){
        int compteur = marqueRepository.nbMarqueSamePositionByJouerId(
                marque.getJouer().getId(),
                marque.getX(),
                marque.getY()
        );
        return compteur<1;
    }

    public Optional<Marque> save(int jouer_id, int x, int y ){
        Optional<Jouer> optJouer = jouerService.getJouerById(jouer_id);
        if(optJouer.isPresent()) {
            Marque marque = new Marque();
            Jouer jouer = optJouer.get();
            marque.setX(x);
            marque.setY(y);
            marque.setJouer(jouer);
            return this.save(marque);
        }else{
            return Optional.empty();
        }
    }
    public  Optional<Marque> save(Marque marque){
        if (this.sansDoublon(marque)){
            marque.setCreation(Timestamp.valueOf(LocalDateTime.now()));
            marque = marqueRepository.save(marque);
            return Optional.of(marque);
        }else{
            return Optional.empty();
        }
    }


}
