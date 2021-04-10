<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Login Success Page</title>
</head>
<body>

<%
// init empty vars
String userName = null;
String id = null;

// grab loginCookie info
Cookie[] login = request.getCookies();
if(login !=null){
	for(Cookie i : login){
		/*
		 * LoginServlet: loginCookie -> userName
		 */
		if(i.getName().equals("user")) userName = i.getValue();
		}
}

// if cookie can't grab userName -> redirect to 
if(userName == null) response.sendRedirect("login.html");
%>

<h3>Hi <%=userName %>, Login successful on id: <%=id %>.</h3>
<br>

<!-- logs out -->
<form action="LogoutServlet" method="post">
<input type="submit" value="Logout" >
</form>


</body>
</html>