package testTeretana.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import testTeretana.dao.TrenerDao;
import testTeretana.domain.Trener;
import testTeretana.service.TrenerService;

@Service
public class TrenerServiceImpl implements TrenerService{

	@Autowired
	private TrenerDao trenerDao;
//**** Find All Trener ****//	
	@Override
	public List<Trener> findAll() {
		return (List<Trener>) trenerDao.findAll();
	}
//**** End Find All Trener ****//
	
}
