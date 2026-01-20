package com.spain.league.modelo;

import jakarta.persistence.*;

@Entity(name = "League")
public class Liga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nameLeague")
    private String nombreLiga;

    @Column(name = "category")
    private String categoria;

    public Liga() {
    }

    public Liga(String nombreLiga, String categoria) {
        this.nombreLiga = nombreLiga;
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreLiga() {
        return nombreLiga;
    }

    public void setNombreLiga(String nombreLiga) {
        this.nombreLiga = nombreLiga;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Liga{" +
                "id=" + id +
                ", nombreLiga='" + nombreLiga + '\'' +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
