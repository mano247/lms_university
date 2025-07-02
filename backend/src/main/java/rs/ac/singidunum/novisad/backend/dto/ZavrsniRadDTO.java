package rs.ac.singidunum.novisad.backend.dto;


public class ZavrsniRadDTO {
	private Long id;
	private String tema;
	private String link;
	private StudentDTO student;
	private NastavnikDTO mentor;
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
	public StudentDTO getStudent() {
		return student;
	}
	public void setStudent(StudentDTO student) {
		this.student = student;
	}
	public NastavnikDTO getMentor() {
		return mentor;
	}
	public void setMentor(NastavnikDTO mentor) {
		this.mentor = mentor;
	}
	public ZavrsniRadDTO(Long id, String tema, String link, StudentDTO student, NastavnikDTO mentor) {
		super();
		this.id = id;
		this.tema = tema;
		this.link = link;
		this.student = student;
		this.mentor = mentor;
	}
	
	
}
