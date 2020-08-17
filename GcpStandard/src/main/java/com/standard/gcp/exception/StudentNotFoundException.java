package com.standard.gcp.exception;

import org.springframework.http.HttpStatus;

public class StudentNotFoundException extends StudentGenericException implements BusinessException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1189460730196188968L;

	public StudentNotFoundException() {
		super("student not found", HttpStatus.NOT_FOUND);
	}

}
