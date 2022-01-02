package exercises;

import entities.Instructor;
import entities.Project;
import repositories.InstructorRepository;
import repositories.ProjectRepository;

import java.util.List;

public class Three {

    public static void main(String[] args) {
        ProjectRepository projectRepository = new ProjectRepository();
        InstructorRepository instructorRepository = new InstructorRepository();

        Project project = new Project();
        project.setBudget(100000D);
        project.setField("Computer Science");
        project.setName("ORM Development");

        List<Instructor> instructors = instructorRepository.getAllHQL();
        instructors.forEach(project::addInstructor);

        projectRepository.save(project);
    }
}
