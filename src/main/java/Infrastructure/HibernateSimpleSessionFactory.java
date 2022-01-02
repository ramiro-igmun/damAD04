package Infrastructure;

import entities.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateSimpleSessionFactory implements SimpleSessionFactory {

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

    @Override
    public Session getSession() {
        return sessionFactory.openSession();
    }
}
