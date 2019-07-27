package testTeretana.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import testTeretana.domain.dto.LoginReqDto;
import testTeretana.domain.dto.LoginResDto;
import testTeretana.service.OperaterService;

@RestController
@RequestMapping(path = "/auth")
public class AuthApi {
	
	@Autowired
	private OperaterService operaterService;

	//**** LogIn ****//	
		@RequestMapping(value="/login", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
		public LoginResDto logIn(@RequestBody LoginReqDto loginReqDto) {
			return operaterService.logIn(loginReqDto);
		}
	//**** End LogIn ****//
	
}
