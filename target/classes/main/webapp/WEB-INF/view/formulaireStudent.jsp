<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
	<form:form method="POST" action="infoStudent" modelAttribute="Student">
		<form:label path="nom">Nom</form:label><br>
		<form:input path="nom"/>
		<form:errors path="nom" cssClass="error" /><br>
		
		<form:label path="prenom">Prenom</form:label><br>
		<form:input path="prenom"/><br>
		
		<form:label path="email">Email</form:label><br>
		<form:input path="email"/><br>
		
		
		<input type="submit" value="Valider"/>
		
	</form:form>
	
	<img p src="${pageContext.request.contextPath}/resources/images/projet.jpg"  height="200px" width="200px"/>

</body>
</html>