package com.springdemo.service;

import java.util.ArrayList;
import java.util.List;

import com.springdemo.hibernate.Student;

public interface StudentService {
	
	public void save(Student st);
	
	public ArrayList<Student> afficherlist();
	
	public void remove(int id);
	
	public void removeByName(String nom);
	
	public void editerEtudiant(Student st);
	
	public Student afficherStudentId(int id);
	
	public Student afficherStudentByName(String nom);
	
	public Student modifier(String nom,  String nnom, String prenom, String email);
	
	public void updateStudent(Student st);
	
}
