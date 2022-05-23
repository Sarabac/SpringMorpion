package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table
@Getter
@Setter
@ToString
public class Partie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int nbx;
    private int nby;
    private int nbjoueur;

    private Timestamp debut;

    private Timestamp fin;


}
