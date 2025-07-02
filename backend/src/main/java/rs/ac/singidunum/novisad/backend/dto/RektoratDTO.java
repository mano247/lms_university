package rs.ac.singidunum.novisad.backend.dto;

import java.util.Set;

public class RektoratDTO {

	private Long id;
	private String naziv;
	private String kontakt;
	private String slika;
	private String adresa;
	private String imeRektora;

	
	private Set<UniverzitetDTO> univerziteti;

	public RektoratDTO() {
		super();
	}

	public RektoratDTO(Long id, String naziv, String kontakt, String slika, String adresa,String imeRektora,
			Set<UniverzitetDTO> univerziteti) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.kontakt = kontakt;
		this.slika = slika;
		this.adresa = adresa;
		this.imeRektora = imeRektora;
		this.univerziteti = univerziteti;
	}
	
	public RektoratDTO(Long id, String naziv, String kontakt, String slika, String adresa,String imeRektora) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.kontakt = kontakt;
		this.slika = slika;
		this.adresa = adresa;
		this.imeRektora = imeRektora;
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

	public Set<UniverzitetDTO> getUniverziteti() {
		return univerziteti;
	}

	public void setUniverziteti(Set<UniverzitetDTO> univerziteti) {
		this.univerziteti = univerziteti;
	}

	public String getIme_rektora() {
		return imeRektora;
	}

	public void setIme_rektora(String imeRektora) {
		this.imeRektora = imeRektora;
	}
	
	
}