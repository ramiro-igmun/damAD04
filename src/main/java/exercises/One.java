package exercises;

import entities.Instructor;
import exercises.logic.OneLogic;
import repositories.Repository;
import repositories.hibernate.InstructorHibernateRepository;

public class One {

    public static void main(String[] args) {
        Repository<Instructor> instructorRepository = new InstructorHibernateRepository();
        OneLogic.run(instructorRepository);
    }

}
