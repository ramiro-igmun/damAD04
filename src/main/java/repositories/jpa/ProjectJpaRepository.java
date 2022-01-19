package repositories.jpa;

import entities.Project;

public class ProjectJpaRepository implements JpaRepository<Project> {
    @Override
    public Class<Project> getClazz() {
        return Project.class;
    }
}
