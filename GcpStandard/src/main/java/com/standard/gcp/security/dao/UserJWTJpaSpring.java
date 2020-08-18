package com.standard.gcp.security.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.standard.gcp.security.model.UserJWT;

@Repository
public interface UserJWTJpaSpring extends JpaRepository<UserJWT, Long>{
	UserJWT findByUserName(String userName);
}
