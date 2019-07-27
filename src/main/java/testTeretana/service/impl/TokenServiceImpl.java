package testTeretana.service.impl;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import testTeretana.dao.OperaterDao;
import testTeretana.domain.Operater;
import testTeretana.service.TokenService;

@Service
public class TokenServiceImpl implements TokenService {
	
	@Autowired
	private OperaterDao operaterDao;

	public static final String KEY="nebitno";
	
	private static final Logger	logger = LoggerFactory.getLogger(TokenServiceImpl.class);
	
	@Override
	public Operater getOperaterFromToken(String token) {
		 String email = Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody().getSubject();
		 
	        logger.info("Email from token: {}", email);
	        
	        Operater operater = operaterDao.findByEmail(email);
	        return operater;
	        
	}

	@Override
	public String getTokenFromOperater(Operater operater) {
		
		String token = Jwts.builder().setSubject(operater.getEmail()).signWith(SignatureAlgorithm.HS512, KEY)
		.setExpiration(new Date(System.currentTimeMillis() + 3600000)).compact();
		
		logger.info("New token: {}", token);
		
		
		return token;
	}

	
}
