<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>
    
    <title>About</title>
    
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
        <h2>About</h2>
        </div>
       
        <!-- AD - This container adds colourings and style to the intro message -->
        <div class="container5">
        <!-- AD - Introductory statement about the candidates page -->
        <h5>This section covers the team of the 'Global Herald Newspaper' as well as
            the server programming team over at 'HAMK's Finest.'
            <br><br>
            Have a quick read to find out more
            about each team member. In particular, you can find out what aspects of the
            project each team member was primarily responsible for.
        </h5>
        </div>

        <!-- AD - This container customises the heading to the candidate overviews-->
        <div class="container7">
        <h3>Here, let's let the project participants introduce themselves:</h3>
        </div>
    
        <hr>   

        <!-- AD - Team intro colourings and text -->
        <div class="container8">
            <!-- AD - Intro / overview statement about the candidate -->
            <h5>The Global Herald Newspaper:
                <br><br>
                Greetings! Our motto: "Global News for a Global Era!"
                <br><br>
                <hr>
                <br>
                Overview: During this project, we are the (imaginary) 'Global Herald Newspaper' team! 
                We don't actually exist, yet with this scenario, we are the Newspaper that is supposedly
                running this Election Machine. Our aim is to help election voters get matched with the
                right candidate for them!
                <br><br>
                In order to create this Election Machine, we 'hired' the HAMK's Finest server programming team.
                This team is comprised of student server programmers from Hame University of 
                Applied Sciences, and they created this Election Machine using Java server-side programming.         
                <br><br>
                Read on to meet the server programming team!
            </h5>
        </div>

        <!-- AD - Team member 1 intro colourings and text -->
        <div class="container8">
            <!-- AD - Intro / overview statement about the candidate -->
            <h5>(HAMK's Finest) Team member 1:
                <br><br>
                Daniel Kovacs (Project Manager)
                <br><br>
                <hr>
                <br>
                Overview: This project was a very enjoyable project, 
                yet but it was certainly quite challenging.
                During this project, I was mainly responsible for...
                <br><br>
                sed do eiusmod tempor incididunt ut labore 
                et dolore magna aliqua. Ut enim ad minim veniam, 
                quis nostrud exercitation ullamco laboris nisi ut aliquip 
                ex ea commodo consequat. Duis aute irure dolor in reprehenderit 
                in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui 
                officia deserunt mollit anim id est laborum.
            </h5>
        </div>

        <!-- AD - Team member 2 intro colourings and text -->
        <div class="container8">
            <!-- AD - Intro / overview statement about the candidate -->
            <h5>(HAMK's Finest) Team member 2:
                <br><br>
                Les Heidrich (Server Programmer)
                <br><br>
                <hr>
                <br>
                Overview: Whilst challenging, this project was rewarding in the end!
                <br><br>
                I learned a lot from this project. Java servlets are 
                certainly challenging at first, but rewarding in the end. 
                I'm sure the database management skills I have acquired 
                will come in handy in my future endeavours. 
                My main contributions to the vaalikone project were 
                within the scope of DAO/CRUD and login related issues 
                where I had the chance to work with Evangelos. 
            </h5>
        </div>

        <!-- AD - Team member 3 intro colourings and text -->
        <div class="container8">
            <!-- AD - Intro / overview statement about the candidate -->
            <h5>(HAMK's Finest) Team member 3:
                <br><br>
                Ashley Davis (Server Programmer)
                <br><br>
                <hr>
                <br>
                Overview: Server cookies are tough cookies, but they're pretty tasty!
                <br><br>
                For most of our team, servlets, DAO, and cookies were completely 
                new topics to get to grips with. Nevertheless, with a bit of persistence 
                and determination, the team worked hard, and things fell into place. 
                During this project, my main contributions were towards the UI, 
                Scrum planning, as well as some of the application's 
                JavaScript 'dynamic' functionality. 
                Our team worked very well together, despite the project challenges, 
                and it was a real pleasure to be part of the team.
            </h5>
        </div>

        <!-- AD - Team member 4 intro colourings and text -->
        <div class="container8">
            <!-- AD - Intro / overview statement about the candidate -->
            <h5>(HAMK's Finest) Team member 4:
                <br><br>
                Evangelos Kaikas (Server Programmer)
                <br><br>
                <hr>
                <br>
                Overview: This project was a very enjoyable project, 
                yet but it was certainly quite challenging.
                During this project, I was mainly responsible for...
                <br><br>
                sed do eiusmod tempor incididunt ut labore 
                et dolore magna aliqua. Ut enim ad minim veniam, 
                quis nostrud exercitation ullamco laboris nisi ut aliquip 
                ex ea commodo consequat. Duis aute irure dolor in reprehenderit 
                in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui 
                officia deserunt mollit anim id est laborum.
            </h5>
        </div>

        <!-- End ot the candidate intro / overview section-->
        <hr>

        <!-- AD - Beginning of the selection button section (answers)-->
        <div class="container2">           
            <!-- AD - A small container to amend the disclaimer background section-->
            <div class="container5">  
            
                <!-- AD - Questionnaire guidance for the user -->
		    <h5>DISCLAIMER: Neither the 'Global Herald Newspaper' or 'HAMK's Finest'
                are to be held liable for any views or comments expressed by the candidates 
                or users of this site. Your data is confidential and will not be shared or
                sold in any capacity. All rights reserved.</h5>
            
            </div>
		    
            <hr>      
    
            <!-- AD - button container, containing buttons-->
            <div class="container3">
           
                <button class="button-main button1"><a href="../index.jsp"><b>Home</b></a></button>
                
                <button class="button-main button1" onclick="window.location.href='/ShowQuestions'"><b>Take Quiz</b></button>               

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