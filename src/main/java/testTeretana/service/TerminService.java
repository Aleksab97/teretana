package testTeretana.service;

import java.util.List;
import java.util.Optional;

import testTeretana.domain.Operater;
import testTeretana.domain.Termin;
import testTeretana.domain.dto.TerminReqDto;

public interface TerminService {
	
	//**** Find All Termins ****//
		List<Termin>findAll();
	//**** End Find All Termins ****//

	//**** FindById ****//	
		Optional<Termin> findById(Long id);
	//**** End FindById ****//

	//**** Save Termin ****//	
		Boolean saveTermin(TerminReqDto terminReqDto,Operater operater);
	//**** End Save Termin ****//		

	//**** Delete Termin ****//	
		Boolean delete(Long id);
	//**** End Delete Termin ****//
}
