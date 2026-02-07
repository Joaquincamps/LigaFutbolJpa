package com.spain.league.dao;

import com.spain.league.dto.EquipoDto;
import com.spain.league.modelo.Equipo;

import java.util.List;

public interface EquipoDao {

    void agregarEquipos(Equipo equipo);

    EquipoDto listarDeportistasPatrocinadoresPorEquipo(int id);

    List<EquipoDto> mostrarEquiposPorOrdenDesc();

    List<EquipoDto> mostrarEquiposPorOrdenAsc();

    List<Equipo> visualizarClasificacion();

    Long contarJugadoresComp();

}
