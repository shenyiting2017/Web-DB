package com.yiting.webdb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yiting.webdb.AjaxResponse;
import com.yiting.webdb.models.StudentScore;
import com.yiting.webdb.services.StudentScoreService;

@RestController
@RequestMapping(path="/studentscore")
public class StudentScoreController {
	@Autowired
	private StudentScoreService studentScoreService;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public @ResponseBody AjaxResponse getStudentScores(@RequestParam String studentId) {
		AjaxResponse response = AjaxResponse.successResponse();
		List<StudentScore> studentScores = studentScoreService.getStudentScores(Integer.valueOf(studentId));
		response.putData("result", studentScores);
		return response;
	}
	
	@RequestMapping(path="/", method=RequestMethod.POST)
	public @ResponseBody AjaxResponse addStudentScore(@RequestParam String studentId, @RequestParam String courseId, @RequestParam String score) {
		try {
			studentScoreService.addStudentScore(Integer.valueOf(studentId), Integer.valueOf(courseId), Integer.valueOf(score));
			return AjaxResponse.successResponse();
		} catch (Exception e) {
			AjaxResponse response = AjaxResponse.errorResponse();
			response.putData("message", e.getMessage());
			return response;
		}
	}
}
