package com.standard.gcp.service.generic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.standard.gcp.model.entities.Student;
import com.standard.gcp.service.student.StudentService;

@Service
public class InfoCheckServiceImpl implements InfoCheckService{

	@Autowired
	private StudentService studentService;
	
	@Autowired
	private BusinessService businessValidator;
	
	@Override
	public StudentService getStudentService(Student student) {
		
		businessValidator.rutValidation(student.getRut());
		
		return studentService;
	}

}
