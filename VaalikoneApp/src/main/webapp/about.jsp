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

    <title>About</title>
    <style>

		/* AD - Media query in respect of smaller screens.
                Ensures that the election machine looks good
                on all devices (eg from laptops all the down to iphone5/SE ) */
        @media only screen and (max-width: 900px) {
            .container {
            max-width: 80% !important;
            }

            .input-radio {
            font-size: small;
            width: 110% !important;
            }  

            /* AD - Customises the navbar for smaller screens */
            .container-nav1 {                           
                width: 97% !important;                                    
            }          
	    }  

        /*Adjustments for a responsive website*/
        /* Small devices (landscape phones, 544px and up) */
        /*1rem = 16px*/
        @media (max-width: 544px) {            
            h2{font-size: 1.25rem;}
            h3{font-size: 1rem;}
            h5{font-size: 0.6rem;}        
        }
        
        /* Medium devices (tablets, 768px and up) */
        /*1rem = 16px*/
        @media (min-width: 768px) {             
            h2{font-size: 1.75rem;}
            h3{font-size: 1.25rem;}
            h5{font-size: 1rem;}
        }
        
        /* Large devices (desktops, 992px and up) */
        /*1rem = 16px*/
        @media (min-width: 992px) { 
            h2{font-size: 2rem;}
            h3{font-size: 1.5rem;} 
            h5{font-size: 1rem;}
        }

        /* AD - Defines font size for the html page */
	    html {
	        font-family: sans-serif;
	      }

        /* AD - Customises the body colourings */
        body{
            background-color: #2A9D8F;
            color: #264653;
        }

        /* AD - Customises the main election machine questionnaire (yellow container) */
        .container{            
            max-width: 50%;
            padding: 30px;
            border-radius: 10px;         
            background-color: #E9C46A;
            box-shadow: 0 2px 16px 2px #264653;         
            margin: 25px auto 60px auto;                
        }

        /* AD - Customises the selection button section (answers) */
        .container2 {
            text-align: left;
            margin: 10px auto 10px auto;            
        }

        /* AD - Customises the registration and login links */
        .container3 {
            text-align: center;                              
        }

        /* AD - Customises the disclaimer colourings */
        .container4 {
            background-color:#264653;
            border-radius: 10px; 
            padding: 0.1px 10px 0.1px 10px;  
            color: rgba(255, 255, 255, 0.658);                    
        }

        /* AD - Customises the introduction colourings on the welcome page
                and in addition, the candidate page introductory message */
        .container5 {
            background-color:#2A9D8F;
            border-radius: 10px; 
            padding: 0.1px 10px 0.1px 10px;             
            color: rgba(255, 255, 255, 0.658);                 
        }

        /* AD - Customises the Welcome message colourings */
        .container6 {
            background-color:#F4A261;
            border-radius: 10px; 
            padding: 0.1px 10px 0.1px 10px;  
            margin: 10px auto;                                   
        }

        /* AD - Customises the 'please register an account' message */
        .container7 {          
            padding: 0.1px 10px 0.1px 10px;              
            color:#264653;                 
        }

        /* AD - Customises the candidate overviews */
                .container8 {
            /* AD - This is a lighter shade of green and a darker shade of text */
            background-color:#2a9d909f;
            border-radius: 10px; 
            padding: 0.1px 10px 0.1px 10px;             
            color: rgba(255, 255, 255, 0.856);
            margin: 10px auto;                
        }

        /* AD - Customises the navbar */
        .container-nav1 {
            background-color:#2A9D8F;
            border-radius: 10px; 
            padding: 1px;         
            margin: 1px auto;  

            display: flex;
            justify-content: center;             
            width: 90%;
            height: 40px;                       
        }

        /* AD - Customises the navbar
        .container-nav2 {
            background-color: #E9C46A;
            border-radius: 10px; 
            padding: 1px;         
            margin: 1px;  

            width: 30%;                       
        }
        */

        /* AD - Customises the navbar */
        .container-nav3 {
            background-color:#2A9D8F;
            border-radius: 10px; 
            padding: 1px;         
            margin: 1px;           
            width: 100%;  

            display: flex;
            justify-content: center;                    
        }

        /* AD - Customises the container inside the navbar */
        .container-nav4 {
            background-color:#2A9D8F;
            border-radius: 10px; 
            padding: 1px;         
            margin: 1px;            
            width: 100%; 

            display: flex;
            justify-content: center;                               
        }

        .container-nav-links {
            background-color: #E9C46A;
            border-radius: 10px; 
            padding: 1px;         
            margin: 4px;              
            width: 80%;             
            overflow: auto;
            overflow-x: hidden;
            overflow-y: hidden;
            justify-content: center;
            display: flex;
            align-items: center; 

            box-shadow: 0 2px 16px 2px #264653;                                      
        }

        .container-nav-links-icon {
            
            border-radius: 10px; 
            padding: 1px;         
            margin: 4px;             
            width: 80%; 

            display: flex;
            overflow: auto;
            overflow-x: hidden;
            overflow-y: hidden;
            justify-content: center;  
            align-items: center;   

            box-shadow: 0 2px 16px 2px #264653;                             
        }

        /* AD - Customises the main button (to progress to the next question) */
        .button-main {
            background-color: #E76F51;
            border: none;
            color: rgba(255, 255, 255, 0.829); 
            padding: 10px;
            text-align: center;
            text-decoration: none;
            display: inline-block;                      
            cursor: pointer;
            -webkit-transition-duration: 0.4s; /* Safari */
            transition-duration: 0.4s;
            border-radius: 10px;
            margin: 20px 10px 0px 10px; 
            width: 90px;          
        }

        /* AD - Customises the button hover effects */
        
        /* visited link */
        .button1:visited {
        color: #264653;
        text-decoration: none;
        }

        /* mouse over link */
        .button1:hover {
        color: #264653;
        text-decoration: none;
        box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
        }

        /* selected link */
        .button1:active {
        color: #2A9D8F;
        text-decoration: none;
        }      
           
        /* AD - Customises the questionnaire selection buttons (answers) */
        .input-radio {
            display: inline-block;           
            text-align: center;
            width: 100%;
            color: #2A9D8F;
            margin: 10px auto;
        }
 
        /* AD - font customisation */
        .resize1 {
            font-size: 40px;          
        }

        /* AD - font customisation */
        .resize2 {
            font-size: 50px;
        }

        /* AD - font customisation */
        .resize3 {
            font-size: 25px;          
        }

        /* AD - heading customisation */
        h2 {
            color: rgba(255, 255, 255, 0.829);  
        }

        /* AD - customisation the navbar links */
         /* unvisited link */
        a:link {
        color: #264653;
        text-decoration: none;
        }

        /* visited link */
        a:visited {
        color: #264653;
        text-decoration: none;
        }

        /* mouse over link */
        a:hover {
        color: white;
        text-decoration: none;
        }

        /* selected link */
        a:active {
        color: #2A9D8F;
        text-decoration: none;
        } 
              
    </style>
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

    <!-- AD - Beginning of the main election machine questionnaire (yellow container)-->
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
            the server programming team over at 'H�MK's Finest.'
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
                Overview: During this project, we are the (imaginary) 'Global Herald Newspaper' team! 
                We don't actually exist, yet with this scenario, we are the Newspaper that is supposedly
                running this Election Machine. Our aim is to help election voters get matched with the
                right candidate for them!
                <br><br>
                In order to create this Election Machine, we 'hired' the H�MK's Finest server programming team.
                This team is comprised of student server programmers from H�MK polytechnic university, and
                they created this Election Machine using Java server-side programming.         
                <br><br>
                Read on to meet the server programming team!
            </h5>
        </div>

        <!-- AD - Team member 1 intro colourings and text -->
        <div class="container8">
            <!-- AD - Intro / overview statement about the candidate -->
            <h5>(H�MK's Finest) Team member 1:
                <br><br>
                Daniel Kovacs (Project Manager)
                <br><br>
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
            <h5>(H�MK's Finest) Team member 2:
                <br><br>
                Les Heidrich (Server Programmer)
                <br><br>
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

        <!-- AD - Team member 3 intro colourings and text -->
        <div class="container8">
            <!-- AD - Intro / overview statement about the candidate -->
            <h5>(H�MK's Finest) Team member 3:
                <br><br>
                Ashley Davis (Server Programmer)
                <br><br>
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

        <!-- AD - Team member 4 intro colourings and text -->
        <div class="container8">
            <!-- AD - Intro / overview statement about the candidate -->
            <h5>(H�MK's Finest) Team member 4:
                <br><br>
                Evangelos Kaikas (Server Programmer)
                <br><br>
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
            <div class="container4">  
            
                <!-- AD - Questionnaire guidance for the user -->
		    <h5>DISCLAIMER: Neither the 'Global Herald Newspaper' or 'H�MK's Finest'
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

    </div><!-- AD - End of the main election machine questionnaire (yellow container)-->


</body><!-- AD - End of body-->
</html><!-- AD - End of html-->