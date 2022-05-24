package com.example.demo.repository;

import com.example.demo.model.Marque;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarqueRepository extends CrudRepository<Marque, Integer> {
}
