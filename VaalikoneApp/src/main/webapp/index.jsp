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

    <title>Welcome</title>
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
            padding: 0.5px 0px 0.5px 0px; 
            padding-left: 10px;
            color: rgba(255, 255, 255, 0.658);                    
        }

        /* AD - Customises the introduction colourings */
        .container5 {
            background-color:#2A9D8F;
            border-radius: 10px; 
            padding: 0.1px 0px 0.1px 0px; 
            padding-left: 10px;
            color: rgba(255, 255, 255, 0.658);                 
        }

        /* AD - Customises the Welcome message colourings */
        .container6 {
            background-color:#F4A261;
            border-radius: 10px; 
            padding: 0.1px 0px 0.1px 0px; 
            padding-left: 10px;
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
            padding: 10px 15px;
            text-align: center;
            text-decoration: none;
            display: inline-block;                      
            cursor: pointer;
            -webkit-transition-duration: 0.4s; /* Safari */
            transition-duration: 0.4s;
            border-radius: 10px;
            margin: 20px 10px 0px 10px;           
        }

        /* AD - Customises the button hover effects */
        
        /* visited link */
        .button1:visited {
        color: #2A9D8F;
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
        color: #2A9D8F;
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
        <h2>Welcome visitor!</h2>
        </div>
       
        <!-- AD - This container adds colourings and style to the intro message -->
        <div class="container5">
        <!-- AD - Election machine questions -->
        <h5>This election machine website is run by the Global News Newspaper,
            in association with the HÄMK'S Finest server programming team!
        </h5>
        </div>

        <h3>To use our innovative election machine, please register 
            an account below, before logging in.</h3>
    
        <hr>   

        <!-- AD - Beginning of the selection button section (answers)-->
        <div class="container2">           
            <!-- AD - A small container to amend the disclaimer background section-->
            <div class="container4">  
            
                <!-- AD - Questionnaire guidance for the user -->
		    <h5>DISCLAIMER: Neither the Global News Newspaper or HÄMK'S Finest
                are to be held liable for any views expressed by candidates or users
                of this site. Your data is confidential and will not be shared or
                sold in any capacity. All rights reserved.</h5>
            
            </div>
		    
            <hr>      
    
            <!-- AD - A container for the login and registration buttons-->
            <div class="container3">

                <!-- AD - Buttons for login and registration-->
                <button class="button-main button1"><b>REGISTER</b></button>
                
                <button class="button-main button1"><b>LOGIN</b></button>

            </div>
        
        <!-- AD - End of the selection button section (answers)-->
        </div>

    </div><!-- AD - End of the main election machine questionnaire (yellow container)-->


</body><!-- AD - End of body-->
</html><!-- AD - End of html-->