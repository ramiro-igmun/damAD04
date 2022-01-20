package exercises;

import exercises.logic.TwoLogic;
import repositories.hibernate.InstructorHibernateRepository;

public class Two {

    public static void main(String[] args) {
        InstructorHibernateRepository instructorRepository = new InstructorHibernateRepository();
        TwoLogic.run(instructorRepository);
    }
}
