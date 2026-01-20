package com.spain.league.dao.jpa;

import com.spain.league.dao.PatrocinadorDao;
import com.spain.league.modelo.Patrocinador;
import jakarta.persistence.EntityManager;

public class PatrocinadorDaoJpa implements PatrocinadorDao {

    private final EntityManager em;

    public PatrocinadorDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public void guardarPatrocinador(Patrocinador patrocinador) {
        em.persist(patrocinador);
    }
}
