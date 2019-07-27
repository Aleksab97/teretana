package testTeretana.dao;

import org.springframework.data.repository.CrudRepository;
import testTeretana.domain.Termin;

public interface TerminDao extends CrudRepository <Termin, Long> {

}
