package rs.ac.singidunum.novisad.backend.dto;

public class SviStudentiNastavnikaDTO {

    private Long idStudenta;
    private String imeStudenta;
    private String prezimeStudenta;
    private String brojIndeksa;

    private Long idPolaganja;
    private Double bodovi;
    private int ocena;

    public SviStudentiNastavnikaDTO(Long idStudenta, Long idPolaganja, String imeStudenta, String prezimeStudenta, String brojIndeksa, Double bodovi, int ocena) {
        this.idStudenta = idStudenta;
        this.idPolaganja = idPolaganja;
        this.imeStudenta = imeStudenta;
        this.prezimeStudenta = prezimeStudenta;
        this.brojIndeksa = brojIndeksa;
        this.bodovi = bodovi;
        this.ocena = ocena;
    }

    public Long getIdStudenta() {
        return idStudenta;
    }

    public void setIdStudenta(Long idStudenta) {
        this.idStudenta = idStudenta;
    }

    public Long getIdPolaganja() {
        return idPolaganja;
    }

    public void setIdPolaganja(Long idPolaganja) {
        this.idPolaganja = idPolaganja;
    }

    public String getImeStudenta() {
        return imeStudenta;
    }

    public void setImeStudenta(String imeStudenta) {
        this.imeStudenta = imeStudenta;
    }

    public String getPrezimeStudenta() {
        return prezimeStudenta;
    }

    public void setPrezimeStudenta(String prezimeStudenta) {
        this.prezimeStudenta = prezimeStudenta;
    }

    public String getBrojIndeksa() {
        return brojIndeksa;
    }

    public void setBrojIndeksa(String brojIndeksa) {
        this.brojIndeksa = brojIndeksa;
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
