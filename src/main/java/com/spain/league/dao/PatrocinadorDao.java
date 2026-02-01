package com.spain.league.dao;

import com.spain.league.modelo.Patrocinador;

import java.util.List;

public interface PatrocinadorDao {

    void guardarPatrocinador(Patrocinador patrocinador);

    List<Patrocinador> listarPatrocinadores(int id);
}

