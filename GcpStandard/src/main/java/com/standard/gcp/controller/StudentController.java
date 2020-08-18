package com.standard.gcp.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.standard.gcp.model.entities.Student;
import com.standard.gcp.model.generic.BaseResult;
import com.standard.gcp.service.generic.InfoCheckService;
import com.standard.gcp.service.student.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService service;
	
	@Autowired
	InfoCheckService checkService;

	@GetMapping(value = "/students", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Student> retrieveStudentsService() {
		return service.retrieveAllStudent();
	}
	
	@GetMapping(value = "/students/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Student retrieveStudentByIdService(@PathVariable UUID id) {
		return service.retrieveStudentById(id);
	}
	
	@PostMapping(value = "/students/add",consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResult> createStudentService(@RequestBody Student student) 
	{
		return checkService.getStudentService(student).addStudent(student);
	}
	
	@PutMapping(value = "/students/update",consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResult> updateStudentService(@RequestBody Student student) 
	{
		return checkService.getStudentService(student).updateStudent(student);
	}
	
	@DeleteMapping(value="/students/delete/{id}")
	public ResponseEntity<BaseResult> deleteStock(@PathVariable UUID id) {
		return service.deleteStudent(id);
	}
	
}
