package com.spain.league.dao.jpa;

import com.spain.league.dao.DeportistaDao;
import com.spain.league.modelo.Deportista;
import jakarta.persistence.EntityManager;

public class DeportistaDaoJpa implements DeportistaDao {

    private final EntityManager em;

    public DeportistaDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public void crearDeportista(Deportista deportista) {
        em.persist(deportista);
    }
}
