package com.spain.league.dao.jpa;

import com.spain.league.dao.EntrenadorDao;
import com.spain.league.modelo.Entrenador;
import jakarta.persistence.EntityManager;

public class EntrenadorDaoJpa implements EntrenadorDao {

    private final EntityManager em;

    public EntrenadorDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public void agregarEntrenador(Entrenador entrenador) {
        em.persist(entrenador);
    }

    public void metoodPruebba(){
        System.out.println("Es un metodo de prueba");
    }
}
