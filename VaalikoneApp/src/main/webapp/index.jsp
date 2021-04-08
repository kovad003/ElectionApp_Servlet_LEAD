<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<!-- AD - This line might potentially be necessary later on 
	<meta charset="ISO-8859-1">
	-->
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- AD - allows for the use of special 'materialize' icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <!-- AD - links to the election machine external css file-->
    <link href="../css/style.css" rel="stylesheet">       

    <title>Homepage</title>
   
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
                <a href="#"><h5>About</h5></a>
            </div>
            <div class = "container-nav-links">
                <a href="#"><h5>Questionnaire</h5></a>
            </div>
            <div class = "container-nav-links">
                <a href="#"><h5>Candidates</h5></a>
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
          <%String name = (String) session.getAttribute("name");%>
        <h3>Welcome <%out.println(name); %></h3>

        
        <!-- AD - customises the welcome message-->
        <div class="container6"> 
        <h2>Homepage</h2>
        
        </div>
       
        <!-- AD - This container adds colourings and style to the intro message -->
        <div class="container5">
        <!-- AD - Election machine questions -->
        <h5>Welcome to our site! This election machine website is run by the 'Global Herald Newspaper',
            in association with the 'HÄMK's Finest' server programming team. Sign up
            to find out which candidate is right for you!
        </h5>
        </div>

        <!-- AD - This container customises the 'please register' message-->
        <div class="container7">
        <h3>To try out our innovative election machine, please click the 
          'Take Quiz' button down below!</h3>
        </div>
    
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
                <button class="button-main button1"><b>Take Quiz</b></button>              

            </div>
        
        <!-- AD - End of the selection button section (answers)-->
        </div>

    <!-- AD - End of the central (yellow container)-->
    </div>

</body><!-- AD - End of body-->
</html><!-- AD - End of html-->