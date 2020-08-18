package com.standard.gcp.service.generic;

import org.springframework.stereotype.Service;

import com.standard.gcp.exception.InvalidInfoException;
import com.standard.gcp.utils.Validator;

@Service
public class BusinessServiceImpl implements BusinessService{

	@Override
	public void rutValidation(String rut) {
		
		if(rut == null || !Validator.rutValidator(rut)) 
		{
			throw new InvalidInfoException("Rut Invalid");
		}
		
	}

}
