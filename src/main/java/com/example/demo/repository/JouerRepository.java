package com.example.demo.repository;

import com.example.demo.model.Jouer;
import com.example.demo.model.Partie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JouerRepository extends CrudRepository<Jouer, Integer> {
    Partie findPartieByPartieId(int id);
}
