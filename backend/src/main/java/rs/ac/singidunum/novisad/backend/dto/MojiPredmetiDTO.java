package rs.ac.singidunum.novisad.backend.dto;

public class MojiPredmetiDTO {
    private Long id;

    private String nazivPredmeta;
    private String opis;
    private String silabus;
    private NastavnikDTO profesor;
    private Double bodovi;
    private int espb;
    private int ocena;

    public MojiPredmetiDTO(Long id, String nazivPredmeta, String opis, String silabus, NastavnikDTO profesor, Double bodovi, int espb, int ocena) {
        this.id = id;
        this.nazivPredmeta = nazivPredmeta;
        this.opis = opis;
        this.silabus = silabus;
        this.profesor = profesor;
        this.bodovi = bodovi;
        this.espb = espb;
        this.ocena = ocena;
    }

    public String getNazivPredmeta() {
        return nazivPredmeta;
    }

    public void setNazivPredmeta(String nazivPredmeta) {
        this.nazivPredmeta = nazivPredmeta;
    }

    public String getOpis() {
        return opis;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public String getSilabus() {
        return silabus;
    }

    public void setSilabus(String silabus) {
        this.silabus = silabus;
    }

    public NastavnikDTO getProfesor() {
        return profesor;
    }

    public void setProfesor(NastavnikDTO profesor) {
        this.profesor = profesor;
    }

    public Double getBodovi() {
        return bodovi;
    }

    public void setBodovi(Double bodovi) {
        this.bodovi = bodovi;
    }

    public int getEspb() {
        return espb;
    }

    public void setEspb(int espb) {
        this.espb = espb;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
