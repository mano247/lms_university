package rs.ac.singidunum.novisad.backend.model.academic;

import java.util.Date;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

import rs.ac.singidunum.novisad.backend.model.Polaganje;
import rs.ac.singidunum.novisad.backend.model.PredmetnaObavestenja;
import rs.ac.singidunum.novisad.backend.model.user.Nastavnik;
import rs.ac.singidunum.novisad.backend.model.user.Student;

@Entity
@Table(name = "predmeti")
public class Predmet {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String sifraPredmeta;
	
	@Column(columnDefinition = "LONGTEXT")
    private String silabus;
	
	private String naziv;
	
	private int espb;
	
	private Date vremePocetka;
	
	private Date vremeKraja;
	
	@Column(columnDefinition = "LONGTEXT")
	private String opis;
	
	@OneToMany(mappedBy = "predmet")
	private Set<NastavniMaterijal> nastavniMaterijal;
	
	@OneToMany(mappedBy = "predmet")
	private Set<Polaganje> polaganje;
	
	@ManyToOne
    @JoinColumn(name = "nastavnik_id")
    private Nastavnik nastavnik;
	
	@ManyToMany(mappedBy = "predmet")
    private Set<Student> studenti;
	
	@OneToMany(mappedBy = "predmet")
    private Set<PredmetnaObavestenja> obavestenja;
	
	@ManyToOne
    @JoinColumn(name = "studijskiProgram_id")
    private StudijskiProgram studijskiProgram;

	public Predmet() {
		super();
	}

	public Predmet(Long id,String sifraPredmeta, String silabus, String naziv, int espb,
			Date vremePocetka, Date vremeKraja, String opis
			, Set<Polaganje> polaganje, Nastavnik nastavnik,
			Set<Student> studenti, StudijskiProgram studijskiProgram,Set<NastavniMaterijal> nastavniMaterijal, Set<PredmetnaObavestenja> obavestenja) {
		super();
		this.id = id;
		this.sifraPredmeta = sifraPredmeta;
		this.silabus = silabus;
		this.naziv = naziv;
		this.espb = espb;
		this.vremePocetka = vremePocetka;
		this.vremeKraja = vremeKraja;
		this.opis = opis;
		this.nastavniMaterijal = nastavniMaterijal;
		this.polaganje = polaganje;
		this.nastavnik = nastavnik;
		this.studenti = studenti;
		this.obavestenja = obavestenja;
		this.studijskiProgram = studijskiProgram;
	}

	public String getSifraPredmeta() {
		return sifraPredmeta;
	}

	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSilabus() {
		return silabus;
	}

	public void setSilabus(String silabus) {
		this.silabus = silabus;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public int getEspb() {
		return espb;
	}

	public void setEspb(int espb) {
		this.espb = espb;
	}

	
	public Date getVremePocetka() {
		return vremePocetka;
	}

	public void setVremePocetka(Date vremePocetka) {
		this.vremePocetka = vremePocetka;
	}

	public Date getVremeKraja() {
		return vremeKraja;
	}

	public void setVremeKraja(Date vremeKraja) {
		this.vremeKraja = vremeKraja;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public Set<NastavniMaterijal> getNastavniMaterijal() {
		return nastavniMaterijal;
	}

	public void setNastavniMaterijal(Set<NastavniMaterijal> nastavniMaterijal) {
		this.nastavniMaterijal = nastavniMaterijal;
	}

	public Set<Polaganje> getPolaganje() {
		return polaganje;
	}

	public void setPolaganje(Set<Polaganje> polaganje) {
		this.polaganje = polaganje;
	}

	public Nastavnik getNastavnik() {
		return nastavnik;
	}

	public void setNastavnik(Nastavnik nastavnik) {
		this.nastavnik = nastavnik;
	}

	public Set<Student> getStudenti() {
		return studenti;
	}

	public void setStudenti(Set<Student> studenti) {
		this.studenti = studenti;
	}

	public Set<PredmetnaObavestenja> getObavestenja() {
		return obavestenja;
	}

	public void setObavestenja(Set<PredmetnaObavestenja> obavestenja) {
		this.obavestenja = obavestenja;
	}

	public StudijskiProgram getStudijskiProgram() {
		return studijskiProgram;
	}

	public void setStudijskiProgram(StudijskiProgram studijskiProgram) {
		this.studijskiProgram = studijskiProgram;
	}

}
