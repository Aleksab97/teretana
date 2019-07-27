package testTeretana.domain;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "termin")
public class Termin {
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private Date terminPocetka;
	private Date terminZavrsetka;
	
	@ManyToOne()
	@JoinColumn(name="clan_id")
	private Clan clan;
	
	@ManyToOne()
	@JoinColumn(name="operater_id")
	private Operater operater;
	
	@ManyToOne()
	@JoinColumn(name="trener_id")
	private Trener trener;
	
	@ManyToOne()
	@JoinColumn(name="teretana_id")
	private Teretana teretana;

	
	public Trener getTrener() {
		return trener;
	}
	public void setTrener(Trener trener) {
		this.trener = trener;
	}
	public Teretana getTeretana() {
		return teretana;
	}
	public void setTeretana(Teretana teretana) {
		this.teretana = teretana;
	}
	public Clan getClan() {
		return clan;
	}
	public void setClan(Clan clan) {
		this.clan = clan;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getTerminPocetka() {
		return terminPocetka;
	}
	public void setTerminPocetka(Date terminPocetka) {
		this.terminPocetka = terminPocetka;
	}
	public Date getTerminZavrsetka() {
		return terminZavrsetka;
	}
	public void setTerminZavrsetka(Date terminZavrsetka) {
		this.terminZavrsetka = terminZavrsetka;
	}
	public Operater getOperater() {
		return operater;
	}
	public void setOperater(Operater operater) {
		this.operater = operater;
	}
	
	

}
