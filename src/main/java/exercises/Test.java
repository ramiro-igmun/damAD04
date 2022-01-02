package exercises;

import Infrastructure.HibernateSimpleSessionFactory;
import Infrastructure.SimpleSessionFactory;
import org.hibernate.Session;

public class Test {

    public static void main(String[] args) {
        SimpleSessionFactory sessionFactory = new HibernateSimpleSessionFactory();
        Session session = sessionFactory.getSession();
        System.out.println(session.isConnected());
    }
}
