package com.spain.league.dao.jpa;

import com.spain.league.dao.DeportistaDao;
import com.spain.league.dto.DeportistasPorNacionalidadDTO;
import com.spain.league.modelo.Deportista;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

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

    /*
    ✅ USA DTO cuando:

Usas COUNT, SUM, AVG

Usas GROUP BY

Devuelves campos concretos, no la entidad entera

Consultas de tipo reportes / estadísticas

Quieres optimizar rendimiento (menos datos)

👉 Tu caso es 100% DTO ✔️
     */
    @Override
    public List<DeportistasPorNacionalidadDTO> DeportistasPorNacionaliaddMayores_23() {
        TypedQuery<DeportistasPorNacionalidadDTO> query = em.createQuery(
                "SELECT NEW com.spain.league.dto.DeportistasPorNacionalidadDTO (d.nacionalidad, count(d)) FROM athlete d WHERE d.edad > 23 GROUP BY d.nacionalidad",
                DeportistasPorNacionalidadDTO.class
        );
        //USAR DTO
        return query.getResultList();

    }

    @Override
    public List<Deportista> listarFichajes() {
        TypedQuery<Deportista> query = em.createNamedQuery("seleccionarFichajes", Deportista.class);
        query.setParameter("esFichado", true);
        return query.getResultList();
    }

    @Override
    public List<Deportista> criteriaQueryNum1() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Deportista> cq = cb.createQuery(Deportista.class);
        Root<Deportista> d = cq.from(Deportista.class);

        cq.select(d).where(cb.equal(d.get("nacionalidad"), "Argentina"));
        TypedQuery<Deportista> query = em.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<Deportista> criteriaQueryNum2() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Deportista> cq = cb.createQuery(Deportista.class);
        Root<Deportista> d = cq.from(Deportista.class);

        cq.select(d).where(cb.le(d.get("edad"), 23));
        TypedQuery<Deportista> query = em.createQuery(cq);
        return query.getResultList();
    }

    @Override
    public List<Deportista> criteriaQueryNum3() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Deportista> cq = cb.createQuery(Deportista.class);
        Root<Deportista> d = cq.from(Deportista.class);

        cq.select(d).where(cb.le(d.get("edad"), 20)).orderBy(cb.asc(d.get("nombre")));
        TypedQuery<Deportista> query = em.createQuery(cq);
        return query.getResultList();
    }
}
