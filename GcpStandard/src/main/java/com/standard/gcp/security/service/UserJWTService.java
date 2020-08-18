package com.standard.gcp.security.service;

import org.springframework.http.ResponseEntity;

import com.standard.gcp.security.model.UserJWT;

public interface UserJWTService {
	ResponseEntity<?> addDefaultAdminUsers();
	ResponseEntity<?> loginAuth(UserJWT user);
}
