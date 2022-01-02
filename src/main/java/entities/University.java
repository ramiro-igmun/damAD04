package entities;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "university")
public class University {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Embedded
    private Address address;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_university")
    private List<Student> students;

    public University(int id, String name, Address address, List<Student> students) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.students = students;
    }

    public University() {

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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

}
