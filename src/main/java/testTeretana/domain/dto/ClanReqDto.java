package testTeretana.domain.dto;

import javax.validation.constraints.NotNull;

public class ClanReqDto {
	
	private String ime;
	
	private String prezime;
	
	@NotNull(message = "Svaki clan mora pripadati nekoj teretani!")
	private Long teretanaId;
	
	private String email;
	
	private String pretplata;

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Long getTeretanaId() {
		return teretanaId;
	}

	public void setTeretanaId(Long teretanaId) {
		this.teretanaId = teretanaId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPretplata() {
		return pretplata;
	}

	public void setPretplata(String pretplata) {
		this.pretplata = pretplata;
	}


}
