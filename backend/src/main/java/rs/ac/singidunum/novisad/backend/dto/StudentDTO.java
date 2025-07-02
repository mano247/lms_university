package rs.ac.singidunum.novisad.backend.dto;

import java.util.HashSet;
import java.util.Set;

import rs.ac.singidunum.novisad.backend.model.Permission;
import rs.ac.singidunum.novisad.backend.model.academic.Fakultet;

public class StudentDTO {
	
	private String tipZaIzmenu;
	private Long id;
	private String email;
	private String korisnickoIme;
	private String brojIndeksa;
	private String lozinka;
    private String ime;
    private String prezime;
    private Fakultet fakultet;
	private Set<Permission> permission = new HashSet<>();


	public StudentDTO() {
		super();
	}
	
	public StudentDTO(Long id, String email, String korisnickoIme, String brojIndeksa, String ime, String prezime,
			Fakultet fakultet) {
		super();
		this.id = id;
		this.email = email;
		this.korisnickoIme = korisnickoIme;
		this.brojIndeksa = brojIndeksa;
		this.ime = ime;
		this.prezime = prezime;
		this.fakultet = fakultet;
	}


	public StudentDTO(Long id, String tipZaIzmenu, String email, String lozinka, String korisnickoIme, String brojIndeksa,
			Set<Permission> permission) {
		super();

		this.id = id;
		this.tipZaIzmenu = tipZaIzmenu;
		this.email = email;
		this.korisnickoIme = korisnickoIme;
		this.brojIndeksa = brojIndeksa;
		this.permission = permission;
		this.lozinka = lozinka;
	}
	
	public StudentDTO(Long id, String ime, String prezime, String email, String lozinka, String brojIndeksa, String korisnickoIme) {
		super();
		this.id = id;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.lozinka = lozinka;
		this.brojIndeksa = brojIndeksa;
		this.korisnickoIme = korisnickoIme;

	}
	
	public StudentDTO(Long id, String tipZaIzmenu, String ime, String prezime, String email, String lozinka, Set<Permission> permission, String brojIndeksa, String korisnickoIme) {
		super();
		this.id = id;
		this.tipZaIzmenu = tipZaIzmenu;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.lozinka = lozinka;
		this.brojIndeksa = brojIndeksa;
		this.permission = permission;
		this.korisnickoIme = korisnickoIme;

	}
	
	public StudentDTO(Long id, String tipZaIzmenu, String ime, String prezime, String email, String lozinka, Set<Permission> permission, String brojIndeksa, String korisnickoIme,Fakultet fakultet) {
		super();
		this.id = id;
		this.tipZaIzmenu = tipZaIzmenu;
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.lozinka = lozinka;
		this.brojIndeksa = brojIndeksa;
		this.permission = permission;
		this.korisnickoIme = korisnickoIme;
		this.fakultet = fakultet;

	}

	public Fakultet getFakultet() {
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}

	public String getBrojIndeksa() {
		return brojIndeksa;
	}


	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public Set<Permission> getPermission() {
		return permission;
	}

	public void setPermission(Set<Permission> permission) {
		this.permission = permission;
	}
	
	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
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
