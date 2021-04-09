<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>
    
    <title>Registration Page</title>
   
    <!-- AD - includes the headerScript component, into this page -->
    <%@ include file="../components/headerScript.jsp" %>     
   
</head>

<body>

   <!-- AD - includes the navbar component, into this page -->
   <%@ include file="../components/navbar.jsp" %>    

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

    <!-- AD - includes the footer component into this page 
    (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %>

</html>