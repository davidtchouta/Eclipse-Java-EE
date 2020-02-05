package com.springdemo.hibernate;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown=true)
public class ListStudent {
	private List <Student> listStudent;
	
	
	public ListStudent() {}

	public List<Student> getListStudent() {
		return listStudent;
	}
	
	
	public void setListStudent(List<Student> listStudent) {
		this.listStudent = listStudent;
	}
}
