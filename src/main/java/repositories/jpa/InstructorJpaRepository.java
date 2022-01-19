package repositories.jpa;

import entities.Instructor;
import org.hibernate.Session;
import repositories.hibernate.HibernateRepository;

import javax.persistence.EntityManager;

public class InstructorJpaRepository implements JpaRepository<Instructor> {

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
        EntityManager session = sessionFactory.getEntityManager();
        try {
            session.getTransaction().begin();
            Instructor instructor = session.find(getClazz(), id);
            instructor.getProjects().forEach(project -> project.removeInstructor(instructor));
            instructor.getCourses().forEach(course -> course.setInstructor(null));
            session.remove(instructor);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.getTransaction().rollback();
        }
    }
}
