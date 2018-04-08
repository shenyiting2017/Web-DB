package com.yiting.webdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiting.webdb.models.Student;
import com.yiting.webdb.repos.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> getStudents() {
		List<Student> students = (List<Student>) studentRepository.findAll();
		return students;
	}
	
	public void addStudent(String firstName, String lastName, Integer departmentId) {
		Student student = new Student();
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setDepartmentId(departmentId);
		
		studentRepository.save(student);
	}
}
