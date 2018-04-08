package com.yiting.webdb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yiting.webdb.AjaxResponse;
import com.yiting.webdb.models.Student;
import com.yiting.webdb.services.StudentService;

@RestController
@RequestMapping(path="/student")
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public @ResponseBody AjaxResponse getStudents() {
		AjaxResponse response = AjaxResponse.successResponse();
		List<Student> students = studentService.getStudents();
		response.putData("result", students);
		return response;
	}
	
	@RequestMapping(path="/", method=RequestMethod.POST)
	public @ResponseBody AjaxResponse addStudent(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String departmentId) {
		try {
			studentService.addStudent(firstName, lastName, Integer.valueOf(departmentId));
			return AjaxResponse.successResponse();
		} catch (Exception e) {
			AjaxResponse response = AjaxResponse.errorResponse();
			response.putData("message", e.getMessage());
			return response;
		}
	}
}
