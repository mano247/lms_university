package rs.ac.singidunum.novisad.backend.model;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "obavestenja")
public class Obavestenje {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private LocalDateTime datum;
	
	@Column(columnDefinition = "LONGTEXT")
	private String sadrzaj;
	
	private String naslov;
	
	private String slika;
	
	private Date vremePocetka;
	
	private Date vremeKraja;
	
	
	public Obavestenje() {
		super();
	}

	public Obavestenje(Long id,  String sadrzaj, String naslov, LocalDateTime datum, String slika, Date vremePocetka, Date vremeKraja) {
		super();
		this.id = id;
		this.datum = datum;
		this.sadrzaj = sadrzaj;
		this.naslov = naslov;
		this.slika = slika;
		this.vremePocetka = vremePocetka;
		this.vremeKraja = vremeKraja;
	}
	
	public Obavestenje(Long id, String naslov, String sadrzaj, LocalDateTime datum, String slika) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.sadrzaj = sadrzaj;
		this.datum = datum;
		this.slika = slika;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDatum() {
		return datum;
	}

	public void setDatum(LocalDateTime datum) {
		this.datum = datum;
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
