package exercises.logic;

import entities.Address;
import entities.Course;
import entities.Instructor;
import repositories.Repository;

public class OneLogic {

    public static void run(Repository<Course> courseRepository, Repository<Instructor> instructorRepository) {
        // 1- Create a new course
        Course course = new Course("Acceso a Datos", 5);

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
