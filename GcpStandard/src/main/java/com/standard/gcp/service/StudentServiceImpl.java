package com.standard.gcp.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.standard.gcp.dao.StudentRepository;
import com.standard.gcp.exception.StudentGenericException;
import com.standard.gcp.model.entities.Student;
import com.standard.gcp.model.generic.BaseResult;

public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository dao;

	@Autowired
	private BusinessService businessValidator;

	@Override
	public Student retrieveStudentById(UUID id) {

		Student studentFound = dao.findById(id).get();

		businessValidator.foundStudentValidation(studentFound, false);

		return studentFound;
	}

	@Override
	public List<Student> retrieveStudentByName(String name) throws StudentGenericException {

		List<Student> studentsFound = dao.findByName(name).get();

		businessValidator.foundStudentValidation(studentsFound);

		return studentsFound;
	}

	@Override
	public List<Student> retrieveStudentByLastName(String lastName) {

		List<Student> studentsFound = dao.findByLastName(lastName).get();

		businessValidator.foundStudentValidation(studentsFound);

		return studentsFound;
	}

	@Override
	public List<Student> retrieveStudentByRut(String rut) {

		List<Student> studentsFound = dao.findByRut(rut).get();

		businessValidator.foundStudentValidation(studentsFound);

		return studentsFound;
	}

	@Override
	public List<Student> retrieveStudentByAge(int age) {

		List<Student> studentsFound = dao.findByAge(age).get();

		businessValidator.foundStudentValidation(studentsFound);

		return studentsFound;
	}

	@Override
	public ResponseEntity<BaseResult> updateStudent(Student student) {

		Student studentFound = dao.findById(student.getId()).get();

		businessValidator.foundStudentValidation(studentFound, false);

		dao.save(student);

		return ResponseEntity.status(HttpStatus.OK).body(new BaseResult());
	}

	@Override
	public ResponseEntity<BaseResult> deleteStudent(UUID id) {

		Student studentFound = dao.findById(id).get();

		businessValidator.foundStudentValidation(studentFound, false);
		
		dao.delete(studentFound);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new BaseResult());
	}

	@Override
	public ResponseEntity<BaseResult> addStudent(Student student) {
		List<Student> studentsFound = dao.findByRut(student.getRut()).get();

		businessValidator.foundStudentValidation(studentsFound.stream().findFirst().get(),true);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResult());
	}

}
