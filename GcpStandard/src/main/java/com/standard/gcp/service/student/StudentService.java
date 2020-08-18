package com.standard.gcp.service.student;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.standard.gcp.model.entities.Student;
import com.standard.gcp.model.generic.BaseResult;


public interface StudentService {
	Student retrieveStudentById(UUID id);
	List<Student> retrieveAllStudent();
	List<Student> retrieveStudentByName(String name);
	List<Student> retrieveStudentByLastName(String lastName);
	List<Student> retrieveStudentByRut(String rut);
	List<Student> retrieveStudentByAge(int age);
	ResponseEntity<BaseResult> updateStudent(Student student);
	ResponseEntity<BaseResult> deleteStudent(UUID id);
	ResponseEntity<BaseResult> addStudent(Student student);
	ResponseEntity<BaseResult> addDefaultStudents();
}
