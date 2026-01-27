package com.spain.league.dao.jpa;

import com.spain.league.dao.LigaDao;
import com.spain.league.modelo.Equipo;
import com.spain.league.modelo.Liga;
import jakarta.persistence.EntityManager;

public class LigaDaoJpa implements LigaDao {

    private final EntityManager em;

    public LigaDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public void crearLiga(Liga liga) {
        em.persist(liga);
    }

    @Override
    public void agregarEquiposLiga(Equipo equipo) {
        em.persist(equipo);
    }

    @Override
    public void actualizarLiga(Liga liga) {
        em.merge(liga);  // merge actualiza la entidad y sus relaciones
    }
}
