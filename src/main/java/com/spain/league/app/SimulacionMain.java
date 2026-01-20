package com.spain.league.app;

import com.spain.league.config.JpaUtil;
import com.spain.league.dao.PatrocinadorDao;
import com.spain.league.dao.jpa.*;
import com.spain.league.modelo.Entrenador;
import com.spain.league.modelo.Equipo;
import com.spain.league.modelo.Liga;
import com.spain.league.servicio.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

/**
 * Hello world!
 */
public class SimulacionMain {
    public static void main(String[] args) {

        EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        try {

            em.getTransaction().begin();
            /*
            LigaDaoJpa ligaDaoJpa = new LigaDaoJpa(em);
            LigaServicio ligaServicio = new LigaServicio(ligaDaoJpa);
            ligaServicio.crearLigaDesdeDatos();

            EquipoDaoJpa equipoDaoJpa = new EquipoDaoJpa(em);
            EquipoServicio equipoServicio = new EquipoServicio(equipoDaoJpa);
            equipoServicio.crearEquipos();

            DeportistaDaoJpa deportistaDaoJpa = new DeportistaDaoJpa(em);
            DeportistaServicio deportistaServicio = new DeportistaServicio(deportistaDaoJpa);
            deportistaServicio.crearDeportistasDeDatos();

            EntrenadorDaoJpa entrenadorDaoJpa = new EntrenadorDaoJpa(em);
            EntrenadorServicio entrenadorServicio = new EntrenadorServicio(entrenadorDaoJpa);
            entrenadorServicio.crearEntrenadorDeDatos();

            PatrocinadorDaoJpa patrocinadorDaoJpa = new PatrocinadorDaoJpa(em);
            PatrocinadorServicio patrocinadorServicio = new PatrocinadorServicio(patrocinadorDaoJpa);
            patrocinadorServicio.crearPatrocinadoresDesdeDatos();

            ligaServicio.crearEquiposYEntrenadores();
            */
            EquipoDaoJpa equipoDaoJpa = new EquipoDaoJpa(em);
            EntrenadorDaoJpa entrenadorDaoJpa = new EntrenadorDaoJpa(em);

            Entrenador t1 = new Entrenador("Hansi Flick", "Alemana",null);          // FC Barcelona
            Entrenador t2 = new Entrenador("Carlo Ancelotti", "Italiana",null);     // Real Madrid
            Entrenador t3 = new Entrenador("Marcelino García Toral", "Española", null);
            Entrenador t4 = new Entrenador("Diego Simeone", "Argentina", null);
            Entrenador t5 = new Entrenador("Manolo González", "Española", null);
            Entrenador t6 = new Entrenador("Manuel Pellegrini", "Chilena", null);
            Entrenador t7 = new Entrenador("Claudio Giráldez", "Española", null);
            Entrenador t8 = new Entrenador("Ernesto Valverde", "Española", null);
            Entrenador t9 = new Entrenador("Míchel Sánchez", "Española", null);
            Entrenador t10 = new Entrenador("Sebastián Beccacece", "Argentina", null);

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
            e1.asignarEntrenador(t1);
            e2.asignarEntrenador(t2);
            e3.asignarEntrenador(t3);
            e4.asignarEntrenador(t4);
            e5.asignarEntrenador(t5);
            e6.asignarEntrenador(t6);
            e7.asignarEntrenador(t7);
            e8.asignarEntrenador(t8);
            e9.asignarEntrenador(t9);
            e10.asignarEntrenador(t10);

            equipoDaoJpa.agregarEquipos(e1);
            equipoDaoJpa.agregarEquipos(e2);
            equipoDaoJpa.agregarEquipos(e3);
            equipoDaoJpa.agregarEquipos(e4);
            equipoDaoJpa.agregarEquipos(e5);
            equipoDaoJpa.agregarEquipos(e6);
            equipoDaoJpa.agregarEquipos(e7);
            equipoDaoJpa.agregarEquipos(e8);
            equipoDaoJpa.agregarEquipos(e9);
            equipoDaoJpa.agregarEquipos(e10);

            entrenadorDaoJpa.agregarEntrenador(t1);
            entrenadorDaoJpa.agregarEntrenador(t2);
            entrenadorDaoJpa.agregarEntrenador(t3);
            entrenadorDaoJpa.agregarEntrenador(t4);
            entrenadorDaoJpa.agregarEntrenador(t5);
            entrenadorDaoJpa.agregarEntrenador(t6);
            entrenadorDaoJpa.agregarEntrenador(t7);
            entrenadorDaoJpa.agregarEntrenador(t8);
            entrenadorDaoJpa.agregarEntrenador(t9);
            entrenadorDaoJpa.agregarEntrenador(t10);

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en la entidad.");
        } finally {
            emf.close();
            em.close();
        }
    }
}
