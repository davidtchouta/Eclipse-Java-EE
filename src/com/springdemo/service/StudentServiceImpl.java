package com.springdemo.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springdemo.dao.StudentDao;
import com.springdemo.hibernate.Student;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentDao;
	
	public void setStudentDao(StudentDao studentDao) {
		this.studentDao = studentDao;
	}

	@Transactional
	public void save(Student st) {
		this.studentDao.save(st);
		
	}

	@Transactional
	public ArrayList<Student> afficherlist() {
		return (ArrayList<Student>) this.studentDao.afficherlist();
	}

	@Transactional
	public void remove(int id) {
		this.studentDao.remove(id);
		
	}
	
	@Transactional
	public void editerEtudiant(Student st) {
		this.studentDao.editerEtudiant(st);
		
	}
	
	@Transactional
	public Student afficherStudentId(int id) {
		return this.studentDao.afficherStudentId(id);
	}
	
	@Transactional
	public void removeByName(String nom) {
		this.studentDao.removeByName(nom);
		
	}
	
	@Transactional
	public Student afficherStudentByName(String nom) {
		return this.studentDao.afficherStudentByName(nom);
	}

	public Student modifier(String nom,  String nnom, String prenom, String email) {
		return this.studentDao.modifier(nom, nnom, prenom, email);
	}

	public void updateStudent(Student st) {
		this.studentDao.updateStudent(st);
		
	}
	
	
	
}
