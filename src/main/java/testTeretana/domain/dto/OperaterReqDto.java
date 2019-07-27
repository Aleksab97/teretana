package testTeretana.domain.dto;

import javax.validation.constraints.Email;

import org.hibernate.validator.constraints.Length;

public class OperaterReqDto {
	
	private String ime;
	
	private String prezime;
	
	@Email(message = "Nije validan oblik email adrese!")
	private String email;
	
	@Length(min = 4, max = 16, message = "Duzina mora biti izmedju 4 i 16 karaktera")
	private String password;

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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	

}
