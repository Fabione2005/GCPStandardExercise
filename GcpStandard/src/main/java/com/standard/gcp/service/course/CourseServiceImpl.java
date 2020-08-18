package com.standard.gcp.service.course;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.standard.gcp.dao.CourseRepository;
import com.standard.gcp.exception.InvalidInfoException;
import com.standard.gcp.exception.RegisterNotFoundException;
import com.standard.gcp.model.entities.Course;
import com.standard.gcp.model.generic.BaseResult;

@Service
public class CourseServiceImpl implements CourseService{

	@Autowired
	CourseRepository dao;
	
	@Override
	public Course retrieveCourseById(UUID id) {
		
		Course studentFound = dao.findById(id).orElseThrow(RegisterNotFoundException::new);

		return studentFound;
	}

	@Override
	public List<Course> retrieveAllCourses() {
		return dao.findAll();
	}

	@Override
	public ResponseEntity<BaseResult> updateCourse(Course course) {
		
		dao.findById(course.getId()).orElseThrow(RegisterNotFoundException::new);
		
		dao.save(course);

		return ResponseEntity.status(HttpStatus.OK).body(new BaseResult());
	}

	@Override
	public ResponseEntity<BaseResult> deleteCourse(UUID id) {
		
		Course courseFound = dao.findById(id).orElseThrow(RegisterNotFoundException::new);

		dao.delete(courseFound);

		return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new BaseResult());
		
	}

	@Override
	public ResponseEntity<BaseResult> addCourse(Course course) {
		
		dao.findByCode(course.getCode()).ifPresent(a -> { throw new InvalidInfoException("The course code you provided already exists"); } );

		dao.save(course);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(new BaseResult());
	}

}
