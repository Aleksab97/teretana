package testTeretana.service;

import java.util.List;
import testTeretana.domain.Teretana;

public interface TeretanaService {
//**** Find All Users ****//
	List<Teretana> findAll();
//**** End Find All Users ****//	

//**** Delete User ****//	
	Boolean delete(Long id);
//**** End Delete User ****//	

//**** FindByIme ****//
	List<Teretana> findByIme(String ime);
//**** End FindByIme ****//
	
	
}
