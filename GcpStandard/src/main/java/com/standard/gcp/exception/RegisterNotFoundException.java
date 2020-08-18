package com.standard.gcp.exception;

import org.springframework.http.HttpStatus;

public class RegisterNotFoundException extends GenericException implements BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1189460730196188968L;

	public RegisterNotFoundException() {
		super("register not found", HttpStatus.NOT_FOUND);
	}

}
