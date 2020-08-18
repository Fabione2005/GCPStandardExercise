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

import com.standard.gcp.model.entities.Course;
import com.standard.gcp.model.generic.BaseResult;
import com.standard.gcp.service.course.CourseService;

@RestController
public class CourseController {
	
	@Autowired
	CourseService service;
	
	@GetMapping(value = "/courses", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Course> retrievecoursesService() {
		return service.retrieveAllCourses();
	}
	
	@GetMapping(value = "/courses/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Course retrieveStudentByIdService(@PathVariable UUID id) {
		return service.retrieveCourseById(id);
	}
	
	@PostMapping(value = "/courses",consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResult> createcourseservice(@RequestBody Course course) 
	{
		return service.addCourse(course);
	}
	
	@PutMapping(value = "/courses",consumes=MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<BaseResult> updatecourseservice(@RequestBody Course course) 
	{
		return service.updateCourse(course);
	}
	
	@DeleteMapping(value="/courses/delete/{id}")
	public ResponseEntity<BaseResult> deleteStock(@PathVariable UUID id) {
		return service.deleteCourse(id);
	}
}
