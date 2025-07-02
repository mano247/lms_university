package rs.ac.singidunum.novisad.backend.dto;

import java.util.Date;
import java.util.Set;

public class PredmetProfesoraDTO{
	private Long id;
	private String sifraPredmeta;
	private String silabus;
	private String naziv;
	private int espb;
	private NastavnikDTO nastavnik;
	private Date vremePocetka;
	private Date vremeKraja;
    private String opis;
	private String smer;
	private Set<NastavniMaterijalDTO> nastavniMaterijal;
	private Set<StudentDTO> studenti;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getSifraPredmeta() {
		return sifraPredmeta;
	}
	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}
	public String getSilabus() {
		return silabus;
	}
	public void setSilabus(String silabus) {
		this.silabus = silabus;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public int getEspb() {
		return espb;
	}
	public void setEspb(int espb) {
		this.espb = espb;
	}
	public NastavnikDTO getNastavnik() {
		return nastavnik;
	}
	public void setNastavnik(NastavnikDTO nastavnik) {
		this.nastavnik = nastavnik;
	}
	public Date getVremePocetka() {
		return vremePocetka;
	}
	public void setVremePocetka(Date vremePocetka) {
		this.vremePocetka = vremePocetka;
	}
	public Date getVremeKraja() {
		return vremeKraja;
	}
	public void setVremeKraja(Date vremeKraja) {
		this.vremeKraja = vremeKraja;
	}
	public String getOpis() {
		return opis;
	}
	public void setOpis(String opis) {
		this.opis = opis;
	}
	public String getSmer() {
		return smer;
	}
	public void setSmer(String smer) {
		this.smer = smer;
	}
	public Set<NastavniMaterijalDTO> getNastavniMaterijal() {
		return nastavniMaterijal;
	}
	public void setNastavniMaterijal(Set<NastavniMaterijalDTO> nastavniMaterijal) {
		this.nastavniMaterijal = nastavniMaterijal;
	}
	public Set<StudentDTO> getStudenti() {
		return studenti;
	}
	public void setStudenti(Set<StudentDTO> studenti) {
		this.studenti = studenti;
	}
	public PredmetProfesoraDTO(Long id, String sifraPredmeta, String silabus, String naziv, int espb,
			NastavnikDTO nastavnik, Date vremePocetka, Date vremeKraja, String opis, String smer,
			Set<NastavniMaterijalDTO> nastavniMaterijal, Set<StudentDTO> studenti) {
		super();
		this.id = id;
		this.sifraPredmeta = sifraPredmeta;
		this.silabus = silabus;
		this.naziv = naziv;
		this.espb = espb;
		this.nastavnik = nastavnik;
		this.vremePocetka = vremePocetka;
		this.vremeKraja = vremeKraja;
		this.opis = opis;
		this.smer = smer;
		this.nastavniMaterijal = nastavniMaterijal;
		this.studenti = studenti;
	}
	
	
	
}

