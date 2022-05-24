package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Entity
@Table
@Setter
@Getter
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int x;

    private int y;

    private Timestamp creation;

    @OneToMany(cascade = CascadeType.ALL)
    @Column(name = "jouer_id")
    private Jouer jouer;
}
