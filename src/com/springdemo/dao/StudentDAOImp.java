package com.springdemo.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Parameter;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Repository;

import com.springdemo.hibernate.Student;

@Scope(proxyMode = ScopedProxyMode.TARGET_CLASS)
@Repository 
public class StudentDAOImp implements StudentDao {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
	}
	
	
	@Transactional
	public void save(Student st) {
		System.out.println("save");
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(st);
		
	}
	
	@Transactional
	public ArrayList<Student> afficherlist() {
		Session session = this.sessionFactory.getCurrentSession();
		//@SuppressWarnings("unchecked")
		ArrayList<Student> listStudent = (ArrayList<Student>) session.createQuery("from Student").list();
		for(Student st: listStudent) {System.out.println(st);}
		
		return listStudent;
	}
	
	@Transactional
	public void remove(int id) {
		Session session = this.sessionFactory.getCurrentSession();
		Student p = (Student) session.load(Student.class, new Integer(id));
		if(null != p){
			System.out.println("Person deleted successfully, person details="+id);
			session.delete(p);
		}else {	
			 System.out.println("Person deleted failed, person details="+id);
		}
		
	}
	
	@Transactional
	public void removeByName(String nom) {
		Session session = this.sessionFactory.getCurrentSession();
		Query req = session.createQuery("FROM Student WHERE nom= : param");
		req.setParameter("param", nom);
		ArrayList<Student> listNoms= (ArrayList<Student>) ((org.hibernate.query.Query) req).list();
		for(Student st: listNoms) {
			System.out.println("Person deleted successfully, person details="+ nom);
			session.delete(st);
			}	
	}

	@Transactional
	public void editerEtudiant(Student st) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(st);
		
	}

	
	@Transactional
	public Student afficherStudentId(int id) {
		Session session = this.sessionFactory.getCurrentSession();		
		Student st = (Student) session.load(Student.class, new Integer(id));
		//logger.info("Person loaded successfully, Person details="+p);
		System.out.println("On a bien chargé l'étudiant "+ st);
		return st;
	}
	
	@Transactional
	public Student afficherStudentByName(String nom) {
		Session session = this.sessionFactory.getCurrentSession();		
		Query req = session.createQuery("FROM Student WHERE nom= : param");
		req.setParameter("param", nom);
		ArrayList<Student> listNoms= (ArrayList<Student>) ((org.hibernate.query.Query) req).list();
		for(Student stt: listNoms) {
			System.out.println("On a bien chargé l'étudiant "+ stt);
			return stt;
		}
		return null;	
	}
	
	
	@Transactional
	public Student modifier(String nom,  String nnom, String prenom, String email) {
		Session session = this.sessionFactory.getCurrentSession();	
		Query query = session.createQuery("update Student set  nom = :nnom," + "prenom = :prenom," + "email= :email" +
				" where nom = :nom");
		query.setParameter("nom", nom);
		query.setParameter("nnom", nnom);
		query.setParameter("prenom", prenom);
		query.setParameter("email", email);
		int result = query.executeUpdate();
		return null;
		
	}
	
	@Transactional
	public void updateStudent(Student st) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(st);
		System.out.println("Person updated successfully, Person Details="+ st);
	}
	

}
