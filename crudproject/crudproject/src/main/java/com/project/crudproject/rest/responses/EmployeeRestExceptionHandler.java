package com.project.crudproject.rest.responses;

import java.time.LocalTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class EmployeeRestExceptionHandler {
	

	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleException(EmployeeNotFoundException exc){

		EmployeeErrorResponse error = new EmployeeErrorResponse();
		
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setTime(LocalTime.now());
		error.setMessage(exc.getMessage());
	
		
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}

}


