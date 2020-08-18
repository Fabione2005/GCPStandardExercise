package com.gcp.standar.gcpstandar.business;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.standard.gcp.exception.InvalidInfoException;
import com.standard.gcp.service.generic.BusinessServiceImpl;

public class RutValidationTest {

	@Autowired
	private BusinessServiceImpl rutValidator;

	@Before()
	public void setUp() {
		rutValidator = new BusinessServiceImpl();
//        ReflectionTestUtils.setField(rutValidator, rutValidator);
	}

	@Test()
	public void shouldNotThrowException() {

		assertDoesNotThrow(() -> rutValidator.rutValidation("22887368-3"));
	}

	@Test
	public void shouldThrowException() {

		Assertions.assertThrows(InvalidInfoException.class, () -> rutValidator.rutValidation("22887368-3"));

	}
}
