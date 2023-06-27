package com.project.crudproject.rest.responses;

import java.time.LocalTime;

public class EmployeeCreatedResponse {
	private String message;
	private LocalTime time;
	
	public EmployeeCreatedResponse() {
		
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalTime getTime() {
		return time;
	}

	public void setTime(LocalTime time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "EmployeeCreatedResponse [message=" + message + ", time=" + time + "]";
	}
	
}
