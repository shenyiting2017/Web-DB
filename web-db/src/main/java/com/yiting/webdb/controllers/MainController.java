package com.yiting.webdb.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yiting.webdb.AjaxResponse;
import com.yiting.webdb.services.QueryService;

@Controller
public class MainController {
	@Autowired
	QueryService queryService;

	@RequestMapping("/")
	String home() {
		return "index.html";
	}
	
	@GetMapping(path="/add")
	public @ResponseBody String demo() {
		return "demo";
	}
	
	@RequestMapping(path="/query", method = RequestMethod.POST)
	public @ResponseBody AjaxResponse query(@RequestParam String queryStr) {
		try {
			List<Object[]> queryResults = queryService.query(queryStr);
			AjaxResponse response = AjaxResponse.successResponse();
			response.putData("result", queryResults);
			return response;
		} catch (Exception e) {
			AjaxResponse response = AjaxResponse.errorResponse();
			response.putData("message", e.getMessage());
			return response;
		}
	}
}
