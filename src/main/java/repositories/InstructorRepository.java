package repositories;

import entities.Instructor;
import entities.Project;
import org.hibernate.Session;

public class InstructorRepository implements Repository<Instructor>{

    @Override
    public Class<Instructor> getClazz() {
        return Instructor.class;
    }

    @Override
    public void deleteById(int id) {
        Session session = sessionFactory.getSession();
        try (session) {
            session.beginTransaction();
            Instructor instructor = session.get(getClazz(), id);
            instructor.getProjects().forEach(project -> project.removeInstructor(instructor));
            instructor.getCourses().forEach(course -> course.setInstructor(null));
            session.delete(instructor);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }

    @Override
    public void deleteByIdQuery(int id) {
        Repository.super.deleteByIdQuery(id);
    }
}
