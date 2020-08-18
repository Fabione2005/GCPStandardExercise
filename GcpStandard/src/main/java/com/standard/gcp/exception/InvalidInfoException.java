package com.standard.gcp.exception;

import org.springframework.http.HttpStatus;

public class InvalidInfoException extends GenericException implements BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidInfoException(String message) {
        super(message,HttpStatus.BAD_REQUEST);
    }

}
