package entities;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    private String name;

    private String field;

    private Double budget;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "instructor_project", joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "instructor_id"))
    private Set<Instructor> instructors = new HashSet<>();

    public void addInstructor(Instructor instructor) {
        instructors.add(instructor);
        instructor.getProjects().add(this);
    }

    public void removeInstructor(Instructor instructor) {
        instructors.remove(instructor);
        instructor.getProjects().remove(this);
    }

    public Set<Instructor> getInstructors() {
        return instructors;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Double getBudget() {
        return budget;
    }

    public void setBudget(Double budget) {
        this.budget = budget;
    }
}
