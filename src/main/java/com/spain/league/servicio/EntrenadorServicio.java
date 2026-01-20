package com.spain.league.servicio;

import com.spain.league.dao.EntrenadorDao;
import com.spain.league.modelo.Entrenador;

import java.util.HashSet;
import java.util.Set;

public class EntrenadorServicio {

    private final EntrenadorDao entrenadorDao;

    public EntrenadorServicio(EntrenadorDao entrenadorDao) {
        this.entrenadorDao = entrenadorDao;
    }

    public void crearEntrenadorDeDatos(){
        Set<Entrenador> entrenadores = new HashSet<>();
        Entrenador t1 = new Entrenador("Hansi Flick", "Alemana");          // FC Barcelona
        Entrenador t2 = new Entrenador("Carlo Ancelotti", "Italiana");     // Real Madrid
        Entrenador t3 = new Entrenador("Marcelino García Toral", "Española"); // Villarreal CF
        Entrenador t4 = new Entrenador("Diego Simeone", "Argentina");     // Atlético de Madrid
        Entrenador t5 = new Entrenador("Manolo González", "Española");    // RCD Espanyol
        Entrenador t6 = new Entrenador("Manuel Pellegrini", "Chilena");   // Real Betis
        Entrenador t7 = new Entrenador("Claudio Giráldez", "Española");   // Celta de Vigo
        Entrenador t8 = new Entrenador("Ernesto Valverde", "Española");   // Athletic Club
        Entrenador t9 = new Entrenador("Míchel Sánchez", "Española");     // Girona FC
        Entrenador t10 = new Entrenador("Sebastián Beccacece", "Argentina"); // Elche CF
        entrenadores.add(t1);
        entrenadores.add(t2);
        entrenadores.add(t3);
        entrenadores.add(t4);
        entrenadores.add(t5);
        entrenadores.add(t6);
        entrenadores.add(t7);
        entrenadores.add(t8);
        entrenadores.add(t9);
        entrenadores.add(t10);

        for (Entrenador entrenador : entrenadores){
            entrenadorDao.agregarEntrenador(entrenador);
        }

    }
}
