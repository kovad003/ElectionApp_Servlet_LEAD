<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome <%=session.getAttribute("name")%></title>
</head>
<body>
    <h3>Login successful!</h3>

<!--     <h4> -->
<!--         Hello, -->
<%--         <%=session.getAttribute("name")%></h4> --%>

<%
String name=(String)session.getAttribute("name");
%>

    <h1>Welcome <%out.println(name); %>!</h1>

	<a href="index.jsp">Logout</a>
</body>
</html>
