package testTeretana.domain;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "trener")
public class Trener {

	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String ime;
	private String prezime;
	private Long cena;
	
	
	@ManyToMany(fetch = FetchType.EAGER,
            cascade = {
                CascadeType.PERSIST,
                CascadeType.MERGE
       		})
    @JoinTable(name = "trener_teretana",
     joinColumns = @JoinColumn(name = "teretana_id"),
     inverseJoinColumns = @JoinColumn(name = "trener_id")
    )

	private List<Teretana> teretana;
	
	@OneToMany(mappedBy="trener")
	private List<Termin> termini;
	
	@JsonIgnore
	public List<Termin> getTermini() {
		return termini;
	}
	public void setTermini(List<Termin> termini) {
		this.termini = termini;
	}
	
	

	public List<Teretana> getTeretana() {
		return teretana;
	}

	public void setTeretana(List<Teretana> teretana) {
		this.teretana = teretana;
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

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public Long getCena() {
		return cena;
	}

	public void setCena(Long cena) {
		this.cena = cena;
	}

}
