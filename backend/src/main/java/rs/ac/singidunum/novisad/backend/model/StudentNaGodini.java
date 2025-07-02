package rs.ac.singidunum.novisad.backend.model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import rs.ac.singidunum.novisad.backend.model.academic.StudijskiProgram;
import rs.ac.singidunum.novisad.backend.model.user.Student;

@Entity
public class StudentNaGodini {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date datumUpisa;
	
	@ManyToOne
	@JoinColumn(name = "godinaStudija_id")
	private GodinaStudija godinaStudija;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "studijski_program_id")
	private StudijskiProgram studijskiProgram;

	public StudentNaGodini() {
		super();
	}

	public StudentNaGodini(Long id, Date datumUpisa, GodinaStudija godinaStudija, Student student,
			StudijskiProgram studijskiProgram) {
		super();
		this.id = id;
		this.datumUpisa = datumUpisa;
		this.godinaStudija = godinaStudija;
		this.student = student;
		this.studijskiProgram = studijskiProgram;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getDatumUpisa() {
		return datumUpisa;
	}

	public void setDatumUpisa(Date datumUpisa) {
		this.datumUpisa = datumUpisa;
	}

	public GodinaStudija getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(GodinaStudija godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}
	

	
}
