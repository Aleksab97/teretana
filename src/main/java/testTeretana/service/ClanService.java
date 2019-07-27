package testTeretana.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.querydsl.core.types.Predicate;

import testTeretana.domain.Clan;
import testTeretana.domain.dto.ClanReqDto;


public interface ClanService {
//**** Find All Users ****//
	Page<Clan> findAll(Predicate predicate, Pageable pageable);
//**** End Find All Users ****//

//**** Save User ****//
	Boolean saveUser(ClanReqDto clanReqDto);
//**** End Save User ****//	

//**** Delete User ****//	
	Boolean deleteUser(Long id) ;
//**** End Delete User ****//	

//**** Update User ****//
	Boolean updateUser(Clan clan);
//**** End Update User ****//	
	
	List<Clan> findAllUser();
}
