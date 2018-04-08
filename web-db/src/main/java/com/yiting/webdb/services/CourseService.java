package com.yiting.webdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiting.webdb.models.Course;
import com.yiting.webdb.repos.CourseRepository;

@Service
public class CourseService {
	@Autowired
	private CourseRepository courseRepository;
	
	public List<Course> getCourses() {
		List<Course> courses = (List<Course>) courseRepository.findAll();
		return courses;
	}
	public void addCourse(String name, Integer credit) {
		Course course = new Course();
		course.setName(name);
		course.setCredit(credit);
		courseRepository.save(course);
	}
}
