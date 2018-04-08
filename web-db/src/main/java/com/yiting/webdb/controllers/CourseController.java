package com.yiting.webdb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yiting.webdb.AjaxResponse;
import com.yiting.webdb.models.Course;
import com.yiting.webdb.services.CourseService;

@RestController
@RequestMapping(path="/course")
public class CourseController {
	@Autowired
	private CourseService courseService;

	@RequestMapping(path="/", method=RequestMethod.GET)
	public @ResponseBody AjaxResponse getCourses() {
		AjaxResponse response = AjaxResponse.successResponse();
		List<Course> courses = courseService.getCourses();
		response.putData("result", courses);
		return response;
	}
	
	
	@RequestMapping(path="/add", method=RequestMethod.POST)
	public @ResponseBody AjaxResponse addCourse(@RequestParam String courseName, @RequestParam String credit) {
		try {
			courseService.addCourse(courseName, Integer.valueOf(credit));
			return AjaxResponse.successResponse();
		} catch (Exception e) {
			AjaxResponse response = AjaxResponse.errorResponse();
			response.putData("message", e.getMessage());
			return response;
		}
	}
}
