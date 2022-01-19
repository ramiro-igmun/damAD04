package repositories.hibernate;

import entities.Student;

public class StudentHibernateRepository implements HibernateRepository<Student> {
    @Override
    public Class<Student> getClazz() {
        return Student.class;
    }
}
