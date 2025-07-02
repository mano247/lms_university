package rs.ac.singidunum.novisad.backend.dto;

import rs.ac.singidunum.novisad.backend.model.Ishod;

public class NastavniMaterijalDTO {
	
private Long id;
	
	private String naslov;
	private String autori;
	private String godinaIzdavanja;
	private String izdavac;
	private String opis;
	private String url;
	private int brojStrana;
	private int kolicina;
	private int izdato;
	private Ishod ishod;
	
	public NastavniMaterijalDTO() {
		super();
	}
	
	public NastavniMaterijalDTO(Long id, String naslov, String autori, String godinaIzdavanja, String izdavac,
			String opis, String url, Ishod ishod ,int kolicina,int izdato) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.autori = autori;
		this.godinaIzdavanja = godinaIzdavanja;
		this.izdavac = izdavac;
		this.opis = opis;
		this.url = url;
		this.ishod = ishod;
		this.kolicina = kolicina;
		this.izdato = izdato;
	}
	
	public NastavniMaterijalDTO(Long id, String naslov, String autori, int brojStrana, String izdavac, String opis,int kolicina,int izdato) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.autori = autori;
		this.brojStrana = brojStrana;
		this.izdavac = izdavac;
		this.opis = opis;
		this.kolicina = kolicina;
		this.izdato = izdato;
	}
	
	public NastavniMaterijalDTO(Long id, String naslov, String autori, int brojStrana, String izdavac, String opis,int kolicina,int izdato, String godinaIzdavanja) {
		super();
		this.id = id;
		this.naslov = naslov;
		this.autori = autori;
		this.brojStrana = brojStrana;
		this.izdavac = izdavac;
		this.opis = opis;
		this.kolicina = kolicina;
		this.izdato = izdato;
		this.godinaIzdavanja = godinaIzdavanja;
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
	public String getAutori() {
		return autori;
	}
	public void setAutori(String autori) {
		this.autori = autori;
	}
	public String getGodinaIzdavanja() {
		return godinaIzdavanja;
	}
	public void setGodinaIzdavanja(String godinaIzdavanja) {
		this.godinaIzdavanja = godinaIzdavanja;
	}
	public String getIzdavac() {
		return izdavac;
	}
	public void setIzdavac(String izdavac) {
		this.izdavac = izdavac;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Ishod getIshod() {
		return ishod;
	}
	public void setIshod(Ishod ishod) {
		this.ishod = ishod;
	}

	public int getBrojStrana() {
		return brojStrana;
	}
	
	public void setBrojStrana(int brojStrana) {
		this.brojStrana = brojStrana;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public int getIzdato() {
		return izdato;
	}

	public void setIzdato(int izdato) {
		this.izdato = izdato;
	}
}
