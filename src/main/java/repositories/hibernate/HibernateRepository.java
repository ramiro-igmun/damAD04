package repositories.hibernate;

import Infrastructure.HibernateSimpleSessionFactory;
import org.hibernate.Session;
import repositories.Repository;

import java.util.Collections;
import java.util.List;

public interface HibernateRepository<T> extends Repository<T> {

    HibernateSimpleSessionFactory sessionFactory = new HibernateSimpleSessionFactory();

    @Override
    default void save(T entity) {
        Session session = sessionFactory.getSession();
        try (session) {
            session.beginTransaction();
            session.save(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    default void deleteById(int id) {
        Session session = sessionFactory.getSession();
        try (session) {
            session.beginTransaction();
            T entity = session.get(getClazz(), id);
            session.delete(entity);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    /**
     * Delete a persisted entity by id using a created Query
     * @param id of the entity to delete
     */
    default void deleteByIdQuery(int id) {
        Session session = sessionFactory.getSession();
        try (session) {
            session.beginTransaction();
            String query = String.format("DELETE %s WHERE id=:id", getClazz().getName());
            session.createQuery(query)
                    .setParameter("id", id)
                    .executeUpdate();
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    default T getById(int id) {
        Session session = sessionFactory.getSession();
        return session.get(getClazz(), id);
    }

    @Override
    default List<T> getAll() {
        Session session = sessionFactory.getSession();
        try (session) {
            String query = String.format("FROM %s", getClazz().getName());
            return session.createQuery(query, getClazz()).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

}
