package com.spain.league.dao.jpa;

import com.spain.league.dao.DeportistaDao;
import com.spain.league.modelo.Deportista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.lang.reflect.Type;
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

    @Override
    public double calcularEdadPromedioPorEquipo(int id) {
        TypedQuery<Double> query = em.createQuery("SELECT AVG(e.edad) FROM athlete e WHERE e.equipo.id =: id",
                Double.class);
        query.setParameter("id", (long) id);
        return query.getSingleResult();
    }

    @Override
    public List<Deportista> contarDeportistasPorNacionaliaddMayores_23() {
        TypedQuery<Deportista> query = em.createQuery(
                "SELECT COUNT(d) FROM athlete d WHERE d.edad > 23 GROUP BY d.nacionaliad",
                Deportista.class
        );
        //USAR DTO
        return query.getResultList();

    }
}
