package com.spain.league.dao.jpa;

import com.spain.league.dao.EquipoDao;
import com.spain.league.modelo.Equipo;
import jakarta.persistence.EntityManager;

import java.util.Set;

public class EquipoDaoJpa implements EquipoDao {

    private final EntityManager em;

    public EquipoDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public void agregarEquipos(Equipo equipo) {
        em.persist(equipo);
    }
}
