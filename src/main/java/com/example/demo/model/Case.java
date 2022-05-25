package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.ToString;
import lombok.Value;
import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Subselect;

//@Value

@Entity
@Immutable
@Getter
@ToString
@Subselect("Select " +
        "rownum id , j.joueur_id joueur_id, j.partie_id partie_id, " +
        "m.x x, m.y y, j.symbole symbole, j.couleur couleur " +
        "from jouer j INNER JOIN marque m ON j.id=m.jouer_id")
public class Case {
    @Id
    Integer id;
    Integer joueur_id;
    Integer partie_id;
    Integer x;
    Integer y;
    char symbole;
    String couleur;
}
