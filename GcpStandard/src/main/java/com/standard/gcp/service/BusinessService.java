package com.standard.gcp.service;

import java.util.List;

import com.standard.gcp.model.entities.Student;

public interface BusinessService {
	void foundStudentValidation(List<Student> foundStudents);
	void foundStudentValidation(Student foundStudents, boolean isNewStudent);
	void rutValidation(String rut);
}
