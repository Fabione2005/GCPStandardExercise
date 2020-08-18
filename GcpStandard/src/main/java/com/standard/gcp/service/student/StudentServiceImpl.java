package com.standard.gcp.service.student;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.standard.gcp.dao.CourseRepository;
import com.standard.gcp.dao.StudentRepository;
import com.standard.gcp.exception.GenericException;
import com.standard.gcp.exception.InvalidInfoException;
import com.standard.gcp.exception.RegisterNotFoundException;
import com.standard.gcp.model.entities.Course;
import com.standard.gcp.model.entities.Student;
import com.standard.gcp.model.generic.BaseResult;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentRepository dao;
	
	@Autowired
	CourseRepository daoCourse;

	@Override
	public List<Student> retrieveAllStudent() {
		return dao.findAll();
	}

	@Override
	public Student retrieveStudentById(UUID id) {

		Student studentFound = dao.findById(id).orElseThrow(RegisterNotFoundException::new);

		return studentFound;
	}

	@Override
	public List<Student> retrieveStudentByName(String name) throws GenericException {

		List<Student> studentsFound = dao.findByName(name).orElseThrow(RegisterNotFoundException::new);

		return studentsFound;
	}

	@Override
	public List<Student> retrieveStudentByLastName(String lastName) {

		List<Student> studentsFound = dao.findByLastName(lastName).orElseThrow(RegisterNotFoundException::new);

		return studentsFound;
	}

	@Override
	public List<Student> retrieveStudentByRut(String rut) {

		List<Student> studentsFound = dao.findByRut(rut).orElseThrow(RegisterNotFoundException::new);

		return studentsFound;
	}

	@Override
	public List<Student> retrieveStudentByAge(int age) {

		List<Student> studentsFound = dao.findByAge(age).orElseThrow(RegisterNotFoundException::new);

		return studentsFound;
	}

	@Override
	public ResponseEntity<BaseResult> updateStudent(Student student) {

		dao.findById(student.getId()).orElseThrow(RegisterNotFoundException::new);
		
		dao.save(student);

		return ResponseEntity.status(HttpStatus.OK).body(new BaseResult());
	}

	@Override
	public ResponseEntity<BaseResult> deleteStudent(UUID id) {

		Student studentFound = dao.findById(id).orElseThrow(RegisterNotFoundException::new);

		dao.delete(studentFound);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new BaseResult());
	}

	@Override
	public ResponseEntity<BaseResult> addStudent(Student student) {
		
		dao.findByRut(student.getRut()).ifPresent(a -> { throw new InvalidInfoException("The rut you provided already exists"); } );
		
		dao.save(student);

		return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResult());
	}

	@Override
	public ResponseEntity<BaseResult> addDefaultStudents() {
		
		List<Student> defaultStudents = new ArrayList<>();
		defaultStudents.add(new Student("20038432-6","Manuel","Gonzales",21,new Course("Phyton", "5542")));
		defaultStudents.add(new Student("6041810-1","Daniela","Torres",32,new Course("React", "5248")));
		defaultStudents.add(new Student("7148408-4","Virginia","Mendez",25,new Course("Javascript", "5530")));
		
		dao.saveAll(defaultStudents);
		
		return null;
	}

}
