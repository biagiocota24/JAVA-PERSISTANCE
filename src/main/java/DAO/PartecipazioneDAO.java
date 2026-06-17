package DAO;

import entities.Partecipazione;
import jakarta.persistence.EntityManager;

import java.util.UUID;

public class PartecipazioneDAO {
    private EntityManager entityManager;

    public PartecipazioneDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Partecipazione cercaPerId(UUID id) {
        return entityManager.find(Partecipazione.class, id);
    }

    public void salva(Partecipazione partecipazione) {
        entityManager.getTransaction().begin();
        entityManager.persist(partecipazione);
        entityManager.getTransaction().commit();
    }

    public void rimuovi(UUID id) {
        entityManager.getTransaction().begin();
        Partecipazione partecipazione = entityManager.find(Partecipazione.class, id);
        if (partecipazione != null) {
            entityManager.remove(partecipazione);
            System.out.println("Partecipazione rimossa!");
        } else {
            System.out.println("Partecipazione non trovata!");
        }
        entityManager.getTransaction().commit();
    }
}
