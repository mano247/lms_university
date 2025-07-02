package rs.ac.singidunum.novisad.backend.security.request;

import jakarta.validation.constraints.NotBlank;

public class LoginRequest {
	@NotBlank
	private String email;

	@NotBlank
	private String lozinka;

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
