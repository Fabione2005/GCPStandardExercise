package com.standard.gcp.security.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import com.standard.gcp.model.generic.BaseResult;
import com.standard.gcp.security.dao.UserJWTJpaSpring;
import com.standard.gcp.security.model.UserJWT;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class UserJWTServiceImpl implements UserJWTService{
	
	Logger logger = LoggerFactory.getLogger(UserJWTServiceImpl.class);
	
	@Autowired
	UserJWTJpaSpring daoUser;

	@Override
	public ResponseEntity<?> addDefaultAdminUsers() {
		
		logger.trace("Adding default Admin users to the db");
		List<UserJWT> tempUsers = new ArrayList<>();
		
		tempUsers.add(new UserJWT("userAdmin0542","cisco43234"));
		tempUsers.add(new UserJWT("userAdmin0543","cisco43235"));
		tempUsers.add(new UserJWT("userAdmin0544","cisco43236"));
		
		daoUser.saveAll(tempUsers);
		
		logger.info("Admin users added successfully");
		return ResponseEntity.status(HttpStatus.OK).build();
	}

	@Override
	public ResponseEntity<?> loginAuth(UserJWT user) {
		
		logger.trace("Getting token for Admin user "+user.toString());
		
		UserJWT userFound = daoUser.findByUserName(user.getUserName());
		
		if(userFound != null) 
		{
			logger.info("User finded");
			
			String tokenResult = userFound.getPassoword().equals(user.getPassoword()) ? 
					this.getJWTToken(user.getUserName()) : null;

					
			if(tokenResult != null) 
			{
				logger.info("Auth successful");
				return ResponseEntity.status(HttpStatus.OK).body(new UserJWT(user.getUserName(),null,tokenResult));
			}
			else
			{
				String message = "The password is wrong";
				logger.error(message);
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new BaseResult(message));
			}
					
		}
		String message = "The user was not found in the system";
		logger.error(message);
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new BaseResult(message));
	}

	private String getJWTToken(String username) {
		
		logger.trace("Generating token for the user "+username);
		
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils
				.commaSeparatedStringToAuthorityList("ROLE_USER");
		
		String token = Jwts
				.builder()
				.setId("fabioneJWT")
				.setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream()
								.map(GrantedAuthority::getAuthority)
								.collect(Collectors.toList()))
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512,
						secretKey.getBytes()).compact();

		logger.trace("Token created");
		return "Bearer " + token;
	}
}
