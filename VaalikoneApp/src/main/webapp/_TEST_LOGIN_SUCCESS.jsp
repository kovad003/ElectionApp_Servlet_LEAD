<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Success Page</title>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
</head>
<body>

<%
// init empty vars
String id = null;

// grab loginCookie info
Cookie[] login = request.getCookies();
if(login !=null){
	for(Cookie i : login){
		/*
		 * LoginServlet: loginCookie -> userName
		 */
		if(i.getName().equals("user")) id = i.getValue();
		}
}

// if cookie can't grab userName -> redirect to 
if(id == null) response.sendRedirect("login.html");
{
	
}
%>

<h3>Logged in with id: <%=id %>.</h3>

<%
if(id.startsWith("9")==true) {
	// if admin ->
	response.sendRedirect("adminPortal.jsp");
}
else {
	// if candidate ->
	response.sendRedirect("candidatePortal.jsp");	
}
%>
<br>

<!-- logs out -->
<form action="LogoutServlet" method="post">
<input type="submit" value="Logout" >
</form>


</body>
</html>