package com.spain.league.modelo;

import jakarta.persistence.*;
import jdk.jfr.Name;

@Entity(name = "sponsor")
public class Patrocinador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nombre;

    @Column(name = "country")
    private String pais;


}
