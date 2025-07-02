package rs.ac.singidunum.novisad.backend.model.user;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import rs.ac.singidunum.novisad.backend.model.Permission;

@Entity
@Table(name = "registrovani_korisnici",
	uniqueConstraints = {
				@UniqueConstraint(columnNames = "email")
		})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class RegistrovaniKorisnik {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Long id;
		
		private String korisnickoIme;
		
		private String lozinka;
		
		private String email;
		
		private String ime;
		
		private String prezime;
		
		@ManyToMany(fetch = FetchType.LAZY)
		@JoinTable(name = "registrovani_korisnik_permissions",
				joinColumns = @JoinColumn(name = "registrovaniKorisnik_id"),
				inverseJoinColumns = @JoinColumn(name = "permission_id"))
		private Set<Permission> permissions = new HashSet<>();
		
		public  RegistrovaniKorisnik() {
			super();
		}

		public RegistrovaniKorisnik(Long id, String korisnickoIme, String lozinka, String email,
				Set<Permission> permissions) {
			super();
			this.id = id;
			this.korisnickoIme = korisnickoIme;
			this.lozinka = lozinka;
			this.email = email;
			this.permissions = permissions;
			
		}
		
		public RegistrovaniKorisnik(Long id, String korisnickoIme, String lozinka, String email) {
			super();
			this.id = id;
			this.korisnickoIme = korisnickoIme;
			this.lozinka = lozinka;
			this.email = email;
		}
		
		public RegistrovaniKorisnik( String email, String lozinka, String korisnickoIme) {
			this.email = email;
			this.lozinka = lozinka;
			this.korisnickoIme = korisnickoIme;
		}
		
		public RegistrovaniKorisnik(String korisnickoIme, String ime, String prezime, String email, String lozinka) {
			this.korisnickoIme = korisnickoIme;
			this.ime = ime;
			this.prezime = prezime;
			this.email = email;
			this.lozinka = lozinka;
		}
		
		public RegistrovaniKorisnik(String ime, String prezime, String email, String lozinka) {
			this.ime = ime;
			this.prezime = prezime;
			this.email = email;
			this.lozinka = lozinka;
		}

		public RegistrovaniKorisnik(Long id, String ime, String prezime, String email, String lozinka, Set<Permission> permissions) {
			this.id = id;
			this.ime = ime;
			this.prezime = prezime;
			this.email = email;
			this.lozinka = lozinka;
			this.permissions = permissions;
		}
		
		public RegistrovaniKorisnik(Long id, String ime, String prezime,String korisnickoIme, String email, String lozinka, Set<Permission> permissions) {
			this.id = id;
			this.ime = ime;
			this.prezime = prezime;
			this.korisnickoIme = korisnickoIme;
			this.email = email;
			this.lozinka = lozinka;
			this.permissions = permissions;
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

		public Set<Permission> getPermissions() {
			return permissions;
		}

		public void setPermissions(Set<Permission> permissions) {
			this.permissions = permissions;
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
