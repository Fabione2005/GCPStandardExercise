package com.standard.gcp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.standard.gcp.security.model.UserJWT;
import com.standard.gcp.security.service.UserJWTService;

@RestController
public class AuthController 
{
	
	@Autowired
	UserJWTService service;
	
	@GetMapping(value = "/token",consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> login(@RequestBody UserJWT user) {
		return service.loginAuth(user);
	}
}
