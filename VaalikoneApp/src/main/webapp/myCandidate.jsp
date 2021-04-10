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
<title>My Candidates</title>
</head>
<body>

<table class="table">                    
    <thead class = "tableCustom1">
    </thead>
    <tbody>
        <tr><caption><h2>My Candidates</h2></caption>
        <tr>
            <th>CANDIDATE_ID</th>
            <th>Question ID</th>
            <th>Question Text</th>
            <th>Answer</th>
            <th>Score</th> 
            <th>Total Score</th>   
        </tr>
       <c:forEach var="qanswer" items="${requestScope.topCnd_1}">
		<tr>	
		<td><c:out value="${qanswer.CId}" /></td>
		<td><c:out value="${qanswer.QId}" /></td>
		<td><c:out value="${qanswer.QTxt}" /></td>
		<td><c:out value="${qanswer.answer}" /></td>
		<td><c:out value="${qanswer.score}" /></td>
		<td><c:out value="${qanswer.totalScore}" /></td>			
		</tr>
	</c:forEach>                  
             </tbody>                
</table>

<table class="table">                    
    <thead class = "tableCustom1">
    </thead>
    <tbody>
        <tr><caption><h2>My Candidates</h2></caption>
        <tr>
            <th>CANDIDATE_ID</th>
            <th>Question ID</th>
            <th>Question Text</th>
            <th>Answer</th>
            <th>Score</th> 
            <th>Total Score</th>   
        </tr>
       <c:forEach var="qanswer" items="${requestScope.topCnd_2}">
		<tr>	
		<td><c:out value="${qanswer.CId}" /></td>
		<td><c:out value="${qanswer.QId}" /></td>
		<td><c:out value="${qanswer.QTxt}" /></td>
		<td><c:out value="${qanswer.answer}" /></td>
		<td><c:out value="${qanswer.score}" /></td>
		<td><c:out value="${qanswer.totalScore}" /></td>			
		</tr>
	</c:forEach>                  
             </tbody>                
</table>

<table class="table">                    
    <thead class = "tableCustom1">
    </thead>
    <tbody>
        <tr><caption><h2>My Candidates</h2></caption>
        <tr>
            <th>CANDIDATE_ID</th>
            <th>Question ID</th>
            <th>Question Text</th>
            <th>Answer</th>
            <th>Score</th> 
            <th>Total Score</th>   
        </tr>
       <c:forEach var="qanswer" items="${requestScope.topCnd_3}">
		<tr>	
		<td><c:out value="${qanswer.CId}" /></td>
		<td><c:out value="${qanswer.QId}" /></td>
		<td><c:out value="${qanswer.QTxt}" /></td>
		<td><c:out value="${qanswer.answer}" /></td>
		<td><c:out value="${qanswer.score}" /></td>
		<td><c:out value="${qanswer.totalScore}" /></td>			
		</tr>
	</c:forEach>                  
             </tbody>                
</table>
    
</body>
</html>