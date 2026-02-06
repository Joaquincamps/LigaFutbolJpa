package com.spain.league.dao.jpa;

import com.spain.league.dao.EquipoDao;
import com.spain.league.dto.EquipoDto;
import com.spain.league.modelo.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.lang.reflect.Type;
import java.util.List;
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

    @Override
    public EquipoDto listarDeportistasPatrocinadoresPorEquipo(int id) {
        TypedQuery<Equipo> query = em.createQuery(
                "SELECT DISTINCT e FROM team e " +
                        "LEFT JOIN FETCH e.deportistas " +
                        "LEFT JOIN FETCH e.patrocinadores " +
                        "WHERE e.id =: id", Equipo.class);
        query.setParameter("id", (long) id);
        Equipo equipo = query.getSingleResult();

        EquipoDto equipoDto = new EquipoDto();
        equipoDto.setIdEquipo(equipo.getId());
        equipoDto.setNombreEquipo(equipo.getNombre());
        equipoDto.setDeportistas(equipo.getDeportistas());
        equipoDto.setPatrocinadores(equipo.getPatrocinadores());

        return equipoDto;
    }

    @Override
    public List<EquipoDto> mostrarEquiposPorOrdenPreferente() {
        TypedQuery<EquipoDto> query = em.createQuery("SELECT new com.spain.league.dto.EquipoDto(e.id,e.nombre,e.puntos) FROM team e ORDER BY e.puntos DESC LIMIT 3",EquipoDto.class);
        return query.getResultList();
    }

    @Override
    public List<Equipo> visualizarClasificacion() {
        TypedQuery<Equipo> query = em.createQuery("SELECT e FROM team e ORDER BY e.puntos DESC",Equipo.class);
        return query.getResultList();
    }

    @Override
    public Long contarJugadoresComp() {

        TypedQuery<Long> query = em.createQuery("SELECT COUNT(e) FROM athlete e",Long.class);
        return query.getSingleResult();
    }
}

