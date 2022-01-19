package exercises;

import exercises.logic.ThreeLogic;
import repositories.jpa.InstructorJpaRepository;
import repositories.jpa.ProjectJpaRepository;

public class FiveThree {
    public static void main(String[] args) {
        ProjectJpaRepository projectRepository = new ProjectJpaRepository();
        InstructorJpaRepository instructorRepository = new InstructorJpaRepository();
        ThreeLogic.run(instructorRepository, projectRepository);
    }
}
