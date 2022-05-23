package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table
@Getter
public class Joueur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
}
