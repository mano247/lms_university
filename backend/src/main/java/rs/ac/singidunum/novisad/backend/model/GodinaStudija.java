package rs.ac.singidunum.novisad.backend.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import rs.ac.singidunum.novisad.backend.model.user.Student;

@Entity
public class GodinaStudija {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	private int godina;
	


	public GodinaStudija() {
		super();
	}

	public GodinaStudija(Long id, int godina,
			Set<Student> studenti) {
		super();
		this.id = id;
	}
	
	public GodinaStudija(Long id, int godina) {
		super();
		this.id = id;
		this.godina = godina;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}
}
