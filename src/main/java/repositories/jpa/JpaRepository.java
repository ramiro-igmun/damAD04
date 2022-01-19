package repositories.jpa;

import Infrastructure.JpaSessionFactory;
import repositories.Repository;

import javax.persistence.EntityManager;
import java.util.Collections;
import java.util.List;

public interface JpaRepository<T> extends Repository<T> {

    JpaSessionFactory sessionFactory = new JpaSessionFactory();

    @Override
    default void save(T entity) {
        EntityManager session = sessionFactory.getEntityManager();
        try {
            session.getTransaction().begin();
            session.merge(entity);
//            session.persist(entity);
//            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    default void deleteById(int id) {
        EntityManager session = sessionFactory.getEntityManager();
        try {
            session.getTransaction().begin();
            T entity = session.find(getClazz(), id);
            session.remove(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    default T getById(int id) {
        EntityManager session = sessionFactory.getEntityManager();
        return session.find(getClazz(), id);
    }

    @Override
    default List<T> getAll() {
        EntityManager session = sessionFactory.getEntityManager();
        try {
            String query = String.format("FROM %s", getClazz().getName());
            return session.createQuery(query, getClazz()).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
