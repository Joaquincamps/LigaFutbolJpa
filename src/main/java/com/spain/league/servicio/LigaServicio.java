package com.spain.league.servicio;

import com.spain.league.dao.LigaDao;
import com.spain.league.modelo.Entrenador;
import com.spain.league.modelo.Equipo;
import com.spain.league.modelo.Liga;

import java.util.Set;

public class LigaServicio {

    private static String nombreLiga = "LaLiga EA Sports";
    private static String categoria = "Primera División";

    public static String getNombreLiga() {
        return nombreLiga;
    }

    public static String getCategoria() {
        return categoria;
    }

    private LigaDao ligaDao;


    public LigaServicio(LigaDao ligaDao) {
        this.ligaDao = ligaDao;
    }


    public void crearLigaDesdeDatos() {
        Liga liga = new Liga(nombreLiga, categoria);
        ligaDao.crearLiga(liga);
    }


}
