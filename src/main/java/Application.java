import DAO.EventoDAO;
import DAO.LocationDAO;
import DAO.PartecipazioneDAO;
import DAO.PersonaDAO;
import entities.*;
import enums.GeneriMusica;
import enums.Sesso;
import enums.StatoPartecipazione;
import enums.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

public class Application {

    private static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("u4d12pu");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        // DAO
        LocationDAO locationDAO = new LocationDAO(entityManager);
        EventoDAO eventoDAO = new EventoDAO(entityManager);
        PersonaDAO personaDAO = new PersonaDAO(entityManager);
        PartecipazioneDAO partecipazioneDAO = new PartecipazioneDAO(entityManager);

        // PERSONE
        Persona p1 = entityManager.find(Persona.class, UUID.fromString("b70d98a1-ecba-4adf-99f1-2dad1d82028b"));
        Persona p2 = entityManager.find(Persona.class, UUID.fromString("c3cbc5b4-116d-4986-89f0-87e73f3262ce"));
        Persona p3 = entityManager.find(Persona.class, UUID.fromString("cf6be6e2-ba77-4d78-b271-bbec92f5cf8a"));

        Set<Persona> atleti = new HashSet<>();
        atleti.add(p1);
        atleti.add(p2);
        atleti.add(p3);


// LOCATION
        Location romaStadio = entityManager.find(Location.class, UUID.fromString("135197a8-03e7-43b2-ac4e-5c5f585763b3"));

// EVENTI
//        PartitaDiCalcio partita1 = new PartitaDiCalcio(" Roma VS Juve", LocalDate.of(2026, Month.SEPTEMBER, 12), "Partita avvicente", TipoEvento.PUBBLICO, romaStadio, "Roma", "Juve", 6, 2);
//        eventoDAO.salva(partita1);
//        GaraDiAtletica gara1 = new GaraDiAtletica("Salto in lungo", LocalDate.of(2026, Month.JUNE, 30), "bella", TipoEvento.PUBBLICO, romaStadio, atleti, p2);
//        eventoDAO.salva(gara1);
//        Concerto concerto1 = new Concerto("Vasco Rossi", LocalDate.now(), "bello", TipoEvento.PRIVATO, 5000, romaStadio, GeneriMusica.POP, true);
//        eventoDAO.salva(concerto1);

