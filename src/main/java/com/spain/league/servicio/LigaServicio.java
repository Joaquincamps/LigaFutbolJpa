package com.spain.league.servicio;

import com.spain.league.config.JpaUtil;
import com.spain.league.dao.LigaDao;
import com.spain.league.dao.jpa.DeportistaDaoJpa;
import com.spain.league.dao.jpa.EntrenadorDaoJpa;
import com.spain.league.dao.jpa.EquipoDaoJpa;
import com.spain.league.dao.jpa.PatrocinadorDaoJpa;
import com.spain.league.modelo.*;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class LigaServicio {

    private static String nombreLiga = "LaLiga EA Sports";
    private static String categoria = "Primera División";
    private EntityManagerFactory emf = JpaUtil.getEntityManagerFactory();
    private EntityManager em =emf.createEntityManager();

    public static String getNombreLiga() {
        return nombreLiga;
    }

    public static String getCategoria() {
        return categoria;
    }

    private LigaDao ligaDao;


    public LigaServicio(LigaDao ligaDao) {
        this.ligaDao = ligaDao;
    }


    public Liga crearLigaDesdeDatos() {
        Liga liga = new Liga(nombreLiga, categoria);
        ligaDao.crearLiga(liga);
        return liga;
    }

    public LigaDao getLigaDao() {
        return ligaDao;
    }

    public void setLigaDao(LigaDao ligaDao) {
        this.ligaDao = ligaDao;
    }

    public void crearEquipoConEntrenador(Liga liga) {
        em.getTransaction().begin();
        EquipoDaoJpa equipoDaoJpa = new EquipoDaoJpa(em);
        EntrenadorDaoJpa entrenadorDaoJpa = new EntrenadorDaoJpa(em);
        DeportistaDaoJpa deportistaDaoJpa = new DeportistaDaoJpa(em);
        PatrocinadorDaoJpa patrocinadorDaoJpa = new PatrocinadorDaoJpa(em);


        // Entrenadores
        Entrenador t1 = new Entrenador("Hansi Flick", "Alemana", null);
        Entrenador t2 = new Entrenador("Carlo Ancelotti", "Italiana", null);
        Entrenador t3 = new Entrenador("Marcelino García Toral", "Española", null);
        Entrenador t4 = new Entrenador("Diego Simeone", "Argentina", null);
        Entrenador t5 = new Entrenador("Manolo González", "Española", null);
        Entrenador t6 = new Entrenador("Manuel Pellegrini", "Chilena", null);
        Entrenador t7 = new Entrenador("Claudio Giráldez", "Española", null);
        Entrenador t8 = new Entrenador("Ernesto Valverde", "Española", null);
        Entrenador t9 = new Entrenador("Míchel Sánchez", "Española", null);
        Entrenador t10 = new Entrenador("Sebastián Beccacece", "Argentina", null);

        // Equipos
        Equipo e1 = new Equipo("FC Barcelona", "Camp Nou", "Barcelona", 53, 20, 49);
        Equipo e2 = new Equipo("Real Madrid", "Santiago Bernabéu", "Madrid", 41, 17, 45);
        Equipo e3 = new Equipo("Villarreal CF", "Estadio de la Cerámica", "Villarreal", 37, 17, 41);
        Equipo e4 = new Equipo("Atlético de Madrid", "Wanda Metropolitano", "Madrid", 34, 17, 38);
        Equipo e5 = new Equipo("RCD Espanyol", "RCDE Stadium", "Barcelona", 23, 22, 34);
        Equipo e6 = new Equipo("Real Betis", "Benito Villamarín", "Sevilla", 31, 25, 29);
        Equipo e7 = new Equipo("Celta de Vigo", "Abanca Balaídos", "Vigo", 25, 20, 29);
        Equipo e8 = new Equipo("Athletic Club", "San Mamés", "Bilbao", 19, 28, 24);
        Equipo e9 = new Equipo("Girona FC", "Estadi Montilivi", "Girona", 20, 34, 24);
        Equipo e10 = new Equipo("Elche CF", "Estadio Manuel Martínez Valero", "Elche", 25, 24, 23);


        // Asignar entrenadores a los equipos
        e1.asignarEntrenador(t1);
        e2.asignarEntrenador(t2);
        e3.asignarEntrenador(t3);
        e4.asignarEntrenador(t4);
        e5.asignarEntrenador(t5);
        e6.asignarEntrenador(t6);
        e7.asignarEntrenador(t7);
        e8.asignarEntrenador(t8);
        e9.asignarEntrenador(t9);
        e10.asignarEntrenador(t10);

        // Guardar entrenadores en base
        entrenadorDaoJpa.agregarEntrenador(t1);
        entrenadorDaoJpa.agregarEntrenador(t2);
        entrenadorDaoJpa.agregarEntrenador(t3);
        entrenadorDaoJpa.agregarEntrenador(t4);
        entrenadorDaoJpa.agregarEntrenador(t5);
        entrenadorDaoJpa.agregarEntrenador(t6);
        entrenadorDaoJpa.agregarEntrenador(t7);
        entrenadorDaoJpa.agregarEntrenador(t8);
        entrenadorDaoJpa.agregarEntrenador(t9);
        entrenadorDaoJpa.agregarEntrenador(t10);

        Deportista d1 = new Deportista("Marc-André ter Stegen", "Alemana", 33, null);
        Deportista d2 = new Deportista("Joan García", "Española", 24, null);
        Deportista d3 = new Deportista("Alejandro Balde", "Española", 22, null);
        Deportista d4 = new Deportista("Ronald Araújo", "Uruguaya", 26, null);
        Deportista d5 = new Deportista("Pau Cubarsí", "Española", 18, null);
        Deportista d6 = new Deportista("Ferran Torres", "Española", 25, null);
        Deportista d7 = new Deportista("Robert Lewandowski", "Polaca", 37, null);
        Deportista d8 = new Deportista("Lamine Yamal", "Española", 18, null);

        Deportista d9 = new Deportista("Thibaut Courtois", "Belga", 33, null);
        Deportista d10 = new Deportista("Andriy Lunin", "Ucraniana", 26, null);
        Deportista d11 = new Deportista("Fran González", "Española", 20, null);
        Deportista d12 = new Deportista("Dean Huijsen", "Neerlandesa", 20, null);
        Deportista d13 = new Deportista("Éder Militão", "Brasileña", 27, null);
        Deportista d14 = new Deportista("Jude Bellingham", "Inglesa", 22, null);
        Deportista d15 = new Deportista("Kylian Mbappé", "Francesa", 26, null);
        Deportista d16 = new Deportista("Vinícius Jr.", "Brasileña", 24, null);

        Deportista d17 = new Deportista("Arnau Tenas", "Española", 24, null);
        Deportista d18 = new Deportista("Diego Conde", "Española", 26, null);
        Deportista d19 = new Deportista("Luiz Júnior", "Brasileña", 24, null);
        Deportista d20 = new Deportista("Ruben Gómez", "Española", 23, null);
        Deportista d21 = new Deportista("Alfonso Pedraza", "Española", 29, null);
        Deportista d22 = new Deportista("Juan Foyth", "Argentina", 27, null);
        Deportista d23 = new Deportista("Ismael Sierra", "Española", 22, null);
        Deportista d24 = new Deportista("Pau Navarro", "Española", 20, null);

        Deportista d25 = new Deportista("Jan Oblak", "Eslovena", 34, null);
        Deportista d26 = new Deportista("Stefan Savić", "Montenegrina", 33, null);
        Deportista d27 = new Deportista("José Giménez", "Uruguaya", 29, null);
        Deportista d28 = new Deportista("Nahuel Molina", "Argentina", 26, null);
        Deportista d29 = new Deportista("Marcos Llorente", "Española", 29, null);
        Deportista d30 = new Deportista("Álex Baena", "Española", 24, null);
        Deportista d31 = new Deportista("Julián Álvarez", "Argentina", 25, null);
        Deportista d32 = new Deportista("Samuel Lino", "Brasileña", 24, null);

        Deportista d33 = new Deportista("Marko Dmitrović", "Serbia", 34, null);
        Deportista d34 = new Deportista("Diego López", "Española", 36, null);
        Deportista d35 = new Deportista("Edu Expósito", "Española", 29, null);
        Deportista d36 = new Deportista("Javi Puado", "Española", 27, null);
        Deportista d37 = new Deportista("Tyrhys Dolan", "Inglesa", 22, null);
        Deportista d38 = new Deportista("Óscar Gil", "Española", 23, null);
        Deportista d39 = new Deportista("Abdoulaye Ba", "Senegalesa", 32, null);
        Deportista d40 = new Deportista("Joselu", "Española", 36, null);

        Deportista d41 = new Deportista("Pau López", "Española", 31, null);
        Deportista d42 = new Deportista("Héctor Bellerín", "Española", 29, null);
        Deportista d43 = new Deportista("Diego Llorente", "Española", 30, null);
        Deportista d44 = new Deportista("Marc Bartra", "Española", 33, null);
        Deportista d45 = new Deportista("Giovani Lo Celso", "Argentina", 28, null);
        Deportista d46 = new Deportista("Abde Ezzalzouli", "Marroquí", 24, null);
        Deportista d47 = new Deportista("Chimy Ávila", "Argentino", 31, null);
        Deportista d48 = new Deportista("Sergi Altimira", "Española", 20, null);

        Deportista d49 = new Deportista("Iván Villar", "Española", 29, null);
        Deportista d50 = new Deportista("Carl Starfelt", "Sueca", 28, null);
        Deportista d51 = new Deportista("Fran Beltrán", "Española", 25, null);
        Deportista d52 = new Deportista("Iago Aspas", "Española", 37, null);
        Deportista d53 = new Deportista("Gabriel Veiga", "Española", 22, null);
        Deportista d54 = new Deportista("Brais Méndez", "Española", 28, null);
        Deportista d55 = new Deportista("Pepe Reinante", "Española", 24, null);
        Deportista d56 = new Deportista("Denis Suárez", "Española", 30, null);

        Deportista d57 = new Deportista("Unai Simón", "Española", 29, null);
        Deportista d58 = new Deportista("Íñigo Martínez", "Española", 36, null);
        Deportista d59 = new Deportista("Yeray Álvarez", "Española", 32, null);
        Deportista d60 = new Deportista("Oihan Sancet", "Española", 24, null);
        Deportista d61 = new Deportista("Alex Berenguer", "Española", 30, null);
        Deportista d62 = new Deportista("Nico Williams", "Española", 21, null);
        Deportista d63 = new Deportista("Mikel Vesga", "Española", 32, null);
        Deportista d64 = new Deportista("Marcelo Flores", "Mexicana", 20, null);

        Deportista d65 = new Deportista("Paulo Gazzaniga", "Argentina", 34, null);
        Deportista d66 = new Deportista("Vladyslav Vanat", "Ucraniana", 21, null);
        Deportista d67 = new Deportista("Borja Iglesias", "Española", 33, null);
        Deportista d68 = new Deportista("Azzedine Ounahi", "Marroquí", 24, null);
        Deportista d69 = new Deportista("Aleix García", "Española", 29, null);
        Deportista d70 = new Deportista("Alejandro Baena", "Española", 22, null);
        Deportista d71 = new Deportista("Ibrahim Drešević", "Montenegrina", 31, null);
        Deportista d72 = new Deportista("Diego López", "Española", 24, null);

        Deportista d73 = new Deportista("Iñaki Peña", "Española", 26, null);
        Deportista d74 = new Deportista("Pedro Bigas", "Española", 36, null);
        Deportista d75 = new Deportista("Bambo Diaby", "Senegalesa", 28, null);
        Deportista d76 = new Deportista("Matías Dituro", "Argentino", 38, null);
        Deportista d77 = new Deportista("Roger Martí", "Española", 33, null);
        Deportista d78 = new Deportista("Lucas Boyé", "Argentina", 27, null);
        Deportista d79 = new Deportista("Omar Mascarell", "Española", 33, null);
        Deportista d80 = new Deportista("Álvaro Muñoz", "Española", 29, null);

        e1.agregarDeportista(d1);
        e1.agregarDeportista(d2);
        e1.agregarDeportista(d3);
        e1.agregarDeportista(d4);
        e1.agregarDeportista(d5);
        e1.agregarDeportista(d6);
        e1.agregarDeportista(d7);
        e1.agregarDeportista(d8);

        deportistaDaoJpa.crearDeportista(d1);
        deportistaDaoJpa.crearDeportista(d2);
        deportistaDaoJpa.crearDeportista(d3);
        deportistaDaoJpa.crearDeportista(d4);
        deportistaDaoJpa.crearDeportista(d5);
        deportistaDaoJpa.crearDeportista(d6);
        deportistaDaoJpa.crearDeportista(d7);
        deportistaDaoJpa.crearDeportista(d8);

        e2.agregarDeportista(d9);
        e2.agregarDeportista(d10);
        e2.agregarDeportista(d11);
        e2.agregarDeportista(d12);
        e2.agregarDeportista(d13);
        e2.agregarDeportista(d14);
        e2.agregarDeportista(d15);
        e2.agregarDeportista(d16);

        deportistaDaoJpa.crearDeportista(d9);
        deportistaDaoJpa.crearDeportista(d10);
        deportistaDaoJpa.crearDeportista(d11);
        deportistaDaoJpa.crearDeportista(d12);
        deportistaDaoJpa.crearDeportista(d13);
        deportistaDaoJpa.crearDeportista(d14);
        deportistaDaoJpa.crearDeportista(d15);
        deportistaDaoJpa.crearDeportista(d16);


        // Equipo 3
        e3.agregarDeportista(d17);
        e3.agregarDeportista(d18);
        e3.agregarDeportista(d19);
        e3.agregarDeportista(d20);
        e3.agregarDeportista(d21);
        e3.agregarDeportista(d22);
        e3.agregarDeportista(d23);
        e3.agregarDeportista(d24);

        deportistaDaoJpa.crearDeportista(d17);
        deportistaDaoJpa.crearDeportista(d18);
        deportistaDaoJpa.crearDeportista(d19);
        deportistaDaoJpa.crearDeportista(d20);
        deportistaDaoJpa.crearDeportista(d21);
        deportistaDaoJpa.crearDeportista(d22);
        deportistaDaoJpa.crearDeportista(d23);
        deportistaDaoJpa.crearDeportista(d24);

// Equipo 4
        e4.agregarDeportista(d25);
        e4.agregarDeportista(d26);
        e4.agregarDeportista(d27);
        e4.agregarDeportista(d28);
        e4.agregarDeportista(d29);
        e4.agregarDeportista(d30);
        e4.agregarDeportista(d31);
        e4.agregarDeportista(d32);

        deportistaDaoJpa.crearDeportista(d25);
        deportistaDaoJpa.crearDeportista(d26);
        deportistaDaoJpa.crearDeportista(d27);
        deportistaDaoJpa.crearDeportista(d28);
        deportistaDaoJpa.crearDeportista(d29);
        deportistaDaoJpa.crearDeportista(d30);
        deportistaDaoJpa.crearDeportista(d31);
        deportistaDaoJpa.crearDeportista(d32);

        // Equipo 5
        e5.agregarDeportista(d33);
        e5.agregarDeportista(d34);
        e5.agregarDeportista(d35);
        e5.agregarDeportista(d36);
        e5.agregarDeportista(d37);
        e5.agregarDeportista(d38);
        e5.agregarDeportista(d39);
        e5.agregarDeportista(d40);

        deportistaDaoJpa.crearDeportista(d33);
        deportistaDaoJpa.crearDeportista(d34);
        deportistaDaoJpa.crearDeportista(d35);
        deportistaDaoJpa.crearDeportista(d36);
        deportistaDaoJpa.crearDeportista(d37);
        deportistaDaoJpa.crearDeportista(d38);
        deportistaDaoJpa.crearDeportista(d39);
        deportistaDaoJpa.crearDeportista(d40);

        // Equipo 6
        e6.agregarDeportista(d41);
        e6.agregarDeportista(d42);
        e6.agregarDeportista(d43);
        e6.agregarDeportista(d44);
        e6.agregarDeportista(d45);
        e6.agregarDeportista(d46);
        e6.agregarDeportista(d47);
        e6.agregarDeportista(d48);

        deportistaDaoJpa.crearDeportista(d41);
        deportistaDaoJpa.crearDeportista(d42);
        deportistaDaoJpa.crearDeportista(d43);
        deportistaDaoJpa.crearDeportista(d44);
        deportistaDaoJpa.crearDeportista(d45);
        deportistaDaoJpa.crearDeportista(d46);
        deportistaDaoJpa.crearDeportista(d47);
        deportistaDaoJpa.crearDeportista(d48);

        // Equipo 7
        e7.agregarDeportista(d49);
        e7.agregarDeportista(d50);
        e7.agregarDeportista(d51);
        e7.agregarDeportista(d52);
        e7.agregarDeportista(d53);
        e7.agregarDeportista(d54);
        e7.agregarDeportista(d55);
        e7.agregarDeportista(d56);

        deportistaDaoJpa.crearDeportista(d49);
        deportistaDaoJpa.crearDeportista(d50);
        deportistaDaoJpa.crearDeportista(d51);
        deportistaDaoJpa.crearDeportista(d52);
        deportistaDaoJpa.crearDeportista(d53);
        deportistaDaoJpa.crearDeportista(d54);
        deportistaDaoJpa.crearDeportista(d55);
        deportistaDaoJpa.crearDeportista(d56);

        // Equipo 8
        e8.agregarDeportista(d57);
        e8.agregarDeportista(d58);
        e8.agregarDeportista(d59);
        e8.agregarDeportista(d60);
        e8.agregarDeportista(d61);
        e8.agregarDeportista(d62);
        e8.agregarDeportista(d63);
        e8.agregarDeportista(d64);

        deportistaDaoJpa.crearDeportista(d57);
        deportistaDaoJpa.crearDeportista(d58);
        deportistaDaoJpa.crearDeportista(d59);
        deportistaDaoJpa.crearDeportista(d60);
        deportistaDaoJpa.crearDeportista(d61);
        deportistaDaoJpa.crearDeportista(d62);
        deportistaDaoJpa.crearDeportista(d63);
        deportistaDaoJpa.crearDeportista(d64);

// Equipo 9
        e9.agregarDeportista(d65);
        e9.agregarDeportista(d66);
        e9.agregarDeportista(d67);
        e9.agregarDeportista(d68);
        e9.agregarDeportista(d69);
        e9.agregarDeportista(d70);
        e9.agregarDeportista(d71);
        e9.agregarDeportista(d72);

        deportistaDaoJpa.crearDeportista(d65);
        deportistaDaoJpa.crearDeportista(d66);
        deportistaDaoJpa.crearDeportista(d67);
        deportistaDaoJpa.crearDeportista(d68);
        deportistaDaoJpa.crearDeportista(d69);
        deportistaDaoJpa.crearDeportista(d70);
        deportistaDaoJpa.crearDeportista(d71);
        deportistaDaoJpa.crearDeportista(d72);

// Equipo 10
        e10.agregarDeportista(d73);
        e10.agregarDeportista(d74);
        e10.agregarDeportista(d75);
        e10.agregarDeportista(d76);
        e10.agregarDeportista(d77);
        e10.agregarDeportista(d78);
        e10.agregarDeportista(d79);
        e10.agregarDeportista(d80);

        deportistaDaoJpa.crearDeportista(d73);
        deportistaDaoJpa.crearDeportista(d74);
        deportistaDaoJpa.crearDeportista(d75);
        deportistaDaoJpa.crearDeportista(d76);
        deportistaDaoJpa.crearDeportista(d77);
        deportistaDaoJpa.crearDeportista(d78);
        deportistaDaoJpa.crearDeportista(d79);
        deportistaDaoJpa.crearDeportista(d80);


        //PATROCINADORES
        Patrocinador p1 = new Patrocinador("Spotify", "Suecia");
        Patrocinador p2 = new Patrocinador("Fly Emirates", "Emiratos Árabes Unidos");
        Patrocinador p3 = new Patrocinador("Plus500", "Israel");
        Patrocinador p4 = new Patrocinador("Kutxabank", "España");
        Patrocinador p5 = new Patrocinador("Cazoo", "Reino Unido");
        Patrocinador p6 = new Patrocinador("Rakuten", "Japón");
        Patrocinador p7 = new Patrocinador("Sorare", "Francia");
        Patrocinador p8 = new Patrocinador("Estrella Galicia", "España");
        Patrocinador p9 = new Patrocinador("Mahou", "España");
        Patrocinador p10 = new Patrocinador("WhaleFin", "Singapur");
        Patrocinador p11 = new Patrocinador("Adidas", "Alemania");
        Patrocinador p12 = new Patrocinador("Puma", "Alemania");
        Patrocinador p13 = new Patrocinador("Qatar Airways", "Qatar");
        Patrocinador p14 = new Patrocinador("Coca-Cola", "Estados Unidos");
        Patrocinador p15 = new Patrocinador("Heineken", "Países Bajos");
        Patrocinador p16 = new Patrocinador("Toyota", "Japón");
        Patrocinador p17 = new Patrocinador("Samsung", "Corea del Sur");
        Patrocinador p18 = new Patrocinador("Vivo", "China");
        Patrocinador p19 = new Patrocinador("Red Bull", "Austria");
        Patrocinador p20 = new Patrocinador("Pepsi", "Estados Unidos");

        p1.agregarEquipo(e1);

        patrocinadorDaoJpa.guardarPatrocinador(p1);
        patrocinadorDaoJpa.guardarPatrocinador(p2);
        patrocinadorDaoJpa.guardarPatrocinador(p3);
        patrocinadorDaoJpa.guardarPatrocinador(p4);
        patrocinadorDaoJpa.guardarPatrocinador(p5);
        patrocinadorDaoJpa.guardarPatrocinador(p6);
        patrocinadorDaoJpa.guardarPatrocinador(p7);
        patrocinadorDaoJpa.guardarPatrocinador(p8);
        patrocinadorDaoJpa.guardarPatrocinador(p9);
        patrocinadorDaoJpa.guardarPatrocinador(p10);
        patrocinadorDaoJpa.guardarPatrocinador(p11);
        patrocinadorDaoJpa.guardarPatrocinador(p12);
        patrocinadorDaoJpa.guardarPatrocinador(p13);
        patrocinadorDaoJpa.guardarPatrocinador(p14);
        patrocinadorDaoJpa.guardarPatrocinador(p15);
        patrocinadorDaoJpa.guardarPatrocinador(p16);
        patrocinadorDaoJpa.guardarPatrocinador(p17);
        patrocinadorDaoJpa.guardarPatrocinador(p18);
        patrocinadorDaoJpa.guardarPatrocinador(p19);
        patrocinadorDaoJpa.guardarPatrocinador(p20);

        Random random = new Random();

        // Lista de equipos
        List<Equipo> equipos = Arrays.asList(e1, e2, e3, e4, e5, e6, e7, e8, e9, e10);

        // Lista de patrocinadores
        List<Patrocinador> patrocinadores = Arrays.asList(
                p1, p2, p3, p4, p5, p6, p7, p8, p9, p10,
                p11, p12, p13, p14, p15, p16, p17, p18, p19, p20
        );

        for (Equipo equipo : equipos) {
            // Número aleatorio de patrocinadores entre 2 y 4
            int cantidadPatrocinadores = 2 + random.nextInt(3); // random.nextInt(3) -> 0,1,2

            // Asignar patrocinadores aleatorios sin repetir
            while (equipo.getPatrocinadores().size() < cantidadPatrocinadores) {
                Patrocinador patrocinador = patrocinadores.get(random.nextInt(patrocinadores.size()));
                equipo.agregarPatrocinador(patrocinador);
            }
        }
        em.getTransaction().commit();

    }

}
