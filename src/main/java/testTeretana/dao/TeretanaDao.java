package testTeretana.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import testTeretana.domain.Teretana;


public interface TeretanaDao extends CrudRepository<Teretana, Long> {

	public List<Teretana> findByIme(String ime);
	
	

}
