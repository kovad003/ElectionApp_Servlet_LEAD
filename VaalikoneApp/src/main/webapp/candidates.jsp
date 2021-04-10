<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.Candidate" %>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   

<html lang="en">
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>
    
    <title>Candidates</title>
    
    <!-- AD - includes the header component, into this page -->
    <%@ include file="../components/header.jsp" %> 
    
</head>
<body>

   <!-- AD - includes the navbar component, into this page -->
   <%@ include file="../components/navbar.jsp" %> 
 
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
        <c:forEach begin="0" end="18" var="candidate" items="${requestScope.candidatelist}">
        <div class="container8">
            <!-- AD - Intro / overview statement about the candidates -->
            <div class = "containerDynamicCandidate" >
                <h3>    
            	<c:out value = "${candidate.FName} ${candidate.SName} - ${candidate.party}"/>
            	</h3>            	
               	<hr>
               	
               	<h5>
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
                </h5>                
               
            </div>
        </div>
        </c:forEach>

        <!-- End ot the candidate intro / overview section-->
        <hr>

        <!-- AD - Beginning of the selection button section (answers)-->
        <div class="container2">           
            <!-- AD - A small container to amend the disclaimer background section-->
            <div class="container5">  
            
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

	<!-- AD - includes the footer component into this page 
    (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %>

</body><!-- AD - End of body-->
</html><!-- AD - End of html-->