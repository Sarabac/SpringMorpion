package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Entity
@Table
@Getter
@Setter
public class Partie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int nbx;
    private int nby;
    private int nbjoueur;

    @Temporal(TemporalType.TIMESTAMP)
    private Date debut;

    @Temporal(TemporalType.TIMESTAMP)
    private Date fin;


}
