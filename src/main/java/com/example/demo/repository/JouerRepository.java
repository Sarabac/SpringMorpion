package com.example.demo.repository;

import com.example.demo.model.Case;
import com.example.demo.model.Jouer;
import com.example.demo.model.Partie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JouerRepository extends CrudRepository<Jouer, Integer> {
    Partie findPartieByPartieId(int id);

    @Query(value = "Select m.x AS x, m.y AS y, j.couleur AS couleur, j.symbole AS symbole " +
            "from marque m inner join jouer j on j.id=m.jouer_id " +
            "where j.partie_id=?1", nativeQuery = true)
    Iterable<Case> findCaseByPartieId(int id);
}
