package DAO;

import entities.Location;
import jakarta.persistence.EntityManager;

import java.util.UUID;

public class LocationDAO {
    private EntityManager entityManager;

    public LocationDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Location cercaPerId(UUID id) {
        return entityManager.find(Location.class, id);
    }

    public void salva(Location location) {
        entityManager.getTransaction().begin();
        entityManager.persist(location);
        entityManager.getTransaction().commit();
    }

    public void rimuovi(UUID id) {
        entityManager.getTransaction().begin();
        Location location = entityManager.find(Location.class, id);
        if (location != null) {
            entityManager.remove(location);
            System.out.println("Location rimossa!");
        } else {
            System.out.println("Location non trovata!");
        }
        entityManager.getTransaction().commit();
    }
}
