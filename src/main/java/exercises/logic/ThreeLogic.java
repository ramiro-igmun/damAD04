package exercises.logic;

import entities.Instructor;
import entities.Project;
import repositories.Repository;

import java.util.List;

public class ThreeLogic {
    public static void run(Repository<Instructor> instructorRepository, Repository<Project> projectRepository) {
        Project project = new Project();
        project.setBudget(100000D);
        project.setField("Computer Science");
        project.setName("ORM Development");

        List<Instructor> instructors = instructorRepository.getAll();
        instructors.forEach(project::addInstructor);

        projectRepository.save(project);
    }
}
