<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.Candidate" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<html lang="en">
<head>
	<!-- AD - This line might potentially be necessary later on 
	<meta charset="ISO-8859-1">
	-->
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- allows for the use of special 'materialize' icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <!-- AD - links to the election machine external css file-->
    <link href="../css/style.css" rel="stylesheet">

    <title>Candidates</title>
    
</head>
<body>

<!-- AD - customises the navbar-->
<div class="container-nav1">
    <div class="container-nav3">
        <div class="container-nav4">              
            <!-- AD - icon customisation -->
            <div class = "container-nav-links-icon">
            <a href="https://www.google.com/"><i class="material-icons resize3a">account_balance</i></a>              
            </div>
            <div class = "container-nav-links">
                <a href="index.jsp"><h5>About</h5></a>
            </div>
            <div class = "container-nav-links">
                <a href="/ShowQuestions"><h5>Questionnaire</h5></a>
            </div>
            <div class = "container-nav-links">
                <a href="/ShowCandidates"><h5>Candidates</h5></a>
            </div>
            <div class = "container-nav-links">
                <a href="loginPage.jsp"><h5>Login</h5></a>
            </div>               
        </div>
    </div>
</div>

    <!-- AD - Beginning the central (yellow container)-->
    <div class="container">
        <i class="material-icons resize1">account_balance</i>
        
        <!-- AD - customises the welcome message-->
        <div class="container6"> 
        <h2>The Candidates</h2>
        </div>
       
        <!-- AD - This container adds colourings and style to the intro message -->
        <div class="container5">
        <!-- AD - Introductory statement about the candidates page -->
        <h5>This section covers the candidates who are putting themselves forward 
            for election to the Finnish Parliament, during the Finnish Parliamentary
            Elections 2021.
            <br><br>
            Have a quick read to find out more
            about each candidate. In particular, you can find out what Parliamentary 
            goals they hope to achieve should they get elected!
        </h5>
        </div>

        <!-- AD - This container customises the heading to the candidate overviews-->
        <div class="container7">
        <h3>Here, let's let the candidates introduces themselves:</h3>
        </div>
    
        <hr> 

        <!-- AD - Candidate 1 intro colourings and text -->
        <c:forEach begin="0" end="1" var="candidate" items="${requestScope.candidatelist}">
        <div class="container8">
            <!-- AD - Intro / overview statement about the candidate -->
            <h5>
            	<c:out value = "${candidate.FName} ${candidate.SName} - ${candidate.party}"/>
                <br><br>
                Age:
                <c:out value = "${candidate.age}"/>
                <br>
                Profession:
                <c:out value = "${candidate.profession}"/>
                <br>
                Location:
                <c:out value = "${candidate.location}"/>
                <br><br>
                Hi, my name is
            	<c:out value = "${candidate.FName}"/>!
				<br><br>
                <c:out value = "${candidate.goals}"/>
                <br><br>
                <c:out value = "${candidate.reason}"/>
                <br><br>
            </h5>
        </div>
        </c:forEach>


        <!-- End ot the candidate intro / overview section-->
        <hr>

        <!-- AD - Beginning of the selection button section (answers)-->
        <div class="container2">           
            <!-- AD - A small container to amend the disclaimer background section-->
            <div class="container4">  
            
                <!-- AD - Questionnaire guidance for the user -->
		    <h5>DISCLAIMER: Neither the 'Global Herald Newspaper' or 'HÄMK's Finest'
                are to be held liable for any views or comments expressed by the candidates 
                or users of this site. Your data is confidential and will not be shared or
                sold in any capacity. All rights reserved.</h5>
            
            </div>
		    
            <hr>      
    
            <!-- AD - A container for the login and registration buttons-->
            <div class="container3">

                <!-- AD - Buttons for login and registration-->
                <button class="button-main button1"><b>PREVIOUS</b></button>
                
                <button class="button-main button1"><b>NEXT</b></button>

            </div>
        
        <!-- AD - End of the selection button section (answers)-->
        </div>

    <!-- AD - End of the central (yellow container)-->
    </div>


</body><!-- AD - End of body-->
</html><!-- AD - End of html-->