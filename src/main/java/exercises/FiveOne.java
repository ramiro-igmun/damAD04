package exercises;

import entities.Instructor;
import exercises.logic.OneLogic;
import repositories.Repository;
import repositories.jpa.InstructorJpaRepository;

public class FiveOne {

    public static void main(String[] args) {
        Repository<Instructor> instructorRepository = new InstructorJpaRepository();
        OneLogic.run(instructorRepository);
    }

}
