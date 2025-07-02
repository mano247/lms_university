package rs.ac.singidunum.novisad.backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class KancelariskiMaterijal {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private String naziv;
	private int kolicina;
	private int izdato;
	
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
	
	public KancelariskiMaterijal(Long id, String naziv, int kolicina, int izdato) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.kolicina = kolicina;
		this.izdato = izdato;
	}
	
	public KancelariskiMaterijal() {
		super();
	}
	
}
