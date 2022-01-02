package exercises;

import repositories.InstructorRepository;

public class Four {
    public static void main(String[] args) {
        InstructorRepository instructorRepository = new InstructorRepository();
        instructorRepository.deleteById(18);
    }
}
