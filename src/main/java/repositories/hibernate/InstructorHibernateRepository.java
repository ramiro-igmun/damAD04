package repositories.hibernate;

import entities.Instructor;
import org.hibernate.Session;

public class InstructorHibernateRepository implements HibernateRepository<Instructor> {

    @Override
    public Class<Instructor> getClazz() {
        return Instructor.class;
    }

    /**
     * Delete the persisted Instructor by id and set its courses' instructor to null
     * @param id of the entity to delete
     */
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
}
