package repositories;

import Infrastructure.HibernateSimpleSessionFactory;
import Infrastructure.SimpleSessionFactory;
import org.hibernate.Session;

import java.util.Collections;
import java.util.List;

public interface Repository<T> {

    SimpleSessionFactory sessionFactory = new HibernateSimpleSessionFactory();

    Class<T> getClazz();

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

    default T getById(int id) {
        Session session = sessionFactory.getSession();
        return session.get(getClazz(), id);
    }

    default List<T> getAllHQL() {
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
