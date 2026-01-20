package com.spain.league.servicio;

import com.spain.league.dao.LigaDao;
import com.spain.league.modelo.Liga;

public class LigaServicio {

    private static String nombreLiga = "LaLiga EA Sports";
    private static String categoria = "Primera División";

    public static String getNombreLiga() {
        return nombreLiga;
    }

    public static String getCategoria() {
        return categoria;
    }

    private final LigaDao ligaDao;

    public LigaServicio(LigaDao ligaDao) {
        this.ligaDao = ligaDao;
    }

    public void crearLigaDesdeDatos() {
        Liga liga = new Liga(nombreLiga, categoria);
        ligaDao.crearLiga(liga);
    }
}
