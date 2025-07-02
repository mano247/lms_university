package rs.ac.singidunum.novisad.backend.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import rs.ac.singidunum.novisad.backend.model.academic.Univerzitet;

@Entity
public class Rektorat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String naziv;
	private String kontakt;
	private String slika;
	private String adresa;
	private String imeRektora;
	
	@OneToMany(mappedBy = "rektorat")
    private Set<Univerzitet> univerziteti;

	public Rektorat() {
		super();
	}

	public Rektorat(Long id, String naziv, String imeRektora, String kontakt, String slika, String adresa, Set<Univerzitet> univerziteti) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.imeRektora = imeRektora;
		this.kontakt = kontakt;
		this.slika = slika;
		this.adresa = adresa;
		this.univerziteti = univerziteti;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Set<Univerzitet> getUniverziteti() {
		return univerziteti;
	}

	public void setUniverziteti(Set<Univerzitet> univerziteti) {
		this.univerziteti = univerziteti;
	}

	public String getIme_rektora() {
		return imeRektora;
	}

	public void setIme_rektora(String imeRektora) {
		this.imeRektora = imeRektora;
	}
}
