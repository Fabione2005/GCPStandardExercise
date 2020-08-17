package com.standard.gcp.exception;

import org.springframework.http.HttpStatus;

public class InvalidFormatException extends StudentGenericException implements BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidFormatException() {
	        super("Invalid rut format",HttpStatus.BAD_REQUEST);
	    }

}
