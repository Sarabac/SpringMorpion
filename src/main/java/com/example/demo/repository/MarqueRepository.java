package com.example.demo.repository;

import com.example.demo.model.Marque;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarqueRepository extends CrudRepository<Marque, Integer> {
    @Query(value = "Select COUNT(*) " +
            "from marque m inner join jouer j on j.id=m.jouer_id " +
            "where j.partie_id= (SELECT t.partie_id from Jouer t WHERE t.id=?1) " +
            "and m.x=?2 and m.y=?3", nativeQuery = true)
    int nbMarqueSamePositionByJouerId(int jouer_id, int x, int y);
}
