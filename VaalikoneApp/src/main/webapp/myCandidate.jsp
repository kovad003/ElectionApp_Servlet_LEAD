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
	<!-- Display all Q&A data -->
	<div>
		<table class="table">                    
		    <thead class = "tableCustom1">
		    </thead>
		    	<tbody>
			        <tr><caption><h2>Best Match</h2></caption>
			        <tr>
			            <th>CANDIDATE_ID</th>
			            <th>Question ID</th>
			            <th>Question Text</th>
			            <th>Answer</th>
			            <th>Score</th> 
			            <th>Total Score</th>   
			        </tr>
			       	<c:forEach var="qanswer" items="${requestScope.result_1st}">
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
	</div>
	
	<!-- Display candidate profile -->
	<div>
		<ol>
			<li>CID: <c:out value="${requestScope.profile_1st.id}"></c:out></li>
			<li>Name: <c:out value="${requestScope.profile_1st.FName} ${requestScope.profile_1st.SName}"></c:out></li>
			<li>Party: <c:out value="${requestScope.profile_1st.party}"></c:out></li>
			<li>Occupation: <c:out value="${requestScope.profile_1st.profession}"></c:out></li>
			<li>Location: <c:out value="${requestScope.profile_1st.location}"></c:out></li>
			<li>Age: <c:out value="${requestScope.profile_1st.age}"></c:out></li>
			<li>Goals: <c:out value="${requestScope.profile_1st.goals}"></c:out></li>
			<li>Reason: <c:out value="${requestScope.profile_1st.reason}"></c:out></li>             
		</ol>
	</div>

	<!-- Display all Q&A data -->	
	<div>
		<table class="table">                    
		    <thead class = "tableCustom1">
		    </thead>
		    	<tbody>
			        <tr><caption><h2>2nd Best Match</h2></caption>
			        <tr>
			            <th>CANDIDATE_ID</th>
			            <th>Question ID</th>
			            <th>Question Text</th>
			            <th>Answer</th>
			            <th>Score</th> 
			            <th>Total Score</th>   
			        </tr>
			       	<c:forEach var="qanswer" items="${requestScope.result_2nd}">
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
	</div>
	
	<!-- Display candidate profile -->	
	<div>
		<ol>
			<li>CID: <c:out value="${requestScope.profile_2nd.id}"></c:out></li>
			<li>Name: <c:out value="${requestScope.profile_2nd.FName} ${requestScope.profile_1st.SName}"></c:out></li>
			<li>Party: <c:out value="${requestScope.profile_2nd.party}"></c:out></li>
			<li>Occupation: <c:out value="${requestScope.profile_2nd.profession}"></c:out></li>
			<li>Location: <c:out value="${requestScope.profile_2nd.location}"></c:out></li>
			<li>Age: <c:out value="${requestScope.profile_2nd.age}"></c:out></li>
			<li>Goals: <c:out value="${requestScope.profile_2nd.goals}"></c:out></li>
			<li>Reason: <c:out value="${requestScope.profile_2nd.reason}"></c:out></li>             
		</ol>
	</div>

	<!-- Display all Q&A data -->	
	<div>
		<table class="table">                    
		    <thead class = "tableCustom1">
		    </thead>
		    	<tbody>
			        <tr><caption><h2>3rd Best Match</h2></caption>
			        <tr>
			            <th>CANDIDATE_ID</th>
			            <th>Question ID</th>
			            <th>Question Text</th>
			            <th>Answer</th>
			            <th>Score</th> 
			            <th>Total Score</th>   
			        </tr>
			       	<c:forEach var="qanswer" items="${requestScope.result_3rd}">
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
	</div>
	
	<!-- Display candidate profile -->
	<div>
		<ol>
			<li>CID: <c:out value="${requestScope.profile_3rd.id}"></c:out></li>
			<li>Name: <c:out value="${requestScope.profile_3rd.FName} ${requestScope.profile_1st.SName}"></c:out></li>
			<li>Party: <c:out value="${requestScope.profile_3rd.party}"></c:out></li>
			<li>Occupation: <c:out value="${requestScope.profile_3rd.profession}"></c:out></li>
			<li>Location: <c:out value="${requestScope.profile_3rd.location}"></c:out></li>
			<li>Age: <c:out value="${requestScope.profile_3rd.age}"></c:out></li>
			<li>Goals: <c:out value="${requestScope.profile_3rd.goals}"></c:out></li>
			<li>Reason: <c:out value="${requestScope.profile_3rd.reason}"></c:out></li>             
		</ol>
	</div>

    
</body>
</html>