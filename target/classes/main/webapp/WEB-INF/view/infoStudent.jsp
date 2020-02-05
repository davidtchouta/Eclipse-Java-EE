<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Bonjour</h1>
	
	<p>${Student.nom}</p><br>
	
	<p>${Student.prenom}</p><br>
	
	<p>${Student.email}</p><br>
	
	<h3>Liste des étudiants </h3>
	
<c:if test="${!empty listStudent}">
	<table class="tg">
	<tr>
		<th width="120">Student ID</th>
		<th width="120">Student Nom</th>
		<th width="120">Student Prenom</th>
		<th width="120">Student Email</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listStudent}" var="Student">
		<tr>
			<td>${Student.id}</td> 
			<td>${Student.nom}</td>
			<td>${Student.prenom}</td>
			<td>${Student.email}</td>
			<td><a href="<c:url value='/edit/${Student.id}' />" >Edit</a></td>
			<td><a href="<c:url value='/supprimer/${Student.id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
	
	<a href="formulaireStudent">Retourne au formulaire étudiant</a>
</body>
</html>