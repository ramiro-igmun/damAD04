package entities;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    private String blog;

    private String hobby;

    @OneToOne(fetch = FetchType.LAZY)
    private Instructor instructor;

    public InstructorDetail(String blog, String hobby, Instructor instructor) {
        this.blog = blog;
        this.hobby = hobby;
        this.instructor = instructor;
    }

    public InstructorDetail() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
