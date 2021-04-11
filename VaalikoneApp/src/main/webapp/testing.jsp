<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
%>

<h3>Logged in with id: <%=id %>.</h3>
<!-- logs out -->
<form action="LogoutServlet" method="post">
<input type="submit" value="Logout" >
</form>

</body>
</html>