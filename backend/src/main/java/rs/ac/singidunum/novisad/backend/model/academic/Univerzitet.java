package rs.ac.singidunum.novisad.backend.model.academic;

import java.time.LocalDateTime;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import rs.ac.singidunum.novisad.backend.model.Rektorat;
import rs.ac.singidunum.novisad.backend.model.user.Nastavnik;

@Entity
public class Univerzitet{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String naziv;
	private LocalDateTime datumOsnivanja;
	private String kontakt;
	
	@Column(columnDefinition = "LONGTEXT")
	private String opis;
	
	private String slika;
	private String adresa;
	
	@OneToMany(mappedBy = "univerzitet")
	private Set<Fakultet> fakulteti;
	
	@OneToMany(mappedBy = "univerzitet")
	private Set<Nastavnik> nastavnici;
	
	@ManyToOne
    @JoinColumn(name = "rektorat_id")
    @JsonIgnore
    private Rektorat rektorat;
	
	public Univerzitet() {
		super();
		
	}

	public Univerzitet(Long id, String naziv, LocalDateTime datumOsnivanja, String kontakt, String opis,
			String slika, String adresa, Set<Fakultet> fakulteti, Set<Nastavnik> nastavnici, Rektorat rektorat) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
		this.kontakt = kontakt;
		this.opis = opis;
		this.slika = slika;
		this.adresa = adresa;
		this.fakulteti = fakulteti;
		this.nastavnici = nastavnici;
		this.rektorat = rektorat;
	}

	public Rektorat getRektorat() {
		return rektorat;
	}

	public void setRektorat(Rektorat rektorat) {
		this.rektorat = rektorat;
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

	public LocalDateTime getDatumOsnivanja() {
		return datumOsnivanja;
	}

	public void setDatumOsnivanja(LocalDateTime datumOsnivanja) {
		this.datumOsnivanja = datumOsnivanja;
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
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

	public Set<Fakultet> getFakulteti() {
		return fakulteti;
	}

	public void setFakulteti(Set<Fakultet> fakulteti) {
		this.fakulteti = fakulteti;
	}

	public Set<Nastavnik> getNastavnici() {
		return nastavnici;
	}

	public void setNastavnici(Set<Nastavnik> nastavnici) {
		this.nastavnici = nastavnici;
	}



}
