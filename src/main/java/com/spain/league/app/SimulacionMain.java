package com.spain.league.app;

import com.spain.league.config.JpaUtil;
import com.spain.league.dao.PatrocinadorDao;
import com.spain.league.dao.jpa.*;
import com.spain.league.dto.DeportistasPorNacionalidadDTO;
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
            List<DeportistasPorNacionalidadDTO> listaConsulta7 = deportistaDaoJpa.DeportistasPorNacionaliaddMayores_23();
            for (DeportistasPorNacionalidadDTO deportistasPorNacionalidadDTO : listaConsulta7) {
                System.out.println(deportistasPorNacionalidadDTO);
            }

            System.out.println("8) Visualiza la clasificación al inicio, a mitad de temporada y al final de esta.");
            List<Equipo> listaConsulta8 = equipoDaoJpa.visualizarClasificacion();
            for (Equipo consulta8 : listaConsulta8) {
                System.out.println(consulta8);
            }

            System.out.println("9) Determina y muestra los tres equipos con más puntos y los tres con menos.");
            List<EquipoDto> listaConsulta9 = equipoDaoJpa.mostrarEquiposPorOrdenPreferente();
            for (EquipoDto equipoDto1 : listaConsulta9) {
                System.out.println(equipoDto1);
            }

            System.out.println("10) Muestra las nuevas incorporaciones a la competición");
            RealizaFichajes.realizarFichajes(em);
            List<Deportista> consulta10 = deportistaDaoJpa.listarFichajes();
            for (Deportista deportista : consulta10) {
                System.out.println(deportista);
            }

            System.out.println("12) Realiza un recuento del total de deportistas que participan en la competición.");
            Long consulta12 = equipoDaoJpa.contarJugadoresComp();
            System.out.println("El número de participantes es:" + consulta12);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("Error en la entidad.");
        } finally {
            em.close();
            emf.close();
        }
    }
}
