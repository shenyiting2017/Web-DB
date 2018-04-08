package com.yiting.webdb.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yiting.webdb.models.Department;
import com.yiting.webdb.repos.DepartmentRepository;

@Service
public class DepartmentService {
	@Autowired
	private DepartmentRepository departmentRepository;
	
	public List<Department> getDepartments() {
		List<Department> departments = (List<Department>) departmentRepository.findAll();
		return departments;
	}
	
	public void addDepartment(String name) {
		Department department = new Department();
		department.setName(name);
		departmentRepository.save(department);
	}
}
