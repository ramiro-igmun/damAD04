package entities;


import java.time.LocalDate;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Formula;

@Entity
@Table(name="student")
public class Student extends Person{

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @ElementCollection
    @CollectionTable(name= "student_phone", joinColumns=@JoinColumn(name="student_id"))
    @Column(name="student_phone")
    private List<String> phones = new ArrayList<>();

    @Column (name="birthdate")
    private LocalDate birthdate;

    @Formula ("lower(datediff(curdate(), birthdate)/365)")
    private int age;

    @OneToOne(mappedBy="student",cascade=CascadeType.ALL)
    private Tuition tuition;

    @ManyToMany (cascade= {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name="student_course", joinColumns=@JoinColumn(name="student_id"),
            inverseJoinColumns=@JoinColumn(name="course_id"))
    private Set<Course> courses = new HashSet<>();

    public Student() {
        super();
    }

    public Student(String firstName, String lastName, String email, Address address, int id, List<String> phones, LocalDate birthdate, int age, Tuition tuition, Set<Course> courses) {
        super(firstName, lastName, email, address);
        this.id = id;
        this.phones = phones;
        this.birthdate = birthdate;
        this.age = age;
        this.tuition = tuition;
        this.courses = courses;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public int getAge() {
        return age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<String> getPhones() {
        return phones;
    }

    public void setPhones(List<String> phones) {
        this.phones = phones;
    }

    public Tuition getTuition() {
        return tuition;
    }

    public void setTuition(Tuition tuition) {
        this.tuition = tuition;
    }

    public Set<Course> getCourses() {
        return Collections.unmodifiableSet(courses);
    }

    public void addCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + getFirstName() + '\'' +
                ", lastName='" + getLastName() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", birthdate=" + birthdate +
                ", age=" + age +
                ", tuition=" + tuition +
                '}';
    }
}

