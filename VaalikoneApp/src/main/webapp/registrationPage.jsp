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
    
    <title>Registration Page</title>
   
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

    <div class = "container1">

        <div class = "container1c">          
            <h5>WELCOME</h5>     
            <i class="material-icons resize3">account_balance</i>  
            <h5>ELECTION MACHINE</h5>            
        </div>

        <div class = "container1b">
            <form action="RegistrationServlet" method="post">                                      
                    <legend><b>Site Registration </b></legend>
                    <hr> 
                    <table>                    
                    <tr><td><b>Username: </b></td><td><input type="text" name="uname"></td></tr>
                    <tr><td><b>Password: </b></td><td><input type="password" name="password"></td></tr>
                    <tr><td><b>Email: </b></td><td><input type="text" name="email"></td></tr>
                    <tr><td><b>Phone: </b></td><td><input type="text" name="phone"></td></tr>
                    <tr><td></td><td><input type="submit" value="REGISTER"></td></tr>
                    </table>
                    <hr>        
            </form> 
        </div>

        
    </div>
		
        

<!--         <h1> Login</h1> -->
<!--         <form action="login" method="post"> -->
<!--             <label for="email">Email:</label> -->
<!--             <input name="email" size="30" /> -->
<!--             <br><br> -->
<!--             <label for="password">Password:</label> -->
<!--             <input type="password" name="password" size="30" /> -->

    <!-- AD - This will be in the jsp file -->
<%--             <br>${message} --%>
 

<!--             <br><br>            -->
<!--             <button type="submit">Login</button> -->
<!--         </form> -->
    
   <!-- AD - This will be in the jsp file -->
<%--             <b>${user.fullname} (${user.email})</b> --%>


<!--         <br><br> -->
<!--         <a href="/logout">Logout</a> -->
    
<!--  <h1>Already registered?</h1> -->
<!-- <a href="login.html">Login</a> -->
<!-- <a href="LogoutServlet">Logout</a> -->
<!-- <a href="ProfileServlet">Profile</a> -->
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