package com.spain.league.dao.jpa;

import com.spain.league.dao.DeportistaDao;
import com.spain.league.modelo.Deportista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class DeportistaDaoJpa implements DeportistaDao {

    private final EntityManager em;

    public DeportistaDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public void crearDeportista(Deportista deportista) {
        em.persist(deportista);
    }

    @Override
    public List<Deportista> listarDeportistas(int idEquipo) {
        TypedQuery<Deportista> query = em.createQuery(
                "SELECT a FROM athlete a WHERE a.equipo.id = : idEquipo", Deportista.class
        );
        query.setParameter("idEquipo", idEquipo);
        return query.getResultList();
    }
}
