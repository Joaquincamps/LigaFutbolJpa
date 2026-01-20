package com.spain.league.modelo;

import jakarta.persistence.*;

@Entity(name = "team")
public class Equipo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nombre;

    @Column(name = "stadium")
    private String estadio;

    @Column(name = "city")
    private String ciudad;

    @Column(name = "goals_for")
    private int golesAfavor;

    @Column(name = "goals_against")
    private int golesEnContra;

    @Column(name = "points")
    private int puntos;

    @OneToOne(mappedBy = "equipo")
    private Entrenador entrenador;

    //metodo helper para asignar equipo al entrenador
    public void asignarEntrenador(Entrenador entrenador){
        this.entrenador = entrenador;
        if (entrenador != null) {
            entrenador.setEquipo(this);
        }    }

    public Equipo() {
    }

    public Equipo(String nombre, String estadio, String ciudad, int golesAfavor, int golesEnContra, int puntos) {
        this.nombre = nombre;
        this.estadio = estadio;
        this.ciudad = ciudad;
        this.golesAfavor = golesAfavor;
        this.golesEnContra = golesEnContra;
        this.puntos = puntos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstadio() {
        return estadio;
    }

    public void setEstadio(String estadio) {
        this.estadio = estadio;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public int getGolesAfavor() {
        return golesAfavor;
    }

    public void setGolesAfavor(int golesAfavor) {
        this.golesAfavor = golesAfavor;
    }

    public int getGolesEnContra() {
        return golesEnContra;
    }

    public void setGolesEnContra(int golesEnContra) {
        this.golesEnContra = golesEnContra;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    public Entrenador getEntrenador() {
        return entrenador;
    }

    public void setEntrenador(Entrenador entrenador) {
        this.entrenador = entrenador;
    }

    @Override
    public String toString() {
        return "Equipo{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", estadio='" + estadio + '\'' +
                ", ciudad='" + ciudad + '\'' +
                ", golesAfavor=" + golesAfavor +
                ", golesEnContra=" + golesEnContra +
                ", puntos=" + puntos +
                '}';
    }
}
