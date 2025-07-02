package rs.ac.singidunum.novisad.backend.security.request;
import java.util.Set;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class SignupRequest {
	
  private String korisnickoIme;
	
  @NotBlank
  @Email
  private String email;

  private Set<String> permission;

  @NotBlank
  private String lozinka;

 
 
  public String getKorisnickoIme() {
	return korisnickoIme;
}

public void setKorisnickoIme(String korisnickoIme) {
	this.korisnickoIme = korisnickoIme;
}

public Set<String> getPermission() {
	return permission;
}

public void setPermission(Set<String> permission) {
	this.permission = permission;
}

public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  

  public String getLozinka() {
    return lozinka;
  }

  public void setLozinka(String lozinka) {
    this.lozinka = lozinka;
  }
}
