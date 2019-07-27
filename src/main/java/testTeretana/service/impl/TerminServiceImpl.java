package testTeretana.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testTeretana.dao.ClanDao;
import testTeretana.dao.TeretanaDao;
import testTeretana.dao.TerminDao;
import testTeretana.dao.TrenerDao;
import testTeretana.domain.Clan;
import testTeretana.domain.Operater;
import testTeretana.domain.Teretana;
import testTeretana.domain.Termin;
import testTeretana.domain.Trener;
import testTeretana.domain.dto.TerminReqDto;
import testTeretana.service.TerminService;

@Service
public class TerminServiceImpl implements TerminService {
	
	@Autowired
	private TerminDao terminDao;
	@Autowired
	private ClanDao clanDao;
	@Autowired
	private TrenerDao trenerDao;
	@Autowired
	private TeretanaDao teretanaDao;
	
	//**** Find All Termins ****//	
		public List<Termin> findAll() {
			return (List<Termin>) terminDao.findAll();
		}
	//**** End Find All Termins ****//

	//**** FindById ****//
		public Optional<Termin> findById(Long id) {
			return terminDao.findById(id);
		}
	//**** End FindById ****//

	//**** Save Termin ****//	
		@Override
		public Boolean saveTermin(TerminReqDto terminReqDto,Operater operater) {	
		Termin termin = new Termin();
		termin.setTerminPocetka(terminReqDto.getTerminPocetka());
		termin.setTerminZavrsetka(terminReqDto.getTerminZavrsetka());
		termin.setOperater(operater);
	//--- Clan Id ---//	
		Optional<Clan> opClan = clanDao.findById(terminReqDto.getClan_id());
		if (opClan.isPresent()) {
			Clan clan = opClan.get();
			termin.setClan(clan);
		} else {
			return false;
		}
	//--- End Clan Id ---//
		
	//--- Trener Id ---//
		if (terminReqDto.getTrener_id() != null) {

			Optional<Trener> opTrener = trenerDao.findById(terminReqDto.getTrener_id());
			if (!opTrener.isPresent()) {
				return false;
			}
			termin.setTrener(opTrener.get());
		}
	//--- End Trener Id ---//
		
	//--- Teretana Id ---//	
		Optional<Teretana> opTeretana = teretanaDao.findById(terminReqDto.getTeretana_id());
		if(opTeretana.isPresent()) {
			Teretana teretana = opTeretana.get();
			termin.setTeretana(teretana);
		} else {
			return false;
		}
	//--- End Teretana Id ---//	
		
		terminDao.save(termin);
		return true;
		}
	//**** End Save Termin ****//

	//**** Delete Termin ****//	
		@Override
		public Boolean delete(Long id) {
			terminDao.deleteById(id);;
			return true;
		}
	//**** End Delete Termin ****//
		
}
