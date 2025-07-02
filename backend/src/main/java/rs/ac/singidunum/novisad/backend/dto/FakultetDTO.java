package rs.ac.singidunum.novisad.backend.dto;

public class FakultetDTO {

	private Long id;
	private String sifraFakulteta;
	private String naziv;
	private String kontakt;
	private String tekstualniOpis;
	
	private String dekan;
	private String slika;
	private String adresa;
	
	private UniverzitetDTO univerzitet;


	public FakultetDTO(Long id,String sifraFakulteta, String naziv, String kontakt, String tekstualniOpis, String dekan, String slika,String adresa,
			UniverzitetDTO univerzitet) {
		super();
		this.id = id;
		this.sifraFakulteta=sifraFakulteta;
		this.naziv = naziv;
		this.kontakt = kontakt;
		this.tekstualniOpis = tekstualniOpis;
		this.dekan = dekan;
		this.slika = slika;
		this.adresa = adresa;
		this.univerzitet = univerzitet;
	}
	
	public FakultetDTO(Long id,String sifraFakulteta, String naziv) {
		super();
		this.id = id;
		this.sifraFakulteta=sifraFakulteta;
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

	public UniverzitetDTO getNazivUniverziteta() {
		return univerzitet;
	}

	public void setNazivUniverziteta(UniverzitetDTO univerzitet) {
		this.univerzitet = univerzitet;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getSifraFakulteta() {
		return sifraFakulteta;
	}

	public void setSifraFakulteta(String sifraFakulteta) {
		this.sifraFakulteta = sifraFakulteta;
	}

	
	
}
