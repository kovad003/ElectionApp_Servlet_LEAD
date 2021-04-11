<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>
    
    <title>Homepage</title>
    
   <!-- AD - includes the header component, into this page -->
    <%@ include file="../components/header.jsp" %>      
   
</head>
<body>


   <!-- AD - includes the navbar component, into this page -->
   <%@ include file="../components/navbar.jsp" %> 

<!-- Check this later
<div class="container-nav1">

    <div class="container-nav3">
        <div class="container-nav4">
           
            <div class = "container-nav-links-icon">
            <a href="/adminPortal.jsp"><i class="material-icons resize3a">account_balance</i></a>              
            </div>
            <div class = "container-nav-links">
                <a href="#"><h5>About</h5></a>
            </div>
            <div class = "container-nav-links">
                <a href="/ShowQuestions"><h5>Questionnaire</h5></a>
            </div>
            <div class = "container-nav-links">
                <a href="/ShowCandidates"><h5>Candidates</h5></a>
            </div>
            <div class = "container-nav-links">

                <a href="/loginPage.jsp"><h5>Login</h5></a>

            </div>           
        </div>
    </div>
</div>
  -->

    <!-- AD - Beginning the central (yellow container)-->
    <div class="container">
        <i class="material-icons resize1">account_balance</i>
<%--           <%String name = (String) session.getAttribute("name");%> --%>
<%--         <h3>Welcome <%out.println(name); %></h3> --%>
        <h3>Welcome, you have successfully logged in! </h3> 

        
        <!-- AD - customises the welcome message-->
        <div class="container6"> 
          
        <h2>Homepage</h2>

        </div>
       
        <!-- AD - This container adds colourings and style to the intro message -->
        <div class="container5">
          <!-- AD - Election machine questions -->
          <h5>Welcome to our site! This election machine website is run by the 'Global Herald Newspaper',
              in association with the 'HAMK's Finest' server programming team. 
              Take our election machine questionnaire to find out which candidate 
              is the right election candidate for you!
          </h5>
        </div>

        <!-- AD - This container customises the 'please register' message-->
        <div class="container7">
          <h3>Please click the 'Take Quiz' button to start the questionnaire!</h3>
        </div>
    
        <hr>   

        <!-- AD - Beginning of the selection button section (answers)-->
        <div class="container2">           
            <!-- AD - A small container to amend the disclaimer background section-->
            <div class="container4">  
            
                <!-- AD - Questionnaire guidance for the user -->
		        <h5>DISCLAIMER: Neither the 'Global Herald Newspaper' or 'HAMK's Finest'
                are to be held liable for any views or comments expressed by the candidates 
                or users of this site. Your data is confidential and will not be shared or
                sold in any capacity. All rights reserved.</h5>
            
            </div>
		    
            <hr>      
    
            <!-- AD - A container for the login and registration buttons-->
            <div class="container3">

                <!-- AD - Buttons for login and registration-->

                <button class="button-main button1" onclick="window.location.href='/ShowQuestions'"><b>Take Quiz</b></button>
              
            </div>
        
        <!-- AD - End of the selection button section (answers)-->
        </div>

    <!-- AD - End of the central (yellow container)-->
    </div>
        
    <!-- AD - includes the footer component, into this page (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %>  

</body><!-- AD - End of body-->
</html><!-- AD - End of html-->