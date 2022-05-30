package com.example.demo.service;

import com.example.demo.model.Jouer;
import com.example.demo.model.Marque;
import com.example.demo.model.Partie;
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
        Marque marque = new Marque();
        marque.setX(x);
        marque.setY(y);
        return this.save(marque, jouer_id);
    }

    public  Optional<Marque> save(Marque marque, int jouer_id) {
        Optional<Jouer> optJouer = jouerService.getJouerById(jouer_id);
        if(optJouer.isPresent()) {
            Jouer jouer = optJouer.get();
            marque.setJouer(jouer);
            return this.save(marque);
        }else{
            return Optional.empty();
        }
    }
    public  Optional<Marque> save(Marque marque){
        Partie partie = marque.getJouer().getPartie();
        Boolean infX = marque.getX() < partie.getNbx();
        Boolean infY = marque.getY() < partie.getNby();
        if (infX && infY && this.sansDoublon(marque)){
            marque.setCreation(Timestamp.valueOf(LocalDateTime.now()));
            marque = marqueRepository.save(marque);
            return Optional.of(marque);
        }else{
            return Optional.empty();
        }
    }


}