        // PARTITE DI CALCIO
//        PartitaDiCalcio partita1 = new PartitaDiCalcio("Roma VS Juve", LocalDate.of(2026, Month.SEPTEMBER, 12), "Partita avvincente", TipoEvento.PUBBLICO, romaStadio, "Roma", "Juve", 3, 1);
//        PartitaDiCalcio partita2 = new PartitaDiCalcio("Milan VS Inter", LocalDate.of(2026, Month.OCTOBER, 5), "Derby della Madonnina", TipoEvento.PUBBLICO, romaStadio, "Milan", "Inter", 2, 2);
//        PartitaDiCalcio partita3 = new PartitaDiCalcio("Napoli VS Lazio", LocalDate.of(2026, Month.OCTOBER, 18), "Scontro al vertice", TipoEvento.PUBBLICO, romaStadio, "Napoli", "Lazio", 4, 0);
//        PartitaDiCalcio partita4 = new PartitaDiCalcio("Fiorentina VS Atalanta", LocalDate.of(2026, Month.NOVEMBER, 2), "Match equilibrato", TipoEvento.PUBBLICO, romaStadio, "Fiorentina", "Atalanta", 1, 3);
//        PartitaDiCalcio partita5 = new PartitaDiCalcio("Torino VS Bologna", LocalDate.of(2026, Month.NOVEMBER, 20), "Sfida salvezza", TipoEvento.PUBBLICO, romaStadio, "Torino", "Bologna", 0, 2);
//        eventoDAO.salva(partita1);
//        eventoDAO.salva(partita2);
//        eventoDAO.salva(partita3);
//        eventoDAO.salva(partita4);
//        eventoDAO.salva(partita5);
//
//// GARE DI ATLETICA
//        Set<Persona> atleti1 = new HashSet<>(Arrays.asList(p1, p2, p3));
//
//        GaraDiAtletica gara1 = new GaraDiAtletica("Salto in lungo", LocalDate.of(2026, Month.JUNE, 30), "Gara emozionante", TipoEvento.PUBBLICO, romaStadio, atleti1, p1);
//        GaraDiAtletica gara2 = new GaraDiAtletica("100 metri", LocalDate.of(2026, Month.JULY, 15), "Finale sprint", TipoEvento.PUBBLICO, romaStadio, atleti1, p3);
//        GaraDiAtletica gara3 = new GaraDiAtletica("Lancio del disco", LocalDate.of(2026, Month.AUGUST, 8), "Gara tecnica", TipoEvento.PUBBLICO, romaStadio, atleti1, p2);
//        GaraDiAtletica gara4 = new GaraDiAtletica("Salto in alto", LocalDate.of(2026, Month.SEPTEMBER, 22), "Record da battere", TipoEvento.PUBBLICO, romaStadio, atleti1, p3);
//        GaraDiAtletica gara5 = new GaraDiAtletica("Maratona", LocalDate.of(2026, Month.OCTOBER, 10), "42km di pura fatica", TipoEvento.PUBBLICO, romaStadio, atleti1, p1);
//        eventoDAO.salva(gara1);
//        eventoDAO.salva(gara2);
//        eventoDAO.salva(gara3);
//        eventoDAO.salva(gara4);
//        eventoDAO.salva(gara5);
//
//// CONCERTI
//        Concerto concerto1 = new Concerto("Vasco Rossi", LocalDate.of(2026, Month.JULY, 1), "Leggenda del rock italiano", TipoEvento.PUBBLICO, 5000, romaStadio, GeneriMusica.ROCK, true);
//        Concerto concerto2 = new Concerto("Ultimo", LocalDate.of(2026, Month.JULY, 20), "Tour estivo", TipoEvento.PUBBLICO, 3000, romaStadio, GeneriMusica.POP, false);
//        Concerto concerto3 = new Concerto("Orchestra Filarmonica", LocalDate.of(2026, Month.AUGUST, 5), "Serata classica", TipoEvento.PRIVATO, 800, romaStadio, GeneriMusica.CLASSICO, false);
//        Concerto concerto4 = new Concerto("Maneskin", LocalDate.of(2026, Month.AUGUST, 25), "Rock internazionale", TipoEvento.PUBBLICO, 8000, romaStadio, GeneriMusica.ROCK, true);
//        Concerto concerto5 = new Concerto("Beethoven Night", LocalDate.of(2026, Month.SEPTEMBER, 15), "Omaggio ai grandi classici", TipoEvento.PRIVATO, 500, romaStadio, GeneriMusica.CLASSICO, true);
//        eventoDAO.salva(concerto1);
//        eventoDAO.salva(concerto2);
//        eventoDAO.salva(concerto3);
//        eventoDAO.salva(concerto4);
//        eventoDAO.salva(concerto5);

        List<Concerto> concertiLive = eventoDAO.getConcertiinStreaming(true);
        concertiLive.forEach(concerto -> System.out.println(concerto.getTitolo()));
        System.out.println("--------------divide-------------------");
        List<Concerto> concertinonInCorso = eventoDAO.getConcertiinStreaming(false);
        concertinonInCorso.forEach(concerto -> System.out.println(concerto.getTitolo()));

        List<Concerto> concertiPop = eventoDAO.getConcertiPerGenere(GeneriMusica.POP);
        concertiPop.forEach(concerto -> System.out.println(concerto.getTitolo()));

        List<Concerto> concertiClassico = eventoDAO.getConcertiPerGenere(GeneriMusica.CLASSICO);
        concertiClassico.forEach(concerto -> System.out.println(concerto.getTitolo()));


        entityManager.close();
        entityManagerFactory.close();
    }
}