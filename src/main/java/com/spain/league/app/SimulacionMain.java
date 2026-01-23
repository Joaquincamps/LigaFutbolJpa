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

            LigaDaoJpa ligaDaoJpa = new LigaDaoJpa(em);
            LigaServicio ligaServicio = new LigaServicio(ligaDaoJpa);
            ligaServicio.crearLigaDesdeDatos();
            ligaServicio.crearEquipoConEntrenador();





            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en la entidad.");
        } finally {
            emf.close();
            em.close();
        }
    }
}
