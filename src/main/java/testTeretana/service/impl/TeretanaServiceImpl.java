package testTeretana.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import testTeretana.dao.TeretanaDao;
import testTeretana.domain.Teretana;
import testTeretana.service.TeretanaService;

@Service
public class TeretanaServiceImpl implements TeretanaService{
	
	@Autowired
	private TeretanaDao teretanaDao;
//**** Find All Users ****//
	@Override
	public List<Teretana> findAll() {
		return (List<Teretana>) teretanaDao.findAll();
	}
//**** End Find All Users ****//
	
	
//**** Save User ****//		
	public Boolean save(Teretana teretana) {
		Teretana newTeretana = teretana;
		teretanaDao.save(newTeretana);
		return true;
	}
//**** End Save User ****//		

	
//**** Delete User ****//		
	@Override
	public Boolean delete(Long id) {
		teretanaDao.deleteById(id);
		return true;
	}
//**** End Delete User ****//		

	
//**** FindByIme ****//
	@Override
	public List<Teretana> findByIme(String ime) {
		return teretanaDao.findByIme(ime);
	}
//**** End FindByIme ****//



}
