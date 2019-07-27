package testTeretana.api;

import java.util.List;
import org.jsondoc.core.annotation.Api;
import org.jsondoc.core.annotation.ApiMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.querydsl.binding.QuerydslPredicate;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.querydsl.core.types.Predicate;
import testTeretana.dao.ClanDao;
import testTeretana.domain.Clan;
import testTeretana.domain.dto.ClanReqDto;
import testTeretana.service.ClanService;

@RestController
@RequestMapping(value="/clan")
@Api(description = "just example", name = "Clan api")
public class ClanApi {
	@Autowired
	private ClanService clanService;
	
//**** Find All Clan ****//
	@RequestMapping(value="/findAll", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiMethod(description="Find All Users from database with pageable ")
	public @ResponseBody Page<Clan> findAll( @QuerydslPredicate(root = Clan.class, bindings = ClanDao.class) Predicate predicate,Pageable pageable){
		return clanService.findAll( predicate, pageable);
	}
//**** End Find All Clan ****//
	
	
//**** Save User ****//	
	@RequestMapping(value="/save", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
//	@PostMapping(path = "/save")
	public @ResponseBody Boolean save ( @Validated @RequestBody ClanReqDto clanReqDto) {
		return clanService.saveUser(clanReqDto);
	}
//**** End Save User ****//
	
	
//**** Delete User ****//
	@RequestMapping(value="/delete", method=RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean delete(@RequestParam Long id) {
		return clanService.deleteUser(id);
	}
//**** End Delete User ****//
	
	
//**** Update User ****//
	@RequestMapping(value="/update", method=RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Boolean update(@RequestBody Clan clan) {
		return clanService.updateUser(clan);
	}
//**** End Update User ****//
	
	
	
	
	@RequestMapping(value="/findAllUser",method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiMethod(description="Find all users from the database")
	public @ResponseBody List<Clan> findAllUser(){
		return clanService.findAllUser();
	}
}
