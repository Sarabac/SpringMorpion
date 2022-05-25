package com.example.demo.repository;

import com.example.demo.model.Case;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaseRepository extends CrudRepository<Case, Integer> {
    Iterable<Case> findByPartieId(int id);
}
