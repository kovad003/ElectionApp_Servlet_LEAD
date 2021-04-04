<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- allows for the use of special 'materialize' icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    <title>Election Machine</title>
    <style>
        @media only screen and (max-width: 900px) {
            .container {
            max-width: 80% !important;
        }
        /* Corrects an issue with the selection buttons
        not centering on mobile view */
        .labels-radio {
            display: inline-block;
            width: 20% !important;
            text-align: right;
        }
    }
        /*
        Notes about how to use the 'materialize icons' and their sizes.
        <!--
        Sizes:
        tiny: 1rem
        small: 2rem
        medium: 4rem
        large: 6rem
        NOTE: To control the size of the icon, change the 
        font-size: 30px property of your icon. 
        Optionally you can use preset classes as shown below.
        Here are some good one:
        account_balance
        beenhere
        equalizer
        local_post_office
        -->
        <i class="large material-icons">insert_chart</i>
        */
    html {
        font-family: sans-serif;
      }
        body{
            background-color: #2A9D8F;
            color: #264653;
        }
        .container{
            
            max-width: 50%;
            padding: 30px;
            border-radius: 10px;
         
            background-color: #E9C46A;
            box-shadow: 0 2px 16px 2px #264653; /*Adds a dark shadow */            
           
            margin: 90px auto;
            /*
            box-shadow: 0 2px 16px 2px rgba(0, 0, 0, .05);
            max-width: 600px;
             align-content: center;
            margin-top: 100px;
            */
        }
        .container2 {
            text-align: center;
            margin: 20px auto;
        }
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
            margin-top: 30px;
            /*
            padding: 15px 32px;
            font-size: 16px;
            margin: 4px 2px;
            */
        }
        .button1:hover {
            box-shadow: 0 12px 16px 0 rgba(0,0,0,0.24),0 17px 50px 0 rgba(0,0,0,0.19);
        }
           
        .labels-radio {
            display: inline-block;
            width: 35%;
            text-align: right;
            color: #E76F51;
        }
    
        .input-radio {
            display: inline-block;           
            text-align: left;
            width: 55%;
            color: #2A9D8F;
        }
 
        .resize1 {
            font-size: 40px
          
        }
        .resize2 {
            font-size: 50px
        }
        h2 {
            color: #E76F51;
        }
      
        
    </style>
</head>
<body>
<i class="material-icons resize2">account_balance</i>
	<!-- ========================================================================================================================================== -->
    <div class="container">
	    <i class="material-icons resize1">account_balance</i>
	        <h2>Election Machine</h2>
	       
	        <h5>NOTE: This election machine contains 19 questions.
	         Answer them all to find out which candidate suits you best!</h5>
	        <h3>Q1) Statement: I believe that the government 
	            should do more for the environment.</h3>
	            <%=(String)request.getAttribute("user_answer")%>
	    
	        <hr>
		        <form id="form" action="/SurveyServlet" method="POST">
			        <div class="container2">
			        	<!-- ******************************************************************************************************** -->
			            <div class="labels-radio">
			                <b>Select:</b>
			            </div>
			            <!-- ******************************************************************************************************** -->
			            <div class="input-radio">
			            <label> <b>(1)</b>
			            <input type = "radio" name = "select"  value="1">
			            </label>
			            <label> <b>(2)</b>
			            <input type = "radio" name = "select" value = "2">
			            </label>
			            <label> <b>(3)</b>
			            <input type = "radio" name = "select" value = "3">
			            </label>
			            <label> <b>(4)</b>
			            <input type = "radio" name = "select" value = "4">
			            </label>
			            <label> <b>(5)</b>
			            <input type = "radio" name = "select" value = "5">
			            </label>
			            </div>
			             <!-- ******************************************************************************************************** -->
			            <h5>1 = strongly disagree / 2 = disagree / 3 = neither agree nor disagree / 4 = agree / 5 = strongly agree</h5>
			             <!-- ******************************************************************************************************** -->
	        		</div>
		        		<button class="button-main button1" type="submit"><b>NEXT</b></button>
	        	</form>	
    		<hr>
    </div>
    <!-- ========================================================================================================================================== -->
    
</body>
</html>
