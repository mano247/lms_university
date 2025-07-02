package rs.ac.singidunum.novisad.backend.model.academic;

import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "studijski_programi")
public class StudijskiProgram {	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false, unique = true)
	private String sifraSP;
	
	@Column(columnDefinition = "LONGTEXT")
    private String opis;
	
	private String naziv;
	private String rukovodilac;
	
	@ManyToOne
	@JoinColumn(name = "fakultet_id", nullable = false)
	private Fakultet fakultet;
	
	@OneToMany(mappedBy = "studijskiProgram")
	private Set<Predmet> predmeti;
	

	public StudijskiProgram() {
		super();
	}

	public StudijskiProgram(Long id,String sifraSP,  String opis, String naziv, String rukovodilac,
			Fakultet fakultet, Set<Predmet> predmeti) {
		super();
		this.id = id;
		this.sifraSP = sifraSP;
		this.opis = opis;
		this.naziv = naziv;
		this.rukovodilac = rukovodilac;
		this.fakultet = fakultet;
		this.predmeti = predmeti;
	}

	public String getSifraSP() {
		return sifraSP;
	}

	public void setSifraSP(String sifraSP) {
		this.sifraSP = sifraSP;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getRukovodilac() {
		return rukovodilac;
	}

	public void setRukovodilac(String rukovodilac) {
		this.rukovodilac = rukovodilac;
	}

	public Fakultet getFakultet() {
		return fakultet;
	}

	public void setFakultet(Fakultet fakultet) {
		this.fakultet = fakultet;
	}

	public Set<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(Set<Predmet> predmeti) {
		this.predmeti = predmeti;
	}
}
