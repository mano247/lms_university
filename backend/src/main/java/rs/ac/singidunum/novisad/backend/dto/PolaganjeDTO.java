package rs.ac.singidunum.novisad.backend.dto;

import java.time.LocalDateTime;

public class PolaganjeDTO {
	private Long id;
	private double bodovi;
	private int konacnaOcena;
	private LocalDateTime pocetak;
	private LocalDateTime kraj;
	private String napomena;
	
	private StudentDTO student;
	private PredmetDTO predmet;
	private NastavnikDTO nastavnik;
	
	public PolaganjeDTO() {
		super();
	}
	
	public PolaganjeDTO(Long id, double bodovi, int konacnaOcena, LocalDateTime pocetak, LocalDateTime kraj,
			String napomena, StudentDTO student, PredmetDTO predmet, NastavnikDTO nastavnik) {
		super();
		this.id = id;
		this.bodovi = bodovi;
		this.konacnaOcena = konacnaOcena;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.napomena = napomena;
		this.student = student;
		this.predmet = predmet;
		this.nastavnik = nastavnik;
	}


	public NastavnikDTO getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(NastavnikDTO nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public double getBodovi() {
		return bodovi;
	}
	public void setBodovi(double bodovi) {
		this.bodovi = bodovi;
	}
	public int getKonacnaOcena() {
		return konacnaOcena;
	}
	public void setKonacnaOcena(int konacnaOcena) {
		this.konacnaOcena = konacnaOcena;
	}
	public LocalDateTime getPocetak() {
		return pocetak;
	}
	public void setPocetak(LocalDateTime pocetak) {
		this.pocetak = pocetak;
	}
	public LocalDateTime getKraj() {
		return kraj;
	}
	public void setKraj(LocalDateTime kraj) {
		this.kraj = kraj;
	}
	public String getNapomena() {
		return napomena;
	}
	public void setNapomena(String napomena) {
		this.napomena = napomena;
	}
	public StudentDTO getStudent() {
		return student;
	}
	public void setStudent(StudentDTO student) {
		this.student = student;
	}
	public PredmetDTO getPredmet() {
		return predmet;
	}
	public void setPredmet(PredmetDTO predmet) {
		this.predmet = predmet;
	}
}
