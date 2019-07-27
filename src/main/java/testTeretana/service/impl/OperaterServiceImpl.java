package testTeretana.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import testTeretana.dao.OperaterDao;
import testTeretana.domain.Operater;
import testTeretana.domain.dto.LoginReqDto;
import testTeretana.domain.dto.LoginResDto;
import testTeretana.domain.dto.OperaterResDto;
import testTeretana.service.OperaterService;
import testTeretana.service.TokenService;

@Service
public class OperaterServiceImpl implements OperaterService {
	
	@Autowired
	private OperaterDao operaterDao;
	@Autowired
	private TokenService tokenService;
	
//**** Find All Operater ****//	
	@Override
	public List<OperaterResDto> findAll() {	
		List<Operater> li = operaterDao.findAll();
		List<OperaterResDto> result = new ArrayList<>();
		for (Operater operater : li) {
			result.add(new OperaterResDto(operater));
		}	
		return result;
	}
//**** End Find All Operater ****//

//**** Save Operater ****//
	@Override
	public Boolean save(OperaterResDto operaterResDto) {
		
		Operater operater = new Operater();
		operater.setIme(operaterResDto.getIme());
		operater.setEmail(operaterResDto.getEmail());
		operater.setPrezime(operaterResDto.getPrezime());
		operaterDao.save(operater);
		
		return true;
	}
//**** End Save Operater ****//	

//**** FindByEmail ****//
	@Override
	public Operater findByEmail(String email) {
		return operaterDao.findByEmail(email);
	}
//**** End FindByEmail ****//

//**** logIn ****//
	@Override
	public LoginResDto logIn(LoginReqDto loginReqDto) {
		
		Operater operater = operaterDao.findByEmail(loginReqDto.getEmail());
		String token = tokenService.getTokenFromOperater(operater);
		LoginResDto response = new LoginResDto();
		response.setIme(operater.getIme());
		response.setToken(token);
		response.setPrezime(operater.getPrezime());
		return response;
	}
//**** End logIn ****//	
	
	
}
