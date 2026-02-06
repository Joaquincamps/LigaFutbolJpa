package com.spain.league.dto;

import com.spain.league.modelo.Deportista;
import com.spain.league.modelo.Patrocinador;

import java.util.Set;

public class EquipoDto {

    private Long idEquipo;
    private String nombreEquipo;
    private Set<Deportista> deportistas;
    private Set<Patrocinador> patrocinadores;
    private int puntos;

    public EquipoDto(Long idEquipo, String nombreEquipo, Set<Deportista> deportistas, Set<Patrocinador> patrocinadores) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.deportistas = deportistas;
        this.patrocinadores = patrocinadores;
    }

    public EquipoDto(Long idEquipo, String nombreEquipo, int puntoas) {
        this.idEquipo = idEquipo;
        this.nombreEquipo = nombreEquipo;
        this.puntos = puntoas;
    }

    public EquipoDto() {
    }

    public Long getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(Long idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombreEquipo() {
        return nombreEquipo;
    }

    public void setNombreEquipo(String nombreEquipo) {
        this.nombreEquipo = nombreEquipo;
    }

    public Set<Deportista> getDeportistas() {
        return deportistas;
    }

    public void setDeportistas(Set<Deportista> deportistas) {
        this.deportistas = deportistas;
    }

    public Set<Patrocinador> getPatrocinadores() {
        return patrocinadores;
    }

    public void setPatrocinadores(Set<Patrocinador> patrocinadores) {
        this.patrocinadores = patrocinadores;
    }

    @Override
    public String toString() {
        return "EquipoDto{" +
                "idEquipo=" + idEquipo +
                ", nombreEquipo='" + nombreEquipo + '\'' +
                ", deportistas=" + deportistas +
                ", patrocinadores=" + patrocinadores +
                '}';
    }
}
