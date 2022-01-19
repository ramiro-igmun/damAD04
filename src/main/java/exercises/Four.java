package exercises;

import entities.Instructor;
import repositories.hibernate.InstructorHibernateRepository;

import java.util.List;

public class Four {
    public static void main(String[] args) {
        InstructorHibernateRepository instructorRepository = new InstructorHibernateRepository();
        List<Instructor> instructors = instructorRepository.getAll();
        instructors.forEach(instructor -> instructorRepository.deleteById(instructor.getId()));
    }
}
