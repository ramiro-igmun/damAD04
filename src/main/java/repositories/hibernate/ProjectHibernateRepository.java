package repositories.hibernate;

import entities.Project;

public class ProjectHibernateRepository implements HibernateRepository<Project> {
    @Override
    public Class<Project> getClazz() {
        return Project.class;
    }
}
