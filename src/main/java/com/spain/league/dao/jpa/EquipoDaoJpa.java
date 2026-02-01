package com.spain.league.dao.jpa;

import com.spain.league.dao.EquipoDao;
import com.spain.league.dto.EquipoDto;
import com.spain.league.modelo.Equipo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

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
}
