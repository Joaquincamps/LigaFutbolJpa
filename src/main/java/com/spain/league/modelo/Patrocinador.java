package com.spain.league.modelo;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity(name = "sponsor")
public class Patrocinador {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String nombre;

    @Column(name = "country")
    private String pais;

    @ManyToMany
    @JoinTable(name = "sponsor_team",
    joinColumns = @JoinColumn(name = "patrocinador_id"),
    inverseJoinColumns = @JoinColumn(name = "equipo_id"))
    private Set<Equipo> equipos;

    //metodo helper
    public void agregarEquipo(Equipo equipo){
        this.equipos.add(equipo);
        equipo.getPatrocinadores().add(this);
    }

    public void eliminarEquipo(Equipo equipo){
        this.equipos.remove(equipo);
        equipo.getPatrocinadores().add(null);
    }
    public Patrocinador() {
    }

    public Patrocinador(String nombre, String pais) {
        this.nombre = nombre;
        this.pais = pais;
        this.equipos = new HashSet<>();
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public Set<Equipo> getEquipos() {
        return equipos;
    }

    public void setEquipos(Set<Equipo> equipos) {
        this.equipos = equipos;
    }

    @Override
    public String toString() {
        return "Patrocinador{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", pais='" + pais + '\'' +
                '}';
    }
}
