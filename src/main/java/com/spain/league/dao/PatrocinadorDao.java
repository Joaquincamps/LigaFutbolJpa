package com.spain.league.dao;

import com.spain.league.modelo.Equipo;
import com.spain.league.modelo.Patrocinador;

import java.util.List;

public interface PatrocinadorDao {

    void guardarPatrocinador(Patrocinador patrocinador);

    List<Patrocinador> listarPatrocinadores(int id);

    List<Patrocinador> listarPatrocinadoresPorDosEquipos(int idEquipo1, int idEquipo2);
}

