package repositories.jpa;

import entities.Student;

public class StudentJpaRepository implements JpaRepository<Student> {
    @Override
    public Class<Student> getClazz() {
        return Student.class;
    }
}
