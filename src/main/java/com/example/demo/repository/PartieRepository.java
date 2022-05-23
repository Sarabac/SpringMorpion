package com.example.demo.repository;

import com.example.demo.model.Partie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartieRepository extends CrudRepository<Partie, Integer> {
}
