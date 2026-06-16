package DAO;

import entities.Evento;
import jakarta.persistence.EntityManager;

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

    public void elimina(Evento evento) {
        entityManager.getTransaction().begin();
        Evento eventoManaged = entityManager.merge(evento);
        entityManager.remove(evento);
        entityManager.getTransaction().commit();
    }

    public Evento getById(long id) {
        return entityManager.find(Evento.class, id);
    }


}
