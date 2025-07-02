package rs.ac.singidunum.novisad.backend.dto;

import java.util.Date;
import java.util.Set;


public class PredmetDTO{
	private Long id;
	private String sifraPredmeta;
	
	private String silabus;
	
	private String naziv;
	
	private int espb;
	
	private NastavnikDTO nastavnik;
	
	private Date vremePocetka;
	
	private Date vremeKraja;
	
    private String opis;
	
	private StudijskiProgramDTO smer;
	
	private Set<NastavniMaterijalDTO> nastavniMaterijal;

	public PredmetDTO() {
		super();
	}
	
	public PredmetDTO(Long id,String sifraPredmeta, String silabus, String naziv, int espb,
			NastavnikDTO nastavnik, Date vremePocetka, Date vremeKraja, String opis,
			Set<NastavniMaterijalDTO> nastavniMaterijal) {
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
		this.nastavniMaterijal = nastavniMaterijal;
	}
	
	public PredmetDTO(Long id,String sifraPredmeta,StudijskiProgramDTO smer, String silabus, String naziv, int espb,
			NastavnikDTO nastavnik, Date vremePocetka, Date vremeKraja, String opis,
			Set<NastavniMaterijalDTO> nastavniMaterijal) {
		super();
		this.id = id;
		this.sifraPredmeta = sifraPredmeta;
		this.smer = smer;
		this.silabus = silabus;
		this.naziv = naziv;
		this.espb = espb;
		this.nastavnik = nastavnik;
		this.vremePocetka = vremePocetka;
		this.vremeKraja = vremeKraja;
		this.opis = opis;
		this.nastavniMaterijal = nastavniMaterijal;
	}
	
	public PredmetDTO(Long id,String sifraPredmeta, NastavnikDTO nastavnik, StudijskiProgramDTO smer, String naziv, int espb, String opis, String silabus, Set<NastavniMaterijalDTO> nastavniMaterijal) {
		this.id = id;
		this.sifraPredmeta = sifraPredmeta;
		this.nastavnik = nastavnik;
		this.smer = smer;
		this.naziv = naziv;
		this.espb = espb;
		this.opis = opis;
		this.silabus = silabus;
		this.nastavniMaterijal = nastavniMaterijal;
	}
	
	public PredmetDTO(Long id,String sifraPredmeta, NastavnikDTO nastavnik, StudijskiProgramDTO smer, String naziv, int espb, String opis, String silabus) {
		this.id = id;
		this.sifraPredmeta = sifraPredmeta;
		this.nastavnik = nastavnik;
		this.smer = smer;
		this.naziv = naziv;
		this.espb = espb;
		this.opis = opis;
		this.silabus = silabus;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<NastavniMaterijalDTO> getNastavniMaterijal() {
		return nastavniMaterijal;
	}

	public void setNastavniMaterijal(Set<NastavniMaterijalDTO> nastavniMaterijal) {
		this.nastavniMaterijal = nastavniMaterijal;
	}

	public StudijskiProgramDTO getSmer() {
		return smer;
	}

	public void setSmer(StudijskiProgramDTO smer) {
		this.smer = smer;
	}

	public String getSifraPredmeta() {
		return sifraPredmeta;
	}

	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}
}
