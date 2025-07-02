package rs.ac.singidunum.novisad.backend.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class ObavestenjeDTO {

	private Long id;
	
	private LocalDateTime vremePostavljanja;
	
	private String sadrzaj;
	
	private String naslov;
	
	private String slika;
	
	private Date vremePocetka;
	
	private Date vremeKraja;

	public ObavestenjeDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ObavestenjeDTO(Long id, LocalDateTime vremePostavljanja, String sadrzaj, String naslov, String slika, Date vremePocetka, Date vremeKraja) {
		super();
		this.id = id;
		this.vremePostavljanja = vremePostavljanja;
		this.sadrzaj = sadrzaj;
		this.naslov = naslov;
		this.slika = slika;
		this.vremePocetka = vremePocetka;
		this.vremeKraja = vremeKraja;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getVremePostavljanja() {
		return vremePostavljanja;
	}

	public void setVremePostavljanja(LocalDateTime vremePostavljanja) {
		this.vremePostavljanja = vremePostavljanja;
	}

	public String getSadrzaj() {
		return sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getSlika() {
		return slika;
	}

	public void setSlika(String slika) {
		this.slika = slika;
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
	
	
}
