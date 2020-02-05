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
	
	<p>Nom : ${Student.nom}</p><br>
	
	<p>Prenom : ${Student.prenom}</p><br>
	
	<p>Mail : ${Student.email}</p><br>
	
	<table>
		<tr>
			<td>ID</td>
			<td>Nom</td>
			<td>Prenom</td>
			<td>Email</td>
			<td colspan="2" align="center">ACTION</td>
		</tr>
		
		<tr>
		    <td> ${Student.id}</td>
		    <td><input type="text" value="${Student.nom}"></td>
		    <td><input type="text" value="${Student.prenom}"></td>
		    <td><input type="text" value="${Student.email}"></td>
		    <td><a href="<c:url value='/edit/infoStudent'/>">Sauvegarder</a></td>
   		</tr>
	</table>
	
	<a href="formulaireStudent">Retourne au formulaire étudiant</a>
</body>
</html>