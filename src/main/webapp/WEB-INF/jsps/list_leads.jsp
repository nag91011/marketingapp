<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list of leads</title>
</head>
<body>
<h2>list of all Leads</h2>
	<table>
		<tr>
			<th> First Name </th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Actions</th>
		</tr>
		
		<c:forEach var = "lead" items="${leads}" >
			<tr>
				<td>${lead.firstName}</td>
				<td>${lead.lastName}</td>
				<td>${lead.email}</td>
				<td>${lead.mobile}</td>
				<td><a href="updateLink?id=${lead.id}">UpdateLinkName</a></td>
				<td><a href="deleteLink?id=${lead.id}">deleteLinkName</a></td>
				
			</tr>		
		</c:forEach>
	</table>

</body>
</html>