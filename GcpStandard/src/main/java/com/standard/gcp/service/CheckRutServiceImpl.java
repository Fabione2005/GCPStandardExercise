package com.standard.gcp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.standard.gcp.model.entities.Student;

public class CheckRutServiceImpl implements CheckRutService{

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private BusinessService businessValidator;
	
	@Override
	public StudentService getUserService(Student student) {
		
		businessValidator.rutValidation(student.getRut());
		
		return studentService;
	}

}
