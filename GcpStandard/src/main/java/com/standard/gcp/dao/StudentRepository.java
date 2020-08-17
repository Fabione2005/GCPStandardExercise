package com.standard.gcp.dao;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.standard.gcp.model.entities.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student, UUID> 
{
	Optional<List<Student>> findByName(String name);
	Optional<List<Student>> findByLastName(String lastName);
	Optional<List<Student>> findByRut(String rut);
	Optional<List<Student>> findByAge(int age);
}
