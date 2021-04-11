<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
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
if (id!=null) {
%>
<!-- logs out -->
<form action="LogoutServlet" method="post">
<input type="submit" value="Logout" >
</form>
<%
}
else {
	%>
	<table>
	<tr>
	 <td><br><input type="submit" value="LOGIN" /></td>
	 </tr>
     </table>
     <%
}
%>

