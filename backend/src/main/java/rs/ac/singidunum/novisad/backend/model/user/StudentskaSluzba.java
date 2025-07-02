package rs.ac.singidunum.novisad.backend.model.user;

import java.util.Set;

import jakarta.persistence.Entity;
import rs.ac.singidunum.novisad.backend.model.Permission;

@Entity
public class StudentskaSluzba extends RegistrovaniKorisnik{

	public StudentskaSluzba() {
		super();
	}

	public StudentskaSluzba(Long id, String ime, String prezime,String korisnickoIme, String email, String lozinka, Set<Permission> permissions) {
		super(id, ime, prezime, korisnickoIme, email, lozinka, permissions);
	}
	
	public StudentskaSluzba(String korisnickoIme, String lozinka, String email) {
		super(korisnickoIme, lozinka, email);
	}
}
