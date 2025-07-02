package rs.ac.singidunum.novisad.backend.dto;

import java.time.LocalDateTime;

public class UniverzitetDTO {
	private Long id;
	private String naziv;
	private LocalDateTime datumOsnivanja;
	private String kontakt;
	private String rektor;
	private String adresa;
	private String opis;
	private String slika;
    private RektoratDTO rektorat;

	public UniverzitetDTO() {
		super();
	}

	public UniverzitetDTO(Long id, String naziv, LocalDateTime datumOsnivanja, String kontakt, String opis,
			String slika, String adresa, RektoratDTO rektorat) {
		this.id = id;
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
		this.kontakt = kontakt;
		this.opis = opis;
		this.slika = slika;
		this.adresa = adresa;
		this.rektorat=rektorat;;
	}

	public UniverzitetDTO(Long id, String naziv, LocalDateTime datumOsnivanja, String kontakt, String opis,
			String slika, String adresa) {
		this.id = id;
		this.naziv = naziv;
		this.datumOsnivanja = datumOsnivanja;
		this.kontakt = kontakt;
		this.opis = opis;
		this.slika = slika;
		this.adresa = adresa;
	}
	
	public UniverzitetDTO(Long id, String naziv) {
		this.id = id;
		this.naziv = naziv;
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

	public String getRektor() {
		return rektor;
	}

	public void setRektor(String rektor) {
		this.rektor = rektor;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
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

	public RektoratDTO getRektorat() {
		return rektorat;
	}

	public void setRektorat(RektoratDTO rektorat) {
		this.rektorat = rektorat;
	}
	
	

}
