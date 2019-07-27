package testTeretana.service;

import testTeretana.domain.Operater;

public interface TokenService {
	
//**** Get Operater From Token ****//
	public Operater getOperaterFromToken (String token);
//**** End Get Operater From Token ****//

//**** Get Token From Operater ****//	
	public String getTokenFromOperater (Operater operater);
//**** End Get Token From Operater ****//	
	
}
