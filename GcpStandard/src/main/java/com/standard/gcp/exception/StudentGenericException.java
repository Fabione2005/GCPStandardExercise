package com.standard.gcp.exception;

import org.springframework.http.HttpStatus;

public class StudentGenericException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	private String message;
	private HttpStatus status;

	public StudentGenericException(String message,HttpStatus status) {
	        super(message);
	        this.message = message;
	        this.status = status;
	    }

	@Override
	public String getMessage() {
		return message;
	}
	
	public HttpStatus getStatus() 
	{
		return status;
	}

}
