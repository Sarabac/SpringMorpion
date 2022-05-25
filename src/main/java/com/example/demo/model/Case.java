package com.example.demo.model;

import jakarta.persistence.*;

import lombok.Getter;
import lombok.ToString;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

//@Value

@Entity
@Immutable
@Getter
@ToString
@Subselect("Select " +
        "rownum id ,  j.partie_id , j.joueur_id , " +
        "m.x , m.y , j.symbole , j.couleur  " +
        "from jouer j INNER JOIN marque m ON j.id=m.jouer_id " +
        "INNER JOIN joueur k on k.id=j.joueur_id")
public class Case {
    @Id
    Integer id;
    Integer partieId;
    Integer joueurId;
    Integer x;
    Integer y;
    char symbole;
    String couleur;
}
