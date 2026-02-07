package com.spain.league.dao.jpa;

import com.spain.league.dao.PatrocinadorDao;
import com.spain.league.modelo.Equipo;
import com.spain.league.modelo.Patrocinador;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PatrocinadorDaoJpa implements PatrocinadorDao {

    private final EntityManager em;

    public PatrocinadorDaoJpa(EntityManager em) {
        this.em = em;
    }

    @Override
    public void guardarPatrocinador(Patrocinador patrocinador) {
        em.persist(patrocinador);
    }

    @Override
    public List<Patrocinador> listarPatrocinadores(int id) {

        TypedQuery<Patrocinador> query = em.createQuery(
                //la p es el alias del objeto patrocinador
                "SELECT DISTINCT p FROM sponsor p JOIN p.equipos e WHERE e.id =: id",
                Patrocinador.class
        );
        query.setParameter("id", (long) id);

        return query.getResultList();
    }

    @Override
    public List<Patrocinador> listarPatrocinadoresPorDosEquipos(int idEquipo1, int idEquipo2) {
        TypedQuery<Patrocinador> query = em.createQuery(
                "SELECT DISTINCT p FROM sponsor p JOIN p.equipos e WHERE e.id =:idEquipo1 OR e.id =:idEquipo2 GROUP BY p " +
                        "HAVING COUNT(e) = 2"
                , Patrocinador.class);
        query.setParameter("idEquipo1", idEquipo1).setParameter("idEquipo2", idEquipo2);
        return query.getResultList();
    }
}
