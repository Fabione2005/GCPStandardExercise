package com.standard.gcp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;

import com.standard.gcp.model.entities.Student;
import com.standard.gcp.model.generic.BaseResult;

@Repository
public interface StudentService {
	Student retrieveStudentById(UUID id);
	List<Student> retrieveStudentByName(String name);
	List<Student> retrieveStudentByLastName(String lastName);
	List<Student> retrieveStudentByRut(String rut);
	List<Student> retrieveStudentByAge(int age);
	ResponseEntity<BaseResult> updateStudent(Student student);
	ResponseEntity<BaseResult> deleteStudent(UUID id);
	ResponseEntity<BaseResult> addStudent(Student student);
}
