package testTeretana.api;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import testTeretana.domain.Operater;
import testTeretana.domain.Termin;
import testTeretana.domain.dto.TerminReqDto;
import testTeretana.service.TerminService;


@RestController
@RequestMapping(value="/termin")
public class TerminApi {
	@Autowired
	private TerminService terminService;
	
//**** Find All Termins ****//	
	@RequestMapping(value="/findAll", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Termin>findAll(){
		return terminService.findAll();
	}	
//**** End Find All Termins ****//	
	
//**** FindById ****//
	@RequestMapping(value="/findbyid", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Optional<Termin>findById(Long id){
		return terminService.findById(id);
	}
//**** End FindById ****//
	
//**** Save Termin ****//
	@RequestMapping(value="/save", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean save(@RequestBody TerminReqDto terminReqDto, HttpServletRequest httpServletRequest){
		Operater operater = (Operater) httpServletRequest.getAttribute("OPERATER");
		return terminService.saveTermin(terminReqDto,operater);
	}
//**** End Save Termin ****//
	
//**** Delete Termin ****//
	@RequestMapping(value="/delete", method=RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean delete(@RequestParam Long id) {
		return terminService.delete(id);
	}
//**** End Delete Termin ****//	
}
