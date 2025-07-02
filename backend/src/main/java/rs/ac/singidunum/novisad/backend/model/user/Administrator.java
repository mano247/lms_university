package rs.ac.singidunum.novisad.backend.model.user;

import java.util.Set;

import jakarta.persistence.Entity;
import rs.ac.singidunum.novisad.backend.model.Permission;

	@Entity
	public class Administrator extends RegistrovaniKorisnik{
		
		public Administrator() {
			super();
		}

		public Administrator(Long id, String korisnickoIme, String lozinka, String email, Set<Permission> permissions) {
			super(id, korisnickoIme, lozinka, email, permissions);
		}
		
		public Administrator(Long id, String ime, String prezime,String korisnickoIme, String email, String lozinka, Set<Permission> permissions) {
			super(id,ime, prezime, korisnickoIme, email, lozinka, permissions);
		}
}
