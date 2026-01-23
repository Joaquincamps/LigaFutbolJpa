package com.spain.league.modelo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "League")
public class Liga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nameLeague")
    private String nombreLiga;

    @Column(name = "category")
    private String categoria;

    @OneToMany(mappedBy = "liga",orphanRemoval = true)
    private Set<Equipo> equipos;

    //metodo helper
    public void agregarEquipo(Equipo equipo){
        if(equipo != null){
            this.equipos.add(equipo);
            equipo.setLiga(this);
        }
    }

    public void eliminarrEquipo(Equipo equipo){
        if(equipo != null){
            this.equipos.remove(equipo);
            equipo.setLiga(null);
        }
    }
    public Liga() {
    }

    public Liga(String nombreLiga, String categoria) {
        this.nombreLiga = nombreLiga;
        this.categoria = categoria;
        this.equipos = new HashSet<>();
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

    public Set<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(Set<Equipo> equipos) {
        this.equipos = equipos;
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
