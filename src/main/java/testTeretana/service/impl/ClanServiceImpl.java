package testTeretana.service.impl;

import java.util.List;
import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.querydsl.core.types.Predicate;

import testTeretana.dao.ClanDao;
import testTeretana.dao.TeretanaDao;
import testTeretana.domain.Clan;
import testTeretana.domain.Teretana;
import testTeretana.domain.dto.ClanReqDto;
import testTeretana.service.ClanService;
import testTeretana.service.JavaMailService;

@Service
public class ClanServiceImpl implements ClanService{
	
	@Autowired
	private ClanDao clanDao;
	
	@Autowired
	private TeretanaDao teretanaDao;
	
	@Autowired
	private JavaMailService javaMailServic;
	
	
	
//**** Find All Users ****//
	public Page<Clan> findAll( Predicate predicate, Pageable pageable) {
		return clanDao.findAll(pageable);
	}
//**** End Find All Users ****//
	
//**** Save User ****//	
	public Boolean saveUser(ClanReqDto clanReqDto) {
		Clan clan = new Clan();
		clan.setIme(clanReqDto.getIme());
		clan.setPrezime(clanReqDto.getPrezime());
		clan.setEmail(clanReqDto.getEmail());
		clan.setPretplata(clanReqDto.getPretplata());
		Optional<Teretana> optionalTeretana = teretanaDao.findById(clanReqDto.getTeretanaId());
		if(!optionalTeretana.isPresent()) {
			return false;
		}
		clan.setTeretana(optionalTeretana.get());
		
		
		//javaMailServic.sendMessage(clan);
		
		//Email with attachments//	
		try {
			javaMailServic.sendMessageWithAttachment("bajricaleksa4@gmail.com", "proba", "bla-bla", "/home/aleksa/Documents/workspace-spring-tool-suite-4-4.1.1.RELEASE/teretana-master.git/teretana-master/src/main/java/testTeretana/img/test.jpg");
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		//End Email with attachments//	
		
		
		try {
			javaMailServic.sendEmailToUsers(clan);
		} catch (MessagingException e) {
			
			e.printStackTrace();
		}
		
		clanDao.save(clan);
			return true;
	}
//**** End Save User ****//	

//**** Delete User ****//	
	@Override
	public Boolean deleteUser(Long id)  {
		clanDao.deleteById(id);
		return true;
	}
//**** End Delete User ****//

//**** Update User ****//
	@Override
	public Boolean updateUser(Clan clan) {
		Optional <Clan> optinalClan = clanDao.findById(clan.getId());
		if(!optinalClan.isPresent()) {
			return false;
		}
		Clan newClan = optinalClan.get();
		newClan.setIme(clan.getIme());
		newClan.setPrezime(clan.getPrezime());
		newClan.setEmail(clan.getEmail());
		clanDao.save(newClan);
		return true;
		
	}
//**** End Update User ****//

	@Override
	public List<Clan> findAllUser() {
		return clanDao.findAll();
	}
	
}
