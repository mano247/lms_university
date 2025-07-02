package rs.ac.singidunum.novisad.backend.model.academic;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Fakultet{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String sifraFakulteta;
	
	private String naziv;
	private String kontakt;
	
	@Column(columnDefinition = "LONGTEXT")
	private String tekstualniOpis;
	
	private String dekan;
	private String slika;
	private String adresa;
	
	@ManyToOne
	@JoinColumn(name = "univerzitet_id", nullable = false)
	private Univerzitet univerzitet;
	
	@OneToMany(mappedBy = "fakultet")
	private Set<StudijskiProgram> studijskiProgrami;

	public Fakultet() {
		super();
	}

	public Fakultet(Long id,String sifraFakulteta, String naziv, String kontakt, String tekstualniOpis, String dekan, String slika,
			String adresa, Univerzitet univerzitet, Set<StudijskiProgram> studijskiProgrami) {
		super();
		this.id = id;
		this.setSifraFakulteta(sifraFakulteta);
		this.naziv = naziv;
		this.kontakt = kontakt;
		this.tekstualniOpis = tekstualniOpis;
		this.dekan = dekan;
		this.slika = slika;
		this.adresa = adresa;
		this.univerzitet = univerzitet;
		this.studijskiProgrami = studijskiProgrami;
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

	public String getTekstualniOpis() {
		return tekstualniOpis;
	}

	public void setTekstualniOpis(String tekstualniOpis) {
		this.tekstualniOpis = tekstualniOpis;
	}

	public String getDekan() {
		return dekan;
	}

	public void setDekan(String dekan) {
		this.dekan = dekan;
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

	public Univerzitet getUniverzitet() {
		return univerzitet;
	}

	public void setUniverzitet(Univerzitet univerzitet) {
		this.univerzitet = univerzitet;
	}

	public Set<StudijskiProgram> getStudijskiProgrami() {
		return studijskiProgrami;
	}

	public void setStudijskiProgrami(Set<StudijskiProgram> studijskiProgrami) {
		this.studijskiProgrami = studijskiProgrami;
	}

	public String getSifraFakulteta() {
		return sifraFakulteta;
	}

	public void setSifraFakulteta(String sifraFakulteta) {
		this.sifraFakulteta = sifraFakulteta;
	}

}
