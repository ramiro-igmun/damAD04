package Infrastructure;

import org.hibernate.Session;

public interface SimpleSessionFactory {
    Session getSession();
}
