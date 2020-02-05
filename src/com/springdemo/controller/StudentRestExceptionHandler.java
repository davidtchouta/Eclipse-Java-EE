package com.springdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.springdemo.hibernate.Student;
import com.springdemo.rest.StudentNotFoundException;
import com.springdemo.rest.StudentResponse;
import com.springdemo.service.StudentService;

@ControllerAdvice
public class StudentRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<StudentResponse> handleException(StudentNotFoundException abc){
		StudentResponse sterror= new StudentResponse();
		sterror.setStatus(HttpStatus.NOT_FOUND.value());
		sterror.setMessage("L'id de Student est invalide");
		sterror.setTemps(System.currentTimeMillis());
		
		return new ResponseEntity<StudentResponse>(sterror, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<StudentResponse> handleException2(NumberFormatException abc){
		StudentResponse sterror= new StudentResponse();
		sterror.setStatus(HttpStatus.BAD_REQUEST.value());
		sterror.setMessage("L'id de Student est invalide, veuillez entrer un nombre");
		sterror.setTemps(System.currentTimeMillis());
		
		return new ResponseEntity<StudentResponse>(sterror, HttpStatus.BAD_REQUEST);
	}
	
	
}
