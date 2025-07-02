package rs.ac.singidunum.novisad.backend.dto;

public class GodinaStudijaDTO {

	private Long id;
	
	private int godina;

	public GodinaStudijaDTO(Long id, int godina) {
		super();
		this.id = id;
		this.godina = godina;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getGodina() {
		return godina;
	}

	public void setGodina(int godina) {
		this.godina = godina;
	}
	
	
}
