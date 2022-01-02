package repositories;

import entities.Course;

public class CourseRepository implements Repository<Course>{
    @Override
    public Class<Course> getClazz() {
        return Course.class;
    }
}
