import DAO.EventoDAO;
import DAO.LocationDAO;
import DAO.PartecipazioneDAO;
import DAO.PersonaDAO;
import entities.Evento;
import entities.Location;
import entities.Partecipazione;
import entities.Persona;
import enums.Sesso;
import enums.StatoPartecipazione;
import enums.TipoEvento;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.time.LocalDate;

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

// LOCATION
        Location l1 = new Location("Palacongressi", "Roma");
        Location l2 = new Location("Teatro San Carlo", "Napoli");
        Location l3 = new Location("Fiera Milano", "Milano");
        locationDAO.salva(l1);
        locationDAO.salva(l2);
        locationDAO.salva(l3);

// EVENTI
        Evento e1 = new Evento("Concerto Rock", LocalDate.of(2026, 7, 15), "Gran concerto estivo", TipoEvento.PUBBLICO, 500, l1);
        Evento e2 = new Evento("Conferenza Tech", LocalDate.of(2026, 8, 10), "Novità nel mondo IT", TipoEvento.PUBBLICO, 200, l2);
        Evento e3 = new Evento("Festa Privata", LocalDate.of(2026, 9, 5), "Evento su invito", TipoEvento.PRIVATO, 50, l3);
        eventoDAO.salva(e1);
        eventoDAO.salva(e2);
        eventoDAO.salva(e3);

// PERSONE
        Persona p1 = new Persona("Mario", "Rossi", "mario.rossi@gmail.com", LocalDate.of(1990, 3, 15), Sesso.MASCHIO);
        Persona p2 = new Persona("Laura", "Bianchi", "laura.bianchi@gmail.com", LocalDate.of(1995, 6, 22), Sesso.FEMMINA);
        Persona p3 = new Persona("Giovanni", "Verdi", "giovanni.verdi@gmail.com", LocalDate.of(1988, 11, 8), Sesso.MASCHIO);
        Persona p4 = new Persona("Francesca", "Esposito", "francesca.esposito@gmail.com", LocalDate.of(2000, 1, 30), Sesso.FEMMINA);
        personaDAO.salva(p1);
        personaDAO.salva(p2);
        personaDAO.salva(p3);
        personaDAO.salva(p4);

// PARTECIPAZIONI
        partecipazioneDAO.salva(new Partecipazione(p1, e1, StatoPartecipazione.CONFERMATA));
        partecipazioneDAO.salva(new Partecipazione(p2, e1, StatoPartecipazione.NON_CONFERMATA));
        partecipazioneDAO.salva(new Partecipazione(p3, e2, StatoPartecipazione.CONFERMATA));
        partecipazioneDAO.salva(new Partecipazione(p4, e2, StatoPartecipazione.CONFERMATA));
        partecipazioneDAO.salva(new Partecipazione(p1, e3, StatoPartecipazione.NON_CONFERMATA));
        partecipazioneDAO.salva(new Partecipazione(p2, e3, StatoPartecipazione.CONFERMATA));


        entityManager.close();
        entityManagerFactory.close();
    }
}