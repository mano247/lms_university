package rs.ac.singidunum.novisad.backend.dto;

import java.util.HashSet;
import java.util.Set;

import rs.ac.singidunum.novisad.backend.model.Permission;

public class RegistrovaniKorisnikDTO {
	
	private String tipZaIzmenu;
	private Long id;
	private String korisnickoIme;
	private String email;
	private String lozinka;
	private String ime;
	private String prezime;
	
	private Set<Permission> permission = new HashSet<>();

	public RegistrovaniKorisnikDTO() {
		super();
	}

	public RegistrovaniKorisnikDTO(String tipZaIzmenu, Long id, String korisnickoIme, String email, String lozinka,
			Set<Permission> permission,String ime ,String prezime) {
		super();
		this.tipZaIzmenu = tipZaIzmenu;
		this.id = id;
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.email = email;
		this.permission = permission;
		this.ime = ime;
		this.prezime = prezime;
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

	public Set<Permission> getPermission() {
		return permission;
	}

	public void setPermission(Set<Permission> permission) {
		this.permission = permission;
	}
	
	
	
}
