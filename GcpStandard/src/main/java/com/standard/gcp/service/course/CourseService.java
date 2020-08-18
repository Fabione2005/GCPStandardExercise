package com.standard.gcp.service.course;

import java.util.List;
import java.util.UUID;

import org.springframework.http.ResponseEntity;

import com.standard.gcp.model.entities.Course;
import com.standard.gcp.model.generic.BaseResult;

public interface CourseService {
	Course retrieveCourseById(UUID id);
	List<Course> retrieveAllCourses();
	ResponseEntity<BaseResult> updateCourse(Course Course);
	ResponseEntity<BaseResult> deleteCourse(UUID id);
	ResponseEntity<BaseResult> addCourse(Course Course);
}
