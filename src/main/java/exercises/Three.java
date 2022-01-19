package exercises;

import entities.Instructor;
import entities.Project;
import exercises.logic.ThreeLogic;
import repositories.hibernate.InstructorHibernateRepository;
import repositories.hibernate.ProjectHibernateRepository;

import java.util.List;

public class Three {

    public static void main(String[] args) {
        ProjectHibernateRepository projectRepository = new ProjectHibernateRepository();
        InstructorHibernateRepository instructorRepository = new InstructorHibernateRepository();
        ThreeLogic.run(instructorRepository, projectRepository);
    }
}
