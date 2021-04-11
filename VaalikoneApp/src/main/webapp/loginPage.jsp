<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>
    
    <title>Login Page</title>

    <!-- AD - includes the headerScript component, into this page -->
    <%@ include file="../components/headerScript.jsp" %> 
   
</head>

<body>


   <!-- AD - includes the navbar component, into this page -->
   <%@ include file="../components/navbar.jsp" %>  

    <!-- AD - Welcome message inside the Login Section-->
    <div class = "container1">

        <div class = "container1c">          
            <h5>WELCOME</h5>     
            <i class="material-icons resize3">account_balance</i>  
            <h5>ELECTION MACHINE</h5>            
        </div>

        <!-- AD - Login Section-->
        <div class = "container1b">
            <form action="LoginServlet" method="post">      
                <legend><b>Site Login </b></legend>
                <table>
                    <hr> 
                    <tr>
                        <td><b>Username: </b></td>
                        <td><input type="text" name="user" required="required" /></td>
                    </tr>
                    <tr>
                        <td><b>Password: </b></td>
                        <td><input type="password" name="pwd" required="required" /></td>
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



    <!-- AD - includes the footer component into this page 
    (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %> 

</html>