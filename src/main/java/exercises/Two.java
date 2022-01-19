package exercises;

import entities.Address;
import entities.Instructor;
import entities.InstructorDetail;
import exercises.logic.TwoLogic;
import repositories.hibernate.InstructorHibernateRepository;

public class Two {

    public static void main(String[] args) {
        InstructorHibernateRepository instructorRepository = new InstructorHibernateRepository();
        TwoLogic.run(instructorRepository);
    }
}
