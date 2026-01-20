package com.spain.league.servicio;

import com.spain.league.dao.DeportistaDao;
import com.spain.league.modelo.Deportista;

import java.util.HashSet;
import java.util.Set;

public class DeportistaServicio {

    private final DeportistaDao deportistaDao;

    public DeportistaServicio(DeportistaDao deportistaDao) {
        this.deportistaDao = deportistaDao;
    }

    public void crearDeportistasDeDatos() {
        Set<Deportista> deportistas = new HashSet<>();

        deportistas.add(new Deportista("Marc-André ter Stegen", "Alemana", 33));
        deportistas.add(new Deportista("Joan García", "Española", 24));
        deportistas.add(new Deportista("Alejandro Balde", "Española", 22));
        deportistas.add(new Deportista("Ronald Araújo", "Uruguaya", 26));
        deportistas.add(new Deportista("Pau Cubarsí", "Española", 18));
        deportistas.add(new Deportista("Ferran Torres", "Española", 25));
        deportistas.add(new Deportista("Robert Lewandowski", "Polaca", 37));
        deportistas.add(new Deportista("Lamine Yamal", "Española", 18));

        deportistas.add(new Deportista("Thibaut Courtois", "Belga", 33));
        deportistas.add(new Deportista("Andriy Lunin", "Ucraniana", 26));
        deportistas.add(new Deportista("Fran González", "Española", 20));
        deportistas.add(new Deportista("Dean Huijsen", "Neerlandesa", 20));
        deportistas.add(new Deportista("Éder Militão", "Brasileña", 27));
        deportistas.add(new Deportista("Jude Bellingham", "Inglesa", 22));
        deportistas.add(new Deportista("Kylian Mbappé", "Francesa", 26));
        deportistas.add(new Deportista("Vinícius Jr.", "Brasileña", 24));

        deportistas.add(new Deportista("Arnau Tenas", "Española", 24));
        deportistas.add(new Deportista("Diego Conde", "Española", 26));
        deportistas.add(new Deportista("Luiz Júnior", "Brasileña", 24));
        deportistas.add(new Deportista("Ruben Gómez", "Española", 23));
        deportistas.add(new Deportista("Alfonso Pedraza", "Española", 29));
        deportistas.add(new Deportista("Juan Foyth", "Argentina", 27));
        deportistas.add(new Deportista("Ismael Sierra", "Española", 22));
        deportistas.add(new Deportista("Pau Navarro", "Española", 20));

        deportistas.add(new Deportista("Jan Oblak", "Eslovena", 34));
        deportistas.add(new Deportista("Stefan Savić", "Montenegrina", 33));
        deportistas.add(new Deportista("José Giménez", "Uruguaya", 29));
        deportistas.add(new Deportista("Nahuel Molina", "Argentina", 26));
        deportistas.add(new Deportista("Marcos Llorente", "Española", 29));
        deportistas.add(new Deportista("Álex Baena", "Española", 24));
        deportistas.add(new Deportista("Julián Álvarez", "Argentina", 25));
        deportistas.add(new Deportista("Samuel Lino", "Brasileña", 24));

        deportistas.add(new Deportista("Marko Dmitrović", "Serbia", 34));
        deportistas.add(new Deportista("Diego López", "Española", 36));
        deportistas.add(new Deportista("Edu Expósito", "Española", 29));
        deportistas.add(new Deportista("Javi Puado", "Española", 27));
        deportistas.add(new Deportista("Tyrhys Dolan", "Inglesa", 22));
        deportistas.add(new Deportista("Óscar Gil", "Española", 23));
        deportistas.add(new Deportista("Abdoulaye Ba", "Senegalesa", 32));
        deportistas.add(new Deportista("Joselu", "Española", 36));

        deportistas.add(new Deportista("Pau López", "Española", 31));
        deportistas.add(new Deportista("Héctor Bellerín", "Española", 29));
        deportistas.add(new Deportista("Diego Llorente", "Española", 30));
        deportistas.add(new Deportista("Marc Bartra", "Española", 33));
        deportistas.add(new Deportista("Giovani Lo Celso", "Argentina", 28));
        deportistas.add(new Deportista("Abde Ezzalzouli", "Marroquí", 24));
        deportistas.add(new Deportista("Chimy Ávila", "Argentino", 31));
        deportistas.add(new Deportista("Sergi Altimira", "Española", 20));

        deportistas.add(new Deportista("Iván Villar", "Española", 29));
        deportistas.add(new Deportista("Carl Starfelt", "Sueca", 28));
        deportistas.add(new Deportista("Fran Beltrán", "Española", 25));
        deportistas.add(new Deportista("Iago Aspas", "Española", 37));
        deportistas.add(new Deportista("Gabriel Veiga", "Española", 22));
        deportistas.add(new Deportista("Brais Méndez", "Española", 28));
        deportistas.add(new Deportista("Pepe Reinante", "Española", 24));
        deportistas.add(new Deportista("Denis Suárez", "Española", 30));

        deportistas.add(new Deportista("Unai Simón", "Española", 29));
        deportistas.add(new Deportista("Íñigo Martínez", "Española", 36));
        deportistas.add(new Deportista("Yeray Álvarez", "Española", 32));
        deportistas.add(new Deportista("Oihan Sancet", "Española", 24));
        deportistas.add(new Deportista("Alex Berenguer", "Española", 30));
        deportistas.add(new Deportista("Nico Williams", "Española", 21));
        deportistas.add(new Deportista("Mikel Vesga", "Española", 32));
        deportistas.add(new Deportista("Marcelo Flores", "Mexicana", 20));

        deportistas.add(new Deportista("Paulo Gazzaniga", "Argentina", 34));
        deportistas.add(new Deportista("Vladyslav Vanat", "Ucraniana", 21));
        deportistas.add(new Deportista("Borja Iglesias", "Española", 33));
        deportistas.add(new Deportista("Azzedine Ounahi", "Marroquí", 24));
        deportistas.add(new Deportista("Aleix García", "Española", 29));
        deportistas.add(new Deportista("Alejandro Baena", "Española", 22));
        deportistas.add(new Deportista("Ibrahim Drešević", "Montenegrina", 31));
        deportistas.add(new Deportista("Diego López", "Española", 24));

        deportistas.add(new Deportista("Iñaki Peña", "Española", 26));
        deportistas.add(new Deportista("Pedro Bigas", "Española", 36));
        deportistas.add(new Deportista("Bambo Diaby", "Senegalesa", 28));
        deportistas.add(new Deportista("Matías Dituro", "Argentino", 38));
        deportistas.add(new Deportista("Roger Martí", "Española", 33));
        deportistas.add(new Deportista("Lucas Boyé", "Argentina", 27));
        deportistas.add(new Deportista("Omar Mascarell", "Española", 33));
        deportistas.add(new Deportista("Álvaro Muñoz", "Española", 29));

        for (Deportista deportista : deportistas) {
            deportistaDao.crearDeportista(deportista);
        }

    }
}
