package com.standard.gcp.security.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class UserJWT {

	@Id
	@GeneratedValue(generator = "uuid")
	private UUID id;
	
	@Column(name = "username")
	private String userName;
	@Column(name = "password")
	private String password;
	private String token;
	
	public UserJWT(String userName, String password, String token) {
		super();
		this.userName = userName;
		this.password = password;
		this.token = token;
	}
	
	public UserJWT(String user, String password) {
		super();
		this.userName = user;
		this.password = password;
	}
	
	public UserJWT() {
		super();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String user) {
		this.userName = user;
	}

	public String getPassoword() {
		return password;
	}

	public void setPassword(String pwd) {
		this.password = pwd;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Override
	public String toString() {
		return "UserJWT [id=" + id + ", userName=" + userName + ", token=" + token + "]";
	}
	
}
