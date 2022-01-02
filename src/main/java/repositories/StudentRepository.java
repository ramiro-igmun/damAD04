package repositories;

import entities.Student;

public class StudentRepository implements Repository<Student> {
    @Override
    public Class<Student> getClazz() {
        return Student.class;
    }
}
