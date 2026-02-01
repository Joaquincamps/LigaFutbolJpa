package com.spain.league.dao;

import com.spain.league.dto.EquipoDto;
import com.spain.league.modelo.Equipo;

import java.util.List;
import java.util.Set;

public interface EquipoDao {

    void agregarEquipos(Equipo equipo);

    EquipoDto listarDeportistasPatrocinadoresPorEquipo(int id);
}
