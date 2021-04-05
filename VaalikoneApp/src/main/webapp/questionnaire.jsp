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
    
    <!-- allows for the use of special 'materialize' icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <!-- AD - links to the election machine external css file-->
    <link href="../css/style.css" rel="stylesheet">   

    <title>Questionnaire</title>
    
</head>
<body>

<!-- AD - customises the navbar-->
<div class="container-nav1">
<!--
    <div class="container-nav2">
       
        <i class="material-icons resize2">account_balance</i>
    </div>
-->

    <div class="container-nav3">
        <div class="container-nav4">
          
                  <!-- AD - icon customisation -->
                <div class = "container-nav-links-icon">
                <i class="material-icons resize3">account_balance</i>              
                </div>
                <div class = "container-nav-links">
                  <a href="#"><h5>Register</h5></a>
                </div>
                <div class = "container-nav-links">
                  <a href="#"><h5>Login</h5></a>
                </div>
                <div class = "container-nav-links">
                  <a href="#"><h5>Candidates</h5></a>
                </div>
                <div class = "container-nav-links">
                  <a href="#"><h5>About</h5></a>
                </div>           
            
        </div>
    </div>
</div>

    <!-- AD - Beginning the central (yellow container)-->
    <div class="container">
        <i class="material-icons resize1">account_balance</i>
        
        <!-- AD - customises the welcome message-->
        <div class="container6"> 
        <h2>Election Machine</h2>

        <!-- AD - Election machine questions -->
        <h5>NOTE: This election machine contains 19 questions.
            Answer them all to find out which candidate suits you best!</h5>

        </div>
       
        <!-- AD - This container adds colourings and style to the intro message -->
        <div class="container5">

        <!-- AD - Election machine questions -->
        <h3>Q1) Statement: I believe that the government 
            should do more for the environment.</h3>

        </div>        
    
        <hr>   

        <!-- AD - Beginning of the selection button section (answers)-->
        <div class="container2">           
            <!-- AD - A small container to amend the disclaimer background section-->
            <div class="container4">  
            
                <!-- AD - Beginning of the section with 5 selection buttons-->
                <div class="input-radio">

                    <!-- AD - The 5 selection buttons, for choosing the answers-->
                    <label>
                        <b style = "color:#E9C46A">
                        SELECT :</b>
                    </label>
                    <label><b>(1)</b>
                    <input type = "radio" name = "select">
                    </label>
                    <label><b>(2)</b>
                    <input type = "radio" name = "select">
                    </label>
                    <label><b>(3)</b>
                    <input type = "radio" name = "select">
                    </label>
                    <label><b>(4)</b>
                    <input type = "radio" name = "select">
                    </label>
                    <label><b>(5)</b>
                    <input type = "radio" name = "select">
                    </label>
        
                </div>
            
            </div>

            <!-- AD - Questionnaire guidance for the user -->
            <div class="container7a">             
		    <h5>1 = strongly disagree / 2 = disagree / 3 = neither agree nor disagree / 4 = agree / 5 = strongly agree</h5>
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

	<!-- AD - End the central (yellow container)-->
    </div>


</body><!-- AD - End of body-->
</html><!-- AD - End of html-->