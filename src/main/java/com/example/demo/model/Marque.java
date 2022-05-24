package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Timestamp;

@Entity
@Table
@Setter
@Getter
@ToString
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int x;

    private int y;

    private Timestamp creation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jouer_id")
    private Jouer jouer;
}
