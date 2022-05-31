package com.example.demo.repository;

import com.example.demo.model.Case;
import com.example.demo.model.Jouer;
import com.example.demo.model.Partie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JouerRepository extends CrudRepository<Jouer, Integer> {

    @Query(value = "Select m.x AS x, m.y AS y, j.couleur AS couleur, j.symbole AS symbole " +
            "from marque m inner join jouer j on j.id=m.jouer_id " +
            "where j.partie_id=?1", nativeQuery = true)
    Iterable<Case> findCaseByPartieId(int id);
    @Query(value = "Select m.x AS x, m.y AS y, j.couleur AS couleur, j.symbole AS symbole " +
            "from marque m inner join jouer j on j.id=m.jouer_id " +
            "where j.partie_id= (SELECT t.partie_id from Jouer t WHERE t.id=?1) " +
            "and m.x=?2 and m.y=?3", nativeQuery = true)
    Optional<Case> findCase(int jouer_id, int x, int y);

    @Query(value = "SELECT j.* FROM JOUER j " +
            "LEFT JOIN marque m ON j.id=m.jouer_id " +
            "WHERE j.partie_id=?1 " +
            "GROUP BY j.id " +
            "ORDER BY count(m.id), j.ordre " +
            "LIMIT 1", nativeQuery = true)
    Optional<Jouer> findNextJouerByPartieId(int partie_id);

}
