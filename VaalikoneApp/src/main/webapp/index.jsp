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

    <title>Election Machine</title>
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
	    }  

        /*Adjustments for a responsive website*/
        /* Small devices (landscape phones, 544px and up) */
        /*1rem = 16px*/
        @media (max-width: 544px) {            
            h2{font-size: 1.25rem;}
            h3{font-size: 1rem;}
            h5{font-size: 0.75rem;}        
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
            margin: 60px auto 60px auto;                
        }

        /* AD - Customises the selection button section (answers) */
        .container2 {
            text-align: center;
            margin: 30px auto 10px auto;
        }

        /* AD - Customises the main button (to progress to the next question) */
        .button-main {
            background-color: #E76F51;
            border: none;
            color: white;
            padding: 10px 15px;
            text-align: center;
            text-decoration: none;
            display: inline-block;                      
            cursor: pointer;
            -webkit-transition-duration: 0.4s; /* Safari */
            transition-duration: 0.4s;
            border-radius: 10px; 
            margin-top: 20px;           
        }

        /* AD - Customises the button hover effects */
        .button1:hover {
            box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
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

        /* AD - heading customisation */
        h2 {
            color: #E76F51;
        }
              
    </style>
</head>
<body>

<!-- AD - icon customisation -->
<i class="material-icons resize2">account_balance</i>

    <!-- AD - Beginning of the main election machine questionnaire (yellow container)-->
    <div class="container">
        <i class="material-icons resize1">account_balance</i>
        <h2>Election Machine</h2>
       
        <!-- AD - Election machine questions -->
        <h5>NOTE: This election machine contains 19 questions.
         Answer them all to find out which candidate suits you best!</h5>

        <h3>Q1) Statement: I believe that the government 
            should do more for the environment.</h3>
    
        <hr>   

        <!-- AD - Beginning of the selection button section (answers)-->
        <div class="container2">
            
            <!-- AD - Beginning of the section with 5 selection buttons-->
            <div class="input-radio">

            <label><b style = "color:#E76F51;">Select:</b>
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

            <!-- AD - Beginning of the section with 5 selection buttons-->
        	</div>
         
            <!-- AD - Questionnaire guidance for the user -->
		    <h5>1 = strongly disagree / 2 = disagree / 3 = neither agree nor disagree / 4 = agree / 5 = strongly agree</h5>
		
		    <hr>      
    
            <!-- AD - The main button to progress to the next question-->
     		<button class="button-main button1"><b>NEXT</b></button>
        
        <!-- AD - End of the selection button section (answers)-->
        </div>

    </div><!-- AD - End of the main election machine questionnaire (yellow container)-->


</body><!-- AD - End of body-->
</html><!-- AD - End of html-->