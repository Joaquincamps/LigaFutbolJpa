package com.spain.league.app;

import com.spain.league.config.JpaUtil;
import com.spain.league.dao.jpa.DeportistaDaoJpa;
import com.spain.league.dao.jpa.EntrenadorDaoJpa;
import com.spain.league.dao.jpa.EquipoDaoJpa;
import com.spain.league.dao.jpa.LigaDaoJpa;
import com.spain.league.modelo.Liga;
import com.spain.league.servicio.DeportistaServicio;
import com.spain.league.servicio.EntrenadorServicio;
import com.spain.league.servicio.EquipoServicio;
import com.spain.league.servicio.LigaServicio;
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


            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en la entidad.");
        } finally {
            emf.close();
            em.close();
        }
    }
}
