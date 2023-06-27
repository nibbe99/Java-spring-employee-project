package com.project.crudproject.dao;

import java.util.List;

import com.project.crudproject.entity.Employee;

public interface EmployeeDAO {
	
	List<Employee> findAll();
	
	Employee findById(int id);
	
	Employee save(Employee employee);
	
	void deleteById(int id);
	
	int deleteAll();
	
}
