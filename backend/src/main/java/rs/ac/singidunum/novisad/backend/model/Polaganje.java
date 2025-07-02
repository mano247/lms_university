package rs.ac.singidunum.novisad.backend.model;

import java.time.LocalDateTime;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import rs.ac.singidunum.novisad.backend.model.academic.Predmet;
import rs.ac.singidunum.novisad.backend.model.user.Nastavnik;
import rs.ac.singidunum.novisad.backend.model.user.Student;

@Entity
@Table(name = "polaganje")
public class Polaganje {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double bodovi;
	private int konacnaOcena;
	private LocalDateTime pocetak;
	private LocalDateTime kraj;
	
	@Column(columnDefinition = "LONGTEXT")
	private String napomena;
	
	@ManyToOne
	@JoinColumn(name = "predmet_id")
	private Predmet predmet;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "obavestenja_id", referencedColumnName = "id")
    private Obavestenje obavestenje;
	
	@ManyToOne
	@JoinColumn(name = "nastavnik_id")
	private Nastavnik nastavnik;

	public Polaganje() {
		super();
	}

	public Polaganje(Long id, double bodovi, int konacnaOcena, LocalDateTime pocetak, LocalDateTime kraj,
			String napomena, Predmet predmet, Student student, Obavestenje obavestenje, Nastavnik nastavnik) {
		super();
		this.id = id;
		this.bodovi = bodovi;
		this.konacnaOcena = konacnaOcena;
		this.pocetak = pocetak;
		this.kraj = kraj;
		this.napomena = napomena;
		this.predmet = predmet;
		this.student = student;
		this.obavestenje = obavestenje;
		this.nastavnik = nastavnik;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
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

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Obavestenje getObavestenje() {
		return obavestenje;
	}

	public void setObavestenje(Obavestenje obavestenje) {
		this.obavestenje = obavestenje;
	}

}
