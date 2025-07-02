package rs.ac.singidunum.novisad.backend.model;

import java.time.LocalDateTime;
import java.util.Date;

import jakarta.persistence.*;
import rs.ac.singidunum.novisad.backend.model.academic.Predmet;

@Entity
public class PredmetnaObavestenja extends Obavestenje{

    @ManyToOne
    @JoinColumn(name = "predmet_id")
    private Predmet predmet;

    public PredmetnaObavestenja() {
		super();
	}
	

	public PredmetnaObavestenja(Long id, LocalDateTime datum, String sadrzaj, String naslov, String slika,
			Date vremePocetka, Date vremeKraja, Predmet predmet) {
		super(id,  sadrzaj, naslov, datum, slika, vremePocetka, vremeKraja);
		this.predmet = predmet;
	}


	public PredmetnaObavestenja(Predmet predmet) {
		super();
		this.predmet = predmet;
	}

	public Predmet getPredmet() {
		return predmet;
	}

	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
    
}
