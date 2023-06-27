package com.project.crudproject.rest.responses;

import java.time.LocalTime;

public class EmployeeErrorResponse {
	
	private int status;
	private String message;
	private LocalTime time;
	
	public EmployeeErrorResponse() {
		
	}
	
	public EmployeeErrorResponse(int status, String message, LocalTime time) {
		this.status = status;
		this.message = message;
		this.time = time;
	}
	
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
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
		return "EmployeeErrorResponse [status=" + status + ", message=" + message + ", time=" + time + "]";
	}
	

}
