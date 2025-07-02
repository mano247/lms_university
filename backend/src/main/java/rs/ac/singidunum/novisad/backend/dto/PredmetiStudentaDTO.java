package rs.ac.singidunum.novisad.backend.dto;

public class PredmetiStudentaDTO {

    private String nazivPredmeta;
    private int espb;
    private Double bodovi;
    private int ocena;

    public PredmetiStudentaDTO(String nazivPredmeta, int espb, Double bodovi, int ocena) {
        this.nazivPredmeta = nazivPredmeta;
        this.espb = espb;
        this.bodovi = bodovi;
        this.ocena = ocena;
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

    public Double getBodovi() {
        return bodovi;
    }

    public void setBodovi(Double bodovi) {
        this.bodovi = bodovi;
    }

    public int getOcena() {
        return ocena;
    }

    public void setOcena(int ocena) {
        this.ocena = ocena;
    }
}
