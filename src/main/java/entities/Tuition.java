package entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="tuition")
public class Tuition {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column (name="fee")
	private Double fee;

	@OneToOne (cascade=CascadeType.ALL)
	@JoinColumn(name="student_id", referencedColumnName="id")
	private Student student;

    public Tuition(int id, Double fee, Student student) {
        this.id = id;
        this.fee = fee;
        this.student = student;
    }

    public Tuition() {
    }

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Double getFee() {
		return fee;
	}

	public void setFee(Double fee) {
		this.fee = fee;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

    @Override
    public String toString() {
        return fee.toString();
    }
}
