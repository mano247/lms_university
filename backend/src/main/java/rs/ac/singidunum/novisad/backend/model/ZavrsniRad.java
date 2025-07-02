package rs.ac.singidunum.novisad.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import rs.ac.singidunum.novisad.backend.model.user.Nastavnik;
import rs.ac.singidunum.novisad.backend.model.user.Student;

@Entity
public class ZavrsniRad {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String tema;

	private String link;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "mentor_id")
	private Nastavnik mentor;
	
	

	public ZavrsniRad(Long id, String tema, String link, Student student, Nastavnik mentor) {
		super();
		this.id = id;
		this.tema = tema;
		this.link = link;
		this.student = student;
		this.mentor = mentor;
	}
	
	public ZavrsniRad() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTema() {
		return tema;
	}

	public void setTema(String tema) {
		this.tema = tema;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Nastavnik getMentor() {
		return mentor;
	}

	public void setMentor(Nastavnik mentor) {
		this.mentor = mentor;
	}
}
