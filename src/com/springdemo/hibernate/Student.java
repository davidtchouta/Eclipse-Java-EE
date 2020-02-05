package com.springdemo.hibernate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mysql.cj.jdbc.Blob;


@Entity
@Table(name="student")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Student {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	
	@Column(name="nom")
	@NotNull(message="Ne peut-être null")
	private String nom;
	
	
	@Column(name="prenom")
	@NotNull(message="Ne peut-être null")
	private String prenom;
	
	@Column(name="email")
	@NotNull(message="Ne peut-être null")
	private String email;
	
	
	/*@Column(name = "photo")
	private Blob photo;*/
	
	
	//constructors
	public Student() {};
	
	public Student(@NotNull String nom, @NotNull String prenom, @NotNull String email) {
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	//getters et setters

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}
	

	/*public Blob getPhoto() {
		return this.photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}*/

}
