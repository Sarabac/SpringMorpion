package com.example.demo.repository;

import com.example.demo.model.Joueur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JoueurRepository extends CrudRepository<Joueur, Integer> {
}