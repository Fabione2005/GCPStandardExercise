package com.standard.gcp.service.generic;

import com.standard.gcp.model.entities.Student;
import com.standard.gcp.service.student.StudentService;

public interface InfoCheckService {
	StudentService getStudentService(Student student);
}
