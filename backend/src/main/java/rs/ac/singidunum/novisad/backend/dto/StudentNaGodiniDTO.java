package rs.ac.singidunum.novisad.backend.dto;

import java.sql.Date;


public class StudentNaGodiniDTO {
	
	private Long id;
	private Date datumUpisa;
	private GodinaStudijaDTO godinaStudija;
	private StudentDTO student;
	private StudijskiProgramDTO studijskiProgram;
	
	
	
	public StudentNaGodiniDTO() {
		super();
	}
	
	public StudentNaGodiniDTO(Long id, Date datumUpisa, GodinaStudijaDTO godinaStudija, StudentDTO student,
			StudijskiProgramDTO studijskiProgram) {
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
	public GodinaStudijaDTO getGodinaStudija() {
		return godinaStudija;
	}
	public void setGodinaStudija(GodinaStudijaDTO godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
	public StudentDTO getStudent() {
		return student;
	}
	public void setStudent(StudentDTO student) {
		this.student = student;
	}
	public StudijskiProgramDTO getStudijskiProgram() {
		return studijskiProgram;
	}
	public void setStudijskiProgram(StudijskiProgramDTO studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

}
