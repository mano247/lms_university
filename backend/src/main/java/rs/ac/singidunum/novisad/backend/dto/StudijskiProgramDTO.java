package rs.ac.singidunum.novisad.backend.dto;

import java.util.Set;

public class StudijskiProgramDTO {

	private Long id;
	private String sifraSP;
	private String opis;
	
	private String naziv;
	private String rukovodilac;
	private FakultetDTO fakultet;
	private Set<String> predmeti;
	
	public StudijskiProgramDTO() {
		super();
	}
	
	public StudijskiProgramDTO(Long id,String sifraSP, String opis, String naziv, String rukovodilac, FakultetDTO fakultet, Set<String> predmeti) {
		super();
		this.id = id;
		this.sifraSP = sifraSP;
		this.opis = opis;
		this.naziv = naziv;
		this.rukovodilac = rukovodilac;
		this.fakultet = fakultet;
		this.predmeti= predmeti;
	}
	
	public StudijskiProgramDTO(Long id,String sifraSP, String opis, String naziv, String rukovodilac, FakultetDTO fakultet) {
		super();
		this.id = id;
		this.sifraSP = sifraSP;
		this.opis = opis;
		this.naziv = naziv;
		this.rukovodilac = rukovodilac;
		this.fakultet = fakultet;
	}
	
	public StudijskiProgramDTO(Long id,String sifraSP, String naziv) {
		super();
		this.id = id;
		this.sifraSP = sifraSP;
		this.naziv = naziv;
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
	public FakultetDTO getFakultet() {
		return fakultet;
	}
	public void setFakultet(FakultetDTO fakultet) {
		this.fakultet = fakultet;
	}

	public String getSifraSP() {
		return sifraSP;
	}

	public void setSifraSP(String sifraSP) {
		this.sifraSP = sifraSP;
	}

	public Set<String> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(Set<String> predmeti) {
		this.predmeti = predmeti;
	}
}
