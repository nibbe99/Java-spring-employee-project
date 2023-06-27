package com.project.crudproject.rest;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.crudproject.entity.Employee;
import com.project.crudproject.rest.responses.EmployeeCreatedResponse;
import com.project.crudproject.rest.responses.EmployeeNotFoundException;
import com.project.crudproject.service.EmployeeService;

@RestController
public class EmployeeRestController {
	
	private EmployeeService employeeService;
	
	@Autowired
	public EmployeeRestController(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}

	@GetMapping("/employees")
	public List<Employee> findAll() {
		return employeeService.findAll();
	}
	
	@GetMapping("/employees/{employeeId}")
	public Employee findById(@PathVariable int employeeId) {
		
		Employee theEmployee = employeeService.findById(employeeId);
		if(theEmployee==null) {
			throw new EmployeeNotFoundException ("Employee does not exist with id: " + employeeId );
		}
		
		return employeeService.findById(employeeId);
	}
	
	//mapping for post /employees - add new Employee
	
	@PostMapping("/employees")
	public ResponseEntity <EmployeeCreatedResponse>addEmployee(@RequestBody Employee employee) {
			employee.setId(0);	//always creates new one. Not update existing
		 employeeService.save(employee);
		 EmployeeCreatedResponse emr = new EmployeeCreatedResponse();
		 emr.setMessage("Successfully created employee!");
		 emr.setTime(LocalTime.now());
		 return new ResponseEntity<>(emr,HttpStatus.CREATED);
	}
	
	@PutMapping("/employees")	//updates Employee
	public ResponseEntity <EmployeeCreatedResponse> updateEmployee(@RequestBody Employee employee) {
		
		Employee theEmployee = employeeService.findById(employee.getId());
		
		if(theEmployee == null) {
			throw new EmployeeNotFoundException("Employee does not exist with id: " + employee.getId());	
		}
		
		 EmployeeCreatedResponse emr = new EmployeeCreatedResponse();
		 emr.setMessage("Successfully Updated employee with id: " + employee.getId());
		 emr.setTime(LocalTime.now());
		 employeeService.save(employee);
		
		 return new ResponseEntity<>(emr,HttpStatus.OK);
		 
	}
	
	@DeleteMapping("/employees/{employeeId}")
	public ResponseEntity<EmployeeCreatedResponse> deleteEmployee(@PathVariable int employeeId){
		Employee theEmployee = employeeService.findById(employeeId);
		if(theEmployee == null) {
			throw new EmployeeNotFoundException("Employee does not exist with id: " + employeeId);	
		}
			employeeService.deleteById(employeeId);
			EmployeeCreatedResponse emr = new EmployeeCreatedResponse();
			emr.setMessage("Deleted Employee id: " + employeeId);
			emr.setTime(LocalTime.now());
		return new ResponseEntity<>(emr, HttpStatus.OK);
	}
	
}
























