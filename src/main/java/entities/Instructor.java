package entities;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "instructor")
public class Instructor extends Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @OneToMany(mappedBy = "instructor")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    Set<Course> courses = new HashSet<>();

    @OneToOne(mappedBy = "instructor", cascade = CascadeType.ALL)
    private InstructorDetail instructorDetail;

    @ManyToMany(mappedBy = "instructors", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST})
    private Set<Project> projects = new HashSet<>();

    public Instructor(String firstName, String lastName, String email, Address address, int id) {
        super(firstName, lastName, email, address);
        this.id = id;
    }

    public Instructor() {
        super();
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.setInstructor(this);
    }

    public void addProject(Project project) {
        projects.add(project);
        project.getInstructors().add(this);
    }

    public void removeProject(Project project) {
        projects.remove(project);
        project.getInstructors().remove(this);
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public Set<Course> getCourses() {
        return courses;
    }

    public void setInstructorDetail(InstructorDetail instructorDetail) {
        this.instructorDetail = instructorDetail;
    }

    public InstructorDetail getInstructorDetail() {
        return instructorDetail;
    }
}
