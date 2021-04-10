<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

    
<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.Question" %>   
<%@ page import="data.Answer" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<table class="table">                    
    <thead class = "tableCustom1">
    </thead>
    <tbody>
        <tr><caption><h2>List of Candidates</h2></caption>
        <tr>
            <th>CANDIDATE_ID</th>
            <th>PARTY</th>  
        </tr>
       <c:forEach var="candidate" items="${requestScope.topCnd_1}">
		<tr>	
		<td><c:out value="${candidate.cid}" /></td>
		<td><c:out value="${candidate.score}" /></td>	
		<td class = "tableCustom5"><a href="#"><u><b class = "tableCustom2">UPDATE</b></u></a></td>                    
        <td class = "tableCustom5"><a href="#"><u><b class = "tableCustom3">DELETE</b></u></a></td>
		</tr>
	</c:forEach>                  
        </tr>
             </tbody>                
         </table>
    
</body>
</html>