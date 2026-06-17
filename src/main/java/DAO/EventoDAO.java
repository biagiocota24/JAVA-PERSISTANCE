package DAO;

import entities.Evento;
import jakarta.persistence.EntityManager;

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

    public Evento getById(long id) {
        return entityManager.find(Evento.class, id);
    }


}
