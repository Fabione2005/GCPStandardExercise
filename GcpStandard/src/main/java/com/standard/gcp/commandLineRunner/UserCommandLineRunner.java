package com.standard.gcp.commandLineRunner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.standard.gcp.service.student.StudentService;

@Component
public class UserCommandLineRunner implements CommandLineRunner {

	@Autowired
	StudentService dao;

	@Override
	public void run(String... args) {
		// save a couple of admin users
		
		dao.addDefaultStudents();
	}

}