package testTeretana.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import testTeretana.domain.Operater;
import testTeretana.domain.dto.LoginReqDto;
import testTeretana.domain.dto.LoginResDto;
import testTeretana.domain.dto.OperaterResDto;
import testTeretana.service.OperaterService;

@RestController
@RequestMapping(value = "/operater")
public class OperaterApi {

	@Autowired
	private OperaterService operaterService;
	
//**** Find All Operater ****//
	@RequestMapping(value="/findAll", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody  List<OperaterResDto> findAll(){
		return operaterService.findAll();
	}
//**** End Find All Operater ****//
	
	
//**** Add Operater ****//
	@RequestMapping(value="/save", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public Boolean save(@RequestBody OperaterResDto operaterResDto) {
		return operaterService.save(operaterResDto);
	}
//**** End Add Operater ****//
	
//**** FindByEmail ****//
	@RequestMapping(value="/findByEmail", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Operater findByEmail(String email) {
		return operaterService.findByEmail(email);
	}
//**** End FindByEmail ****//	
	
//**** LogIn ****//	
	@RequestMapping(value="/login", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public LoginResDto logIn(@RequestBody LoginReqDto loginReqDto) {
		return operaterService.logIn(loginReqDto);
	}
//**** End LogIn ****//
}
