package com.spain.league.servicio;

import com.spain.league.dao.PatrocinadorDao;
import com.spain.league.modelo.Patrocinador;
import jakarta.persistence.EntityManager;

import java.util.HashSet;
import java.util.Set;

public class PatrocinadorServicio {

    private PatrocinadorDao patrocinadorDao;

    public PatrocinadorServicio(PatrocinadorDao patrocinadorDao) {
        this.patrocinadorDao = patrocinadorDao;
    }

    public void crearPatrocinadoresDesdeDatos(){
        Set<Patrocinador> patrocinadores = new HashSet<>();
        Patrocinador p1  = new Patrocinador("Spotify", "Suecia");
        Patrocinador p2  = new Patrocinador("Fly Emirates", "Emiratos Árabes Unidos");
        Patrocinador p3  = new Patrocinador("Plus500", "Israel");
        Patrocinador p4  = new Patrocinador("Kutxabank", "España");
        Patrocinador p5  = new Patrocinador("Cazoo", "Reino Unido");
        Patrocinador p6  = new Patrocinador("Rakuten", "Japón");
        Patrocinador p7  = new Patrocinador("Sorare", "Francia");
        Patrocinador p8  = new Patrocinador("Estrella Galicia", "España");
        Patrocinador p9  = new Patrocinador("Mahou", "España");
        Patrocinador p10 = new Patrocinador("WhaleFin", "Singapur");

        patrocinadores.add(p1);
        patrocinadores.add(p2);
        patrocinadores.add(p3);
        patrocinadores.add(p4);
        patrocinadores.add(p5);
        patrocinadores.add(p6);
        patrocinadores.add(p7);
        patrocinadores.add(p8);
        patrocinadores.add(p9);
        patrocinadores.add(p10);

        for(Patrocinador patrocinador : patrocinadores){
            patrocinadorDao.guardarPatrocinador(patrocinador);
        }

    }
}
