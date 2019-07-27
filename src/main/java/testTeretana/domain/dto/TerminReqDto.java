package testTeretana.domain.dto;

import java.sql.Date;

public class TerminReqDto {

	private Long id;
	
	private Date terminPocetka;
	private Date terminZavrsetka;
	private Long trener_id;
	private Long clan_id;
	private Long teretana_id;
	
	
	public Long getTeretana_id() {
		return teretana_id;
	}
	public void setTeretana_id(Long teretana_id) {
		this.teretana_id = teretana_id;
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
	public Long getTrener_id() {
		return trener_id;
	}
	public void setTrener_id(Long trener_id) {
		this.trener_id = trener_id;
	}
	public Long getClan_id() {
		return clan_id;
	}
	public void setClan_id(Long clan_id) {
		this.clan_id = clan_id;
	}
	
	
	
}
