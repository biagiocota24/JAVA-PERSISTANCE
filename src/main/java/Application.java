import DAO.EventoDAO;
import entities.Evento;
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
        EventoDAO eventoDAO = new EventoDAO(entityManager);

        Evento nuovoEvento = new Evento("gigi", LocalDate.now(), "bello", TipoEvento.PUBBLICO, 39);
//        eventoDAO.salva(nuovoEvento);

        eventoDAO.elimina(eventoDAO.getById(10));


    }
}