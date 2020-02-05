package com.springdemo.controller;



import javax.validation.Valid;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mysql.cj.xdevapi.SessionFactory;
import com.springdemo.hibernate.Student;
import com.springdemo.service.StudentService;


@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	private StudentService ss;
	
	@RequestMapping("/accueil")
	public String accueil() {
		System.out.println("form 1");
		return "accueil";
	}
	
	@RequestMapping("/formulaireStudent")
	public String formulaireStudent(Model model) {
		System.out.println("form 1");
		 model.addAttribute("Student", new Student()); 
		return "formulaireStudent";
	}
	
	@RequestMapping("/infoStudent")
	public String infoStudent(@Valid @ModelAttribute("Student") Student s, BindingResult bd, Model m) {
		if (bd.hasErrors()) {
			System.out.println("erreur d'affichage de données");
			return "formulaireStudent";
		}else {
			System.out.println("affichage des paramètres");
			m.addAttribute("Student", s); 
			System.out.println(s);
			this.ss.save(s);
			m.addAttribute("listStudent", this.ss.afficherlist());
			for(Student student : this.ss.afficherlist()) {
				System.out.println(student);
			}

			return "infoStudent";
		}
	}
	
	
	@RequestMapping("/supprimer/{id}")
	public String supprimer(@PathVariable("id") int id, Model m, @ModelAttribute("Student") Student s) {
			System.out.println("resultat :bien supprimé l'id : " + id);
			this.ss.remove(id);
			//m.addAttribute("Student", s);
			m.addAttribute("listStudent", this.ss.afficherlist());
			for(Student student : this.ss.afficherlist()) {
				System.out.println(student);
			}
			return "infoStudent";			
	}
	
	
	@RequestMapping("/edit/{id}")
    public String editPerson(@PathVariable("id") int id, Model model){
        model.addAttribute("Student", this.ss.afficherStudentId((id)));
        model.addAttribute("listStudent", this.ss.afficherlist());
        return "edit";
    }
	
	
	@RequestMapping("/edit/infoStudent")
	public String editStudent(@ModelAttribute("Student") Student st) {
		if(st.getId() == 0) {
			this.ss.save(st);
		}else {
			this.ss.updateStudent(st);
		}
		
		return "redirect:/infoStudent";
			
	}

	

	
	
}
