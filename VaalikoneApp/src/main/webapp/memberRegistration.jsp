<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>
<script type="text/javascript"
    src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Election App</title>
</head>
<body>
		<form  action="RegistrationServlet" method="post">
		 <h1>Please Register</h1>
		<table>
		<tr><td>User Name: </td><td><input type="text" name="uname"></td></tr>
		<tr><td>Password: </td><td><input type="password" name="password"></td></tr>
		<tr><td>Email: </td><td><input type="text" name="email"></td></tr>
		<tr><td>phone: </td><td><input type="text" name="phone"></td></tr>
		<tr><td></td><td><input type="submit" value="register"></td></tr>
		</table>
		</form>
		
		<form action="loginServlet" method="post">
		<fieldset style="width: 300px">
			<legend> Login to App </legend>
			<table>
				<tr>
					<td>email</td>
					<td><input type="email" name="username" required="required" /></td>
				</tr>
				<tr>
					<td>Password</td>
					<td><input type="password" name="userpass" required="required" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Login" /></td>
				</tr>
			</table>
		</fieldset>
	</form>

    
<!--         <h1> Login</h1> -->
<!--         <form action="login" method="post"> -->
<!--             <label for="email">Email:</label> -->
<!--             <input name="email" size="30" /> -->
<!--             <br><br> -->
<!--             <label for="password">Password:</label> -->
<!--             <input type="password" name="password" size="30" /> -->
<%--             <br>${message} --%>
<!--             <br><br>            -->
<!--             <button type="submit">Login</button> -->
<!--         </form> -->
    
    
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