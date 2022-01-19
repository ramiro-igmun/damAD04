package exercises;

import entities.Course;
import entities.Instructor;
import exercises.logic.OneLogic;
import repositories.Repository;
import repositories.jpa.CourseJpaRepository;
import repositories.jpa.InstructorJpaRepository;

public class FiveOne {

    public static void main(String[] args) {
        Repository<Course> courseRepository = new CourseJpaRepository();
        Repository<Instructor> instructorRepository = new InstructorJpaRepository();
        OneLogic.run(courseRepository, instructorRepository);
    }

}
