package com.standard.gcp.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.standard.gcp.model.entities.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, UUID> 
{
	Optional<List<Course>> findByCode(String rut);
}
