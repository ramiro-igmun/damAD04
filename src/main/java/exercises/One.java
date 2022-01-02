package exercises;

import entities.Address;
import entities.Course;
import entities.Instructor;
import repositories.CourseRepository;
import repositories.InstructorRepository;

public class One {
    public static void main(String[] args) {

        // 1- Create a new course
        CourseRepository courseRepository = new CourseRepository();

        Course course = new Course("Acceso a Datos", 5);
        courseRepository.save(course);

        InstructorRepository instructorRepository = new InstructorRepository();

        // 2- Create a new instructor and add the course
        Instructor instructor = new Instructor();
        instructor.setFirstName("Diego");
        instructor.setLastName("Maza");
        instructor.setEmail("dmaza@birt.eus");

        Address address = new Address();
        address.setAddressLine1("Caja de Ahorros 23");
        address.setCity("Bilbao");
        address.setZipCode("48011");

        instructor.setAddress(address);
        instructor.addCourse(course);

        instructorRepository.save(instructor);
    }

}
