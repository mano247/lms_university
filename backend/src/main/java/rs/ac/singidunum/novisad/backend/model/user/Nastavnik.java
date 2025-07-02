package rs.ac.singidunum.novisad.backend.model.user;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import rs.ac.singidunum.novisad.backend.model.Polaganje;
import rs.ac.singidunum.novisad.backend.model.academic.Predmet;
import rs.ac.singidunum.novisad.backend.model.academic.Univerzitet;

@Entity
public class Nastavnik extends RegistrovaniKorisnik{
	private String biografija;
	private String jmbg;
	
	@ManyToOne
	@JoinColumn(name = "univerzitet_id")
	private Univerzitet univerzitet;
	
	@OneToMany(mappedBy = "nastavnik")
	private Set<Predmet> predmeti;
	
	@OneToMany(mappedBy = "nastavnik")
	private Set<Polaganje> polaganja;
	
	public Nastavnik() {
		super();
	}

	public Nastavnik(String ime, String prezime, String email, String lozinka) {
		super(ime, prezime, email, lozinka);
	}

	public Nastavnik(String biografija, String jmbg, Univerzitet univerzitet, Set<Predmet> predmeti, Set<Polaganje> polaganja) {
		super();
		this.biografija = biografija;
		this.jmbg = jmbg;
		this.univerzitet = univerzitet;
		this.predmeti = predmeti;
		this.polaganja = polaganja;
	}

	public Set<Polaganje> getPolaganja() {
		return polaganja;
	}

	public void setPolaganja(Set<Polaganje> polaganja) {
		this.polaganja = polaganja;
	}

	public String getBiografija() {
		return biografija;
	}

	public void setBiografija(String biografija) {
		this.biografija = biografija;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public Univerzitet getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(Univerzitet univerzitet) {
		this.univerzitet = univerzitet;
	}

	public Set<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(Set<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

}
