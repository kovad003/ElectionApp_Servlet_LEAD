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

    <script
    src="https://code.jquery.com/jquery-3.4.1.min.js"
    integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
    crossorigin="anonymous">
    </script>

    <script type="text/javascript" 
    src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>
   
    <!-- allows for the use of special 'materialize' icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

    <!-- AD - links to the election machine external css file-->
    <link href="../css/style.css" rel="stylesheet"> 
    
    <title>Login Page</title>
   
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
                    <a href="#"><h5>Login</h5></a>
                </div>               
            </div>
        </div>
    </div>   

    <!-- AD - Welcome message inside the Login Section-->
    <div class = "container1">

        <div class = "container1c">          
            <h5>WELCOME</h5>     
            <i class="material-icons resize3">account_balance</i>  
            <h5>ELECTION MACHINE</h5>            
        </div>

        <!-- AD - Login Section-->
        <div class = "container1b">
            <form action="loginServlet" method="post">      
                <legend><b>Site Login </b></legend>
                <table>
                    <hr> 
                    <tr>
                        <td><b>Email: </b></td>
                        <td><input type="email" name="username" required="required" /></td>
                    </tr>
                    <tr>
                        <td><b>Password: </b></td>
                        <td><input type="password" name="userpass" required="required" /></td>
                    </tr>                    
                    <tr>                        
                        <td><br><input type="submit" value="LOGIN" /></td>
                    </tr>
                </table>
                <hr>        
        </form> 
        </div>

        
    </div>
 
</body>

<script type="text/javascript">
 
    $(document).ready(function() {
        $("#loginForm").validate({
            rules: {
                email: {
                    required: true,
                    email: true
                },
         
                password: "required",
            },
             
            messages: {
                email: {
                    required: "Please enter email",
                    email: "Please enter a valid email address"
                },
                 
                password: "Please enter password"
            }
        });
 
    });
</script>

</html>