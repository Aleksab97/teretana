package testTeretana.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import testTeretana.domain.Trener;
import testTeretana.service.TrenerService;

@RestController
@RequestMapping(value="/trener")
public class TrenerApi {

	@Autowired
	private TrenerService trenerService;
	
//**** Find All Trener ****//
	@RequestMapping(value="/findAll", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Trener>findAll(){
		return trenerService.findAll();
	}
//**** End Find All Trener ****//
}
