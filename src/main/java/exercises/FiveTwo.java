package exercises;

import exercises.logic.TwoLogic;
import repositories.jpa.InstructorJpaRepository;

public class FiveTwo {
    public static void main(String[] args) {
        InstructorJpaRepository instructorRepository = new InstructorJpaRepository();
        TwoLogic.run(instructorRepository);
    }
}
