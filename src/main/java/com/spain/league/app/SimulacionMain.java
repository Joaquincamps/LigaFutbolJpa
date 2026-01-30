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

import java.util.List;

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
            Liga liga = ligaServicio.crearLigaDesdeDatos();
            ligaServicio.crearEquipoConEntrenador(liga);
            List<Liga> listaCompetición = ligaDaoJpa.mostarCaracteristicasLiga();
            for (Liga league : listaCompetición){
                System.out.println(league);
            }

            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en la entidad.");
        } finally {
            emf.close();
            em.close();
        }
    }
}
