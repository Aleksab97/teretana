package testTeretana.domain;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="teretana")
public class Teretana {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String ime;
	private Long cena;
	
	@ManyToMany(mappedBy = "teretana")
	private List<Trener> trener;
	
	@OneToMany(mappedBy="teretana", fetch = FetchType.EAGER)
	private List<Clan> clanovi;

	@JsonIgnore
	public List<Clan> getClanovi() {
		return clanovi;
	}
	public void setClanovi(List<Clan> clanovi) {
		this.clanovi = clanovi;
	}
	
	@OneToMany(mappedBy="teretana")
	private List<Termin> termini;
	
	@JsonIgnore
	public List<Termin> getTermini(){
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
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public Long getCena() {
		return cena;
	}
	public void setCena(Long cena) {
		this.cena = cena;
	}
	
	
	
	
	
}
