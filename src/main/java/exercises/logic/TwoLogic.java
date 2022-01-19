package exercises.logic;

import entities.Address;
import entities.Instructor;
import entities.InstructorDetail;
import repositories.Repository;

public class TwoLogic {
    public static void run(Repository<Instructor> instructorRepository) {

        // 1- Create a new instructor
        Instructor instructor = new Instructor();
        instructor.setFirstName("María");
        instructor.setLastName("Teverga");
        instructor.setEmail("mteverga@birt.eus");

        Address address = new Address();
        address.setAddressLine1("Rodriguez Arias 3");
        address.setCity("Bilbao");
        address.setZipCode("48011");

        instructor.setAddress(address);

        // 2- Create details and persist
        InstructorDetail instructorDetail = new InstructorDetail("Aprendiendo Hibernate", "Escalada", instructor);
        instructor.setInstructorDetail(instructorDetail);

        instructorRepository.save(instructor);
    }
}
