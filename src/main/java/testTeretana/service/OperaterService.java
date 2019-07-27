package testTeretana.service;

import java.util.List;

import testTeretana.domain.Operater;
import testTeretana.domain.dto.LoginReqDto;
import testTeretana.domain.dto.LoginResDto;
import testTeretana.domain.dto.OperaterResDto;

public interface OperaterService {
//**** Find All Operaters ****//
	List<OperaterResDto> findAll();
//**** End Find All Operaters ****//

//**** Save Operater ****//	
	Boolean save(OperaterResDto operaterResDto);
//**** End Save Operater ****//

//**** FindByEmail ****//
	Operater findByEmail(String email);
//**** End FindByEmail ****//	

//**** logIn ****//
	LoginResDto logIn(LoginReqDto loginReqDto);
//**** End logIn ****//	
	
}
