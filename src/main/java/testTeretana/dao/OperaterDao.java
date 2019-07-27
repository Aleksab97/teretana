package testTeretana.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import testTeretana.domain.Operater;


public interface OperaterDao extends JpaRepository<Operater, Long> {

	public Operater findByEmail(String email);
	
}
