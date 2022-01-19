package exercises;

import entities.Address;
import entities.Course;
import entities.Instructor;
import exercises.logic.OneLogic;
import repositories.Repository;
import repositories.hibernate.CourseHibernateRepository;
import repositories.hibernate.InstructorHibernateRepository;

public class One {

    public static void main(String[] args) {
        Repository<Course> courseRepository = new CourseHibernateRepository();
        Repository<Instructor> instructorRepository = new InstructorHibernateRepository();
        OneLogic.run(courseRepository, instructorRepository);
    }

}
