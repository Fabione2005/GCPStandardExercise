package com.standard.gcp.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.standard.gcp.exception.InvalidFormatException;
import com.standard.gcp.exception.StudentGenericException;
import com.standard.gcp.exception.StudentNotFoundException;
import com.standard.gcp.model.entities.Student;
import com.standard.gcp.utils.Validator;

@Service
public class BusinessServiceImpl implements BusinessService{

	@Override
	public void foundStudentValidation(List<Student> foundStudents) {
		
		if(foundStudents.isEmpty()) 
		{
			throw new StudentNotFoundException();
		}
	}
	
	@Override
	public void foundStudentValidation(Student foundStudents, boolean isNewStudent) {
		
		if(foundStudents == null && !isNewStudent) 
		{
			throw new StudentNotFoundException();
		}
		else if(foundStudents != null && isNewStudent)
		{
			throw new StudentGenericException("Student is already registered",HttpStatus.CONFLICT);
		}
		
		
	}

	@Override
	public void rutValidation(String rut) {
		
		if(!Validator.rutValidator(rut)) 
		{
			throw new InvalidFormatException();
		}
	}

}
