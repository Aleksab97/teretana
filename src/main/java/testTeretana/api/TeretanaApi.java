package testTeretana.api;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import testTeretana.domain.Teretana;
import testTeretana.service.TeretanaService;

@RestController
@RequestMapping(value="/teretana")
public class TeretanaApi {
	@Autowired
	private TeretanaService teretanaService;
	
//**** Find All  ****//
	@RequestMapping(value="/findAll", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Teretana>findAll(){
		return teretanaService.findAll();
	}
//**** End Find All ****//
	
//**** Find By Ime ****//	
	@RequestMapping(value="/findbyime",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Teretana> findByIme(String ime){
		return teretanaService.findByIme(ime);
	}
//**** End Find By Ime ****//
		
	
//**** Delete User ****//	
	@RequestMapping(value="/delete",method=RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean DeleteUser(@RequestParam Long id) {
		return teretanaService.delete(id);
	}
//**** End Delete User ****//
	

	
	

}
