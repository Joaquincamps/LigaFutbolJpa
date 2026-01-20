package com.spain.league.servicio;

import com.spain.league.dao.EquipoDao;
import com.spain.league.modelo.Equipo;

import java.util.HashSet;
import java.util.Set;

public class EquipoServicio {

    private final EquipoDao equipoDao;

    public EquipoServicio(EquipoDao equipoDao) {
        this.equipoDao = equipoDao;
    }

    public void crearEquipos() {
        Set<Equipo> equipos = new HashSet<>();
        Equipo e1 = new Equipo("FC Barcelona", "Camp Nou", "Barcelona", 53, 20, 49);
        Equipo e2 = new Equipo("Real Madrid", "Santiago Bernabéu", "Madrid", 41, 17, 45);
        Equipo e3 = new Equipo("Villarreal CF", "Estadio de la Cerámica", "Villarreal", 37, 17, 41);
        Equipo e4 = new Equipo("Atlético de Madrid", "Wanda Metropolitano", "Madrid", 34, 17, 38);
        Equipo e5 = new Equipo("RCD Espanyol", "RCDE Stadium", "Barcelona", 23, 22, 34);
        Equipo e6 = new Equipo("Real Betis", "Benito Villamarín", "Sevilla", 31, 25, 29);
        Equipo e7 = new Equipo("Celta de Vigo", "Abanca Balaídos", "Vigo", 25, 20, 29);
        Equipo e8 = new Equipo("Athletic Club", "San Mamés", "Bilbao", 19, 28, 24);
        Equipo e9 = new Equipo("Girona FC", "Estadi Montilivi", "Girona", 20, 34, 24);
        Equipo e10 = new Equipo("Elche CF", "Estadio Manuel Martínez Valero", "Elche", 25, 24, 23);
        equipos.add(e1);
        equipos.add(e2);
        equipos.add(e3);
        equipos.add(e4);
        equipos.add(e5);
        equipos.add(e6);
        equipos.add(e7);
        equipos.add(e8);
        equipos.add(e9);
        equipos.add(e10);
        for (Equipo equipo : equipos) {
            equipoDao.agregarEquipos(equipo);
        }
    }
}
