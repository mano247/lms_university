package rs.ac.singidunum.novisad.backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class NastavnikNaRealizaciji {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private int brojCasova;
	
	@Column(name = "nastavnik_id")
	private Long nastavnik_id;
	
	@Enumerated(EnumType.STRING)
	private TipNastave tip_nastave;



	public NastavnikNaRealizaciji() {
		super();
	}

	public NastavnikNaRealizaciji(Long id, int brojCasova, Long nastavnik_id, TipNastave tip_nastave) {
		super();
		this.id = id;
		this.brojCasova = brojCasova;
		this.nastavnik_id = nastavnik_id;
		this.tip_nastave = tip_nastave;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getBrojCasova() {
		return brojCasova;
	}

	public void setBrojCasova(int brojCasova) {
		this.brojCasova = brojCasova;
	}

	public Long getNastavnik_id() {
		return nastavnik_id;
	}

	public void setNastavnik_id(Long nastavnik_id) {
		this.nastavnik_id = nastavnik_id;
	}
	
	public TipNastave getTip_nastave() {
		return tip_nastave;
	}

	public void setTip_nastave(TipNastave tip_nastave) {
		this.tip_nastave = tip_nastave;
	}
}
