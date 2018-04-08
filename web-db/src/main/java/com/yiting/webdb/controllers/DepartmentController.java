package com.yiting.webdb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.yiting.webdb.AjaxResponse;
import com.yiting.webdb.models.Department;
import com.yiting.webdb.services.DepartmentService;

@RestController
@RequestMapping(path="/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping(path="/", method=RequestMethod.GET)
	public @ResponseBody AjaxResponse getDepartments() {
		AjaxResponse response = AjaxResponse.successResponse();
		List<Department> departments = departmentService.getDepartments();
		response.putData("result", departments);
		return response;
	}
	
	@RequestMapping(path="/add", method=RequestMethod.POST)
	public @ResponseBody AjaxResponse addDepartment(@RequestParam String departmentName) {
		try {
			departmentService.addDepartment(departmentName);
			return AjaxResponse.successResponse();
		} catch (Exception e) {
			AjaxResponse response = AjaxResponse.errorResponse();
			response.putData("message", e.getMessage());
			return response;
		}
	}
}
