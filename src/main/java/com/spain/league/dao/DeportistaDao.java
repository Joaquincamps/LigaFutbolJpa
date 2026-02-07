package com.spain.league.dao;

import com.spain.league.dto.DeportistasPorNacionalidadDTO;
import com.spain.league.modelo.Deportista;

import java.util.List;

public interface DeportistaDao {

    void crearDeportista(Deportista deportista);

    List<Deportista> listarDeportistas(int idEquipo);

    double calcularEdadPromedioPorEquipo(int id);

    List<DeportistasPorNacionalidadDTO> DeportistasPorNacionaliaddMayores_23();

    List<Deportista> listarFichajes();

    List<Deportista> criteriaQueryNum1();

    List<Deportista> criteriaQueryNum2();

    List<Deportista> criteriaQueryNum3();

}
