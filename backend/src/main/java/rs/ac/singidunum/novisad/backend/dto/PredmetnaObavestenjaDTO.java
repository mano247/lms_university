package rs.ac.singidunum.novisad.backend.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class PredmetnaObavestenjaDTO {
    private Long id;

    private String naslov;

    private String sadrzaj;

    private LocalDateTime datum;
    
    private String slikaURL;
    
    private PredmetDTO predmet;
    
    private Date vremePocetka;
	
	private Date vremeKraja;

	public PredmetnaObavestenjaDTO() {
		super();
	}

	public PredmetnaObavestenjaDTO(Long id, String naslov, String sadrzaj, LocalDateTime datum, String slikaURL,
			PredmetDTO predmet, Date vremePocetka, Date vremeKraja) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.sadrzaj = sadrzaj;
		this.datum = datum;
		this.slikaURL = slikaURL;
		this.predmet = predmet;
		this.vremePocetka = vremePocetka;
		this.vremeKraja = vremeKraja;
	}
	
	public PredmetnaObavestenjaDTO(PredmetDTO predmet) {
		super();
		this.predmet = predmet;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaslov() {
		return naslov;
	}

	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}

	public String getSadrzaj() {
		return sadrzaj;
	}

	public void setSadrzaj(String sadrzaj) {
		this.sadrzaj = sadrzaj;
	}

	public LocalDateTime getDatum() {
		return datum;
	}

	public void setDatum(LocalDateTime datum) {
		this.datum = datum;
	}

	public String getSlikaURL() {
		return slikaURL;
	}

	public void setSlikaURL(String slikaURL) {
		this.slikaURL = slikaURL;
	}

	public PredmetDTO getPredmet() {
		return predmet;
	}

	public void setPredmet(PredmetDTO predmet) {
		this.predmet = predmet;
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
