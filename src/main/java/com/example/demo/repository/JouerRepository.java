package com.example.demo.repository;

import com.example.demo.model.Jouer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JouerRepository extends CrudRepository<Jouer, Integer> {
}
