package DAO;

import entities.Concerto;
import entities.Evento;
import enums.GeneriMusica;
import jakarta.persistence.EntityManager;

import java.util.List;
import java.util.UUID;

public class EventoDAO {
    private EntityManager entityManager;

    public EventoDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void salva(Evento evento) {
        entityManager.getTransaction().begin();
        entityManager.persist(evento);
        entityManager.getTransaction().commit();
    }

    public void rimuovi(UUID id) {
        entityManager.getTransaction().begin();
        Evento evento = entityManager.find(Evento.class, id);
        if (evento != null) {
            entityManager.remove(evento);
            System.out.println("Evento rimosso!");
        } else {
            System.out.println("Evento non trovato!");
        }
        entityManager.getTransaction().commit();
    }

    public Evento getById(UUID id) {
        return entityManager.find(Evento.class, id);
    }

    public List<Concerto> getConcertiinStreaming(boolean veroOFalso) {
        return entityManager.createQuery("from Concerto where inStreaming = :inStreaming", Concerto.class).setParameter("inStreaming", veroOFalso).getResultList();
    }

    public List<Concerto> getConcertiPerGenere(GeneriMusica genere) {
        return entityManager.createQuery("from Concerto where genere = :tipo" , Concerto.class).setParameter("tipo", genere).getResultList();
    }


}
