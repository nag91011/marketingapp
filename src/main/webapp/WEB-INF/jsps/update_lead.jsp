<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Lead | create</h2>
<form action="updateFromWeb" method="post">
<pre>
			<input type="hidden" name="id" value="${leadId.id}">
First Name  <input type="text" name="firstName" value="${leadId.firstName}"/>
Last Name   <input type="text" name="lastName" value="${leadId.lastName}"/>
Email       <input type="text" name="email" value="${leadId.email}"/>
mobile      <input type="text" name="mobile" value="${leadId.mobile}"/>
            <input type="submit" value="save"/>


</pre>


</form>
${msg}
</body>
</html>