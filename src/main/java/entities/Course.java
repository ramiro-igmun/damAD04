package entities;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Table (name="course")
public class Course {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column (name="id")
	private int id;

	@Column (name= "name")
	private String name;

	@Column (name= "credits")
	private int credits;

	@ManyToMany (mappedBy="courses")
	private Set<Student> students = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY)
    private Instructor instructor;

    public Course(String name, int credits) {
        this.name = name;
        this.credits = credits;
    }

    public Course() {
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

	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public Set<Student> getStudents() {
        return Collections.unmodifiableSet(students);
	}

    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    public void addStudent(Student student) {
        students.add(student);
        student.addCourse(this);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", credits=" + credits +
                '}';
    }
}
