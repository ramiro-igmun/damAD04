package repositories;

import entities.Project;

public class ProjectRepository implements Repository<Project> {
    @Override
    public Class<Project> getClazz() {
        return Project.class;
    }
}
