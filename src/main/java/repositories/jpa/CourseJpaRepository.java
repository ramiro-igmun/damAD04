package repositories.jpa;

import entities.Course;

public class CourseJpaRepository implements JpaRepository<Course> {
    @Override
    public Class<Course> getClazz() {
        return Course.class;
    }
}
