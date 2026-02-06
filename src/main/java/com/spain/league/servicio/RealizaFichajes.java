package com.spain.league.servicio;

import com.spain.league.config.JpaUtil;
import com.spain.league.modelo.Deportista;
import com.spain.league.modelo.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.TypedQuery;

public class RealizaFichajes {


    public static void realizarFichajes(EntityManager em) {
        Deportista d1 = new Deportista("Pepe Tornado", "España", 27, null);
        Deportista d2 = new Deportista("Max Power", "Canadá", 22, null);
        Deportista d3 = new Deportista("Juanito Speed", "México", 30, null);
        Deportista d4 = new Deportista("Iker Voltio", "Portugal", 25, null);
        Deportista d5 = new Deportista("Aitor Martillo", "Islandia", 33, null);
        Equipo e1 = asignarEquipoPorBusquedaDeId(em, 1);
        d1.setEquipo(e1);
        d1.setEsFichado(true);

        Equipo e2 = asignarEquipoPorBusquedaDeId(em, 4);
        d2.setEquipo(e2);
        d2.setEsFichado(true);

        Equipo e3 = asignarEquipoPorBusquedaDeId(em, 5);
        d3.setEquipo(e3);
        d3.setEsFichado(true);

        Equipo e4 = asignarEquipoPorBusquedaDeId(em, 7);
        d4.setEquipo(e4);
        d4.setEsFichado(true);

        Equipo e5 = asignarEquipoPorBusquedaDeId(em, 2);
        d5.setEquipo(e5);
        d5.setEsFichado(true);


        em.persist(d1);
        em.persist(d2);
        em.persist(d3);
        em.persist(d4);
        em.persist(d5);
        System.out.println("Fichaje realizado");
    }

    public static Equipo asignarEquipoPorBusquedaDeId(EntityManager em, int id) {

        TypedQuery<Equipo> query = em.createQuery("SELECT e FROM team e WHERE e.id =: id", Equipo.class);
        query.setParameter("id", id);
        return query.getSingleResult();
    }

}
