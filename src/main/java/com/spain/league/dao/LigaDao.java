package com.spain.league.dao;

import com.spain.league.modelo.Equipo;
import com.spain.league.modelo.Liga;

public interface LigaDao {

    void crearLiga(Liga liga);

    void agregarEquiposLiga(Equipo equipo);

     void actualizarLiga(Liga liga);
}
