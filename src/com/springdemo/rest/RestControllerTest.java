package com.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.NumberUtils;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.springdemo.dao.StudentDAOImp;
import com.springdemo.dao.StudentDao;
import com.springdemo.hibernate.Student;
import com.springdemo.service.StudentService;

@RestController
@RequestMapping("/api")
public class RestControllerTest {
		
	@Autowired
	private StudentService ss;
	
	
	@RequestMapping("/students")
	public ArrayList<Student> renvoijson() {
		System.out.println("renvoi du json de tous les étudiants");
		return this.ss.afficherlist();
	}
	
	@GetMapping("/students/id/{id}")
	public Student renvoijsonid(@PathVariable("id") int id) {
		System.out.println("renvoi du json d'un étudiant");
		Integer x = id;
		
		if (id<0 || id>this.ss.afficherlist().size()) {
			System.out.println("Erreur id");
			System.out.println(this.ss.afficherlist().size());
			throw new StudentNotFoundException("L'id "+ id + "n'existe pas");
			
		} else if( !(x instanceof Integer )) {
			throw new NumberFormatException("L'id +"+ id + "entré n'est pas un nombre");
		} else {
			System.out.println("Pas d'erreur id");
			return this.ss.afficherStudentId(id);
		}
		
		
	}
	
	@GetMapping("/students/name/{nom}")
	public Student renvoijsonnom(@PathVariable("nom") String nom) {
		System.out.println("renvoi du json d'un étudiant");
		return this.ss.afficherStudentByName(nom);
	}
	
	@DeleteMapping("/supprimer/students/id/{id}")
	public void supprimerByid(@PathVariable("id") int id) {
		System.out.println("suppression json d'un étudiant");
		this.ss.remove(id);
	}
	
	@DeleteMapping("/supprimer/students/name/{nom}")
	public void supprimerByName(@PathVariable("nom") String nom) {
		System.out.println("suppression json d'un étudiant");
		this.ss.removeByName(nom);
	}
	
	@PostMapping("/ajouter/student")
	public void ajouterUnStudent(@RequestBody Student st) {
		System.out.println("ajout json d'un étudiant");
		this.ss.save(st);
	}
	
	@PutMapping("/modifier/{id}/{nom}/{prenom}/{email}")
	public String modifier(@PathVariable("id") int id,@PathVariable("nom") String nom, @PathVariable("prenom") String prenom, 
			@PathVariable("email") String email) {
		
	    this.ss.modifier(this.ss.afficherStudentId(id).getNom(), nom, prenom, email);
	    
	    return "Etudiant Modifié!.";
	  }
	
	/*@ExceptionHandler
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
	}*/
	
	
	
}
