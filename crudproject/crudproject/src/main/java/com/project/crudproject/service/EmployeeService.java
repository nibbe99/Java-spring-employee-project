package com.project.crudproject.service;

import java.util.List;

import com.project.crudproject.entity.Employee;

public interface EmployeeService {
	
	List<Employee>findAll();
	
	Employee findById(int id);
	
	Employee save(Employee employee);
	
	void deleteById(int id);
	
	int deleteAll();

}
