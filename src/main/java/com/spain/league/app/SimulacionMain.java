package com.spain.league.app;

import com.spain.league.config.JpaUtil;
import com.spain.league.dao.PatrocinadorDao;
import com.spain.league.dao.jpa.*;
import com.spain.league.dto.EquipoDto;
import com.spain.league.modelo.*;
import com.spain.league.servicio.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.ArrayList;
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
            PatrocinadorDaoJpa patrocinadorDaoJpa = new PatrocinadorDaoJpa(em);
            EquipoDaoJpa equipoDaoJpa = new EquipoDaoJpa(em);

            System.out.println("1) Características de la competición.");
            for (Liga league : listaCompetición) {
                System.out.println(league);
            }

            System.out.println("3) Lista de los deportistas de un id específico.");
            DeportistaDaoJpa deportistaDaoJpa = new DeportistaDaoJpa(em);
            List<Deportista> deportistasPorEquipoEspecifico =
                    deportistaDaoJpa.listarDeportistas(1);
            for (Deportista depo : deportistasPorEquipoEspecifico) {
                System.out.println(depo);
            }
            System.out.println("4) Listar patrocinadores de un equipo concreto.");
            List<Patrocinador> patrocinadoresPorEquipo = patrocinadorDaoJpa.listarPatrocinadores(3);
            for (Patrocinador patrocinador : patrocinadoresPorEquipo) {
                System.out.println(patrocinador);
            }

            System.out.println("5) Genera lista de deportista y patrocinadores vinculados a un equipo");
            EquipoDto equipoDto = equipoDaoJpa.listarDeportistasPatrocinadoresPorEquipo(2);
            System.out.println(equipoDto);

            System.out.println("6) Calcular la media de jugadores por equipo");
            Double edadMedia = deportistaDaoJpa.calcularEdadPromedioPorEquipo(4);
            System.out.println(edadMedia);

            System.out.println("7. Cuenta cuantos deportistas tienen más de veintitrés años en la competición agrupados por nacionalidad.");
            List<Deportista> consulta7 = deportistaDaoJpa.contarDeportistasPorNacionaliaddMayores_23();
            for (Deportista depo : consulta7) {
                System.out.println(depo);
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
