package com.springdemo.rest;

public class StudentResponse {
	private int status;
	private String message;
	private long temps;
	
	//constructors
	
	public StudentResponse() {};
	
	public StudentResponse(int status, String message, long temps) {
		this.status = status;
		this.message = message;
		this.temps = temps;
	}
	
	
	// setters et getters
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
	public long getTemps() {
		return temps;
	}
	public void setTemps(long temps) {
		this.temps = temps;
	}
	
	
}
