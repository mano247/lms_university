package rs.ac.singidunum.novisad.backend.dto;

public class StudentskaSluzbaDTO {

	private String tipZaIzmenu;
	private Long id;
	private String korisnickoIme, lozinka, email, ime , prezime;
	


	public StudentskaSluzbaDTO() {
		super();
	}
	
	public StudentskaSluzbaDTO(Long id, String tipZaIzmenu, String korisnickoIme, String email, String lozinka, String ime, String prezime) {
		super();
		this.tipZaIzmenu = tipZaIzmenu;
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.email = email;
		this.ime = ime;
		this.prezime = prezime;
	}
	
	public String getTipZaIzmenu() {
		return tipZaIzmenu;
	}
	public void setTipZaIzmenu(String tipZaIzmenu) {
		this.tipZaIzmenu = tipZaIzmenu;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getLozinka() {
		return lozinka;
	}
	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	
}
