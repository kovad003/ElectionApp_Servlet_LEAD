<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

    <!-- AD - This file is a 'navbar' page component, which is to 
              be included on all pages. -->

    <!-- AD - customises the navbar-->
    <div class="container-nav1">

        <div class="container-nav3">
            <div class="container-nav4">
                <!-- AD - icon customisation -->
                <div class = "container-nav-links-icon">
                <a href="../adminPortal.jsp"><i class="material-icons resize3a">account_balance</i></a>              
                </div>
                <div class = "container-nav-links">
                    <a href="../about.jsp"><h5>About</h5></a>
                </div>
                <div class = "container-nav-links">
                    <a href="../ShowQuestions"><h5>Questionnaire</h5></a>
                </div>
                <div class = "container-nav-links">
                    <a href="../ShowCandidates"><h5>Candidates</h5></a>
                </div>
                <div class = "container-nav-links">
                    <a href="../loginPage.jsp"><h5>Login</h5></a>
                </div>           
            </div>
        </div>
        
    </div>
    

<% 
// init empty vars
String id = null;

// grab loginCookie info
Cookie[] login = request.getCookies();
if(login !=null){
for(Cookie i : login){
/*
* LoginServlet: loginCookie -> userName
*/
if(i.getName().equals("user")) id = i.getValue();
}
}
//AD - If there is an ID showing up, then it gives you a logout button.
if (id!=null) {
%>

<!-- logs out -->
<form action="LogoutServlet" method="post">
<input type="submit" value="Logout" >
</form>

<%
}
else {
	// AD - if you don't have an ID showing up, then it gives you a login button.
	%>
	<table>
	<tr>
	 <td><br><input type="submit" value="LOGIN" /></td>
	 </tr>
     </table>
     <%
}
%>
