package rs.ac.singidunum.novisad.backend.model.user;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinTable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import rs.ac.singidunum.novisad.backend.model.GodinaStudija;
import rs.ac.singidunum.novisad.backend.model.Permission;
import rs.ac.singidunum.novisad.backend.model.Polaganje;
import rs.ac.singidunum.novisad.backend.model.academic.Fakultet;
import rs.ac.singidunum.novisad.backend.model.academic.Predmet;

@Entity
public class Student extends RegistrovaniKorisnik{
	private String brojIndeksa;
	
	@ManyToOne
	@JoinColumn(name="fakultet_id")
	Fakultet fakultet;

	@ManyToMany
	@JoinTable(
	  name = "studentNaGodini", 
	  joinColumns = @JoinColumn(name = "student_id"), 
	  inverseJoinColumns = @JoinColumn(name = "godinaStudija_id"))
	Set<GodinaStudija> godinaStudija;
	
	@OneToMany(mappedBy = "student")
	private Set<Polaganje> polaganja;
	
	@ManyToMany
    @JoinTable(
        name = "studentiPredmeti",
        joinColumns = @JoinColumn(name = "student_id"),
        inverseJoinColumns = @JoinColumn(name = "predmet_id"))
    private Set<Predmet> predmet;
	
	
	public Student() {
		super();
	}
	
	public Student(Long id, String korisnickoIme, String email, String lozinka, Set<Permission> permissions, String brojIndeksa, Fakultet fakultet) {
		super(id, korisnickoIme, email, lozinka, permissions);
		this.brojIndeksa = brojIndeksa;
		this.fakultet = fakultet;
	}
	
	public Student(Long id, String ime, String prezime, String email, String lozinka, Set<Permission> permissions, String brojIndeksa, Set<Predmet> predmet, Fakultet fakultet) {
		super(id, ime, prezime, email, lozinka, permissions);
		this.brojIndeksa = brojIndeksa;
		this.fakultet = fakultet;
		this.predmet = predmet;
	}

	public Student(Long id, String ime, String prezime, String email, String lozinka, Set<Permission> permissions, String brojIndeksa, Set<Predmet> predmet, Set<Polaganje> polaganja, Fakultet fakultet) {
		super(id, ime, prezime, email, lozinka, permissions);
		this.brojIndeksa = brojIndeksa;
		this.fakultet = fakultet;
		this.predmet = predmet;
		this.polaganja = polaganja;
	}
	
	public Student(Long id, String ime, String prezime, String email, String lozinka, Set<Permission> permissions, String brojIndeksa, Set<Predmet> predmet, Set<Polaganje> polaganja, Set<GodinaStudija> godinaStudija, Fakultet fakultet) {
		super(id, ime, prezime, email, lozinka, permissions);
		this.brojIndeksa = brojIndeksa;
		this.fakultet = fakultet;
		this.predmet = predmet;
		this.polaganja = polaganja;
		this.godinaStudija = godinaStudija;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}

	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}

	public Set<GodinaStudija> getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(Set<GodinaStudija> godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Set<Polaganje> getPolaganja() {
		return polaganja;
	}

	public void setPolaganja(Set<Polaganje> polaganja) {
		this.polaganja = polaganja;
	}

	public Set<Predmet> getPredmet() {
		return predmet;
	}

	public void setPredmet(Set<Predmet> predmet) {
		this.predmet = predmet;
	}
	
	public Fakultet getFakultet() {
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}

	@Override
	public String toString() {
		return "Student [brojIndeksa=" + brojIndeksa + ", fakultet=" + fakultet + ", godinaStudija=" + godinaStudija
				+ ", polaganja=" + polaganja + ", predmet=" + predmet + "]";
	}
}
