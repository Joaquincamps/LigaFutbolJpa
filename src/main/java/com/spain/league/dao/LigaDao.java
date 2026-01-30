package com.spain.league.dao;

import com.spain.league.modelo.Equipo;
import com.spain.league.modelo.Liga;

import java.util.List;

public interface LigaDao {

    void crearLiga(Liga liga);

    void agregarEquiposLiga(Equipo equipo);

     void actualizarLiga(Liga liga);

     List<Liga> mostarCaracteristicasLiga();
}
