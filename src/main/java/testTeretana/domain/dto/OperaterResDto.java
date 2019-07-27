package testTeretana.domain.dto;

import testTeretana.domain.Operater;

public class OperaterResDto {

	public String Ime;
	public String email;
	public String prezime;
	
	public OperaterResDto() {
		super();
	}

	public OperaterResDto(Operater operater) {
		this.Ime = operater.getIme();
		this.email = operater.getEmail();
	}

	public String getIme() {
		return Ime;
	}

	public void setIme(String ime) {
		Ime = ime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	
	@Override
	public String toString() {
		return Ime + " - "  + email;
	}
	
	
}
