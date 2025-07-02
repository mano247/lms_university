package rs.ac.singidunum.novisad.backend.dto;

import jakarta.persistence.Column;

import java.util.List;

public class DodajOcenuDTO {

    private Long idPredmeta;
    private String nazivPredmeta;
    private int espb;
    @Column(columnDefinition = "LONGTEXT")
    private String silabus;

    private List<SviStudentiNastavnikaDTO> studentiNaPredmetu;


    public DodajOcenuDTO(Long idPredmeta, String nazivPredmeta, int espb, String silabus, List<SviStudentiNastavnikaDTO> studentiNaPredmetu) {
        this.idPredmeta = idPredmeta;
        this.nazivPredmeta = nazivPredmeta;
        this.espb = espb;
        this.silabus = silabus;
        this.studentiNaPredmetu = studentiNaPredmetu;

    }

    public Long getIdPredmeta() {
        return idPredmeta;
    }

    public void setIdPredmeta(Long idPredmeta) {
        this.idPredmeta = idPredmeta;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    public String getSilabus() {
        return silabus;
    }

    public void setSilabus(String silabus) {
        this.silabus = silabus;
    }

    public List<SviStudentiNastavnikaDTO> getStudentiNaPredmetu() {
        return studentiNaPredmetu;
    }

    public void setStudentiNaPredmetu(List<SviStudentiNastavnikaDTO> studentiNaPredmetu) {
        this.studentiNaPredmetu = studentiNaPredmetu;
    }
}
