package com.project.crudproject.rest.responses;


public class EmployeeNotFoundException extends RuntimeException{

	public EmployeeNotFoundException() {
		
	}
	
	public EmployeeNotFoundException(String message) {
		super(message);
	}
	
}
