package Infrastructure;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * This class wraps a Singleton {@link EntityManagerFactory} which is used to retrieve entityManager through {@link #getSession()}
 */
public class JpaSessionFactory {

    private static EntityManagerFactory entityManagerFactory;

    public JpaSessionFactory() {
        if (entityManagerFactory == null) {
            entityManagerFactory = Persistence.createEntityManagerFactory("ud4");
        }
    }

    public EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
}
