package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table
@Setter
@Getter
@ToString
public class Jouer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "partie_id")
    private Partie partie;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "joueur_id")
    private Joueur joueur;

    private char symbole;

    private String couleur;
}
