package testTeretana.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.jsondoc.core.annotation.ApiObject;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "clan")
@ApiObject
public class Clan {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String ime;
	private String prezime;
	private String email;
	private String pretplata;
	
	
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="teretana_id")
	private Teretana teretana;
	
	
	@OneToMany(mappedBy="clan", fetch = FetchType.EAGER)
	private List<Termin> termini;
	
	@JsonIgnore
	public List<Termin> getTermini() {
		return termini;
	}

	public void setTermini(List<Termin> termini) {
		this.termini = termini;
	}

	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getPretplata() {
		return pretplata;
	}

	public void setPretplata(String pretplata) {
		this.pretplata = pretplata;
	}

	public Teretana getTeretana() {
		return teretana;
	}
	
	public void setTeretana(Teretana teretana) {
		this.teretana = teretana;
	}
	
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
	
	
	
}
