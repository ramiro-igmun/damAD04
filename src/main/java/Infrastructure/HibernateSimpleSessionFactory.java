package Infrastructure;

import entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

/**
 * This class wraps a Singleton {@link SessionFactory} which is used to retrieve Sessions through {@link #getSession()}
 */
public class HibernateSimpleSessionFactory{

    private static SessionFactory sessionFactory;

    public HibernateSimpleSessionFactory() {
        if (sessionFactory == null) {
            StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
            Metadata metadata = new MetadataSources(registry)
                    .addAnnotatedClass(Address.class)
                    .addAnnotatedClass(Course.class)
                    .addAnnotatedClass(Instructor.class)
                    .addAnnotatedClass(InstructorDetail.class)
                    .addAnnotatedClass(Project.class)
                    .addAnnotatedClass(Student.class)
                    .addAnnotatedClass(Tuition.class)
                    .addAnnotatedClass(University.class)
                    .buildMetadata();
            sessionFactory = metadata.buildSessionFactory();
        }
    }

    /**
     * Get a {@link Session} to manage db operations.
     */
    public Session getSession() {
        return sessionFactory.openSession();
    }
}
