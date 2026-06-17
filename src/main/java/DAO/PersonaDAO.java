package DAO;

import entities.Persona;
import jakarta.persistence.EntityManager;

import java.util.UUID;

public class PersonaDAO {
    private EntityManager entityManager;

    public PersonaDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Persona cercaPerId(UUID id) {
        return entityManager.find(Persona.class, id);
    }

    public void salva(Persona persona) {
        entityManager.getTransaction().begin();
        entityManager.persist(persona);
        entityManager.getTransaction().commit();
    }

    public void rimuovi(UUID id) {
        entityManager.getTransaction().begin();
        Persona persona = entityManager.find(Persona.class, id);
        if (persona != null) {
            entityManager.remove(persona);
            System.out.println("Persona rimossa!");
        } else {
            System.out.println("Persona non trovata!");
        }
        entityManager.getTransaction().commit();
    }
}
