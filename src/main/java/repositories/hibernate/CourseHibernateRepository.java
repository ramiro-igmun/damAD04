package repositories.hibernate;

import entities.Course;

public class CourseHibernateRepository implements HibernateRepository<Course> {
    @Override
    public Class<Course> getClazz() {
        return Course.class;
    }
}
