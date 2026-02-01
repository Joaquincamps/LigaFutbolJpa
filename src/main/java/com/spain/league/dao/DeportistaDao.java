package com.spain.league.dao;

import com.spain.league.modelo.Deportista;

import java.util.List;

public interface DeportistaDao {

    void crearDeportista(Deportista deportista);

    List<Deportista> listarDeportistas (int idEquipo);

    double calcularEdadPromedioPorEquipo(int id);
}
