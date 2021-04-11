<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>

	<title>Admin Portal</title>

    <!-- AD - includes the header component, into this page -->
    <%@ include file="../components/header.jsp" %>     

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

        <!-- AD - Configures the Admin Portal -->
        <div class = "containerAdminPortal">
            <form action="RegistrationServlet" method="post">                                      
                    <legend class = "adminPortal2"><b>ADMIN: Site Architecture </b></legend>
                    <hr>
                    <legend class = "adminPortal3"><b>MENU: </b></legend>
                    <hr>  
                    <table>                    
					<tr><td><b class = "adminPortal4">Access:</b><a href="/index.jsp" target="_blank"> <u><b>index.jsp </b></u></a></td></tr>
                    <tr><td><b class = "adminPortal4">Access:</b><a href="/about.jsp" target="_blank"> <u><b>about.jsp </b></u></a></td></tr>
                    <tr><td><b class = "adminPortal4">Access:</b><a href="/candidates.jsp" target="_blank"> <u><b>candidates.jsp </b></u></a></td></tr>
                    <tr><td><b class = "adminPortal4">Access:</b><a href="/login.jsp" target="_blank"> <u><b>login.jsp </b></u></a></td></tr>
                    <tr><td><b class = "adminPortal4">Access:</b><a href="/adminUpdateCandidates.jsp" target="_blank"> <u><b>adminUpdateCandidates.jsp </b></u></a></td></tr>
                    <tr><td><b class = "adminPortal4">Access:</b><a href="/registrationPage.jsp" target="_blank"> <u><b>registrationPage.jsp </b></u></a></td></tr>
                    <tr><td><b class = "adminPortal4">Access:</b><a href="/candidates.jsp" target="_blank"> <u><b>candidates.jsp </b></u></a></td></tr>
                    <tr><td><b class = "adminPortal4">Access:</b><a href="/AdminCandidates" target="_blank"> <u><b>Candidate Data </b></u></a></td></tr>                     
                    <tr><td></td><td><br><input type="submit" value="LOGOUT"></td></tr>
                    </table>
                    <hr>        
            </form> 
        </div>        
    </div>
    
    <!-- AD - includes the footer component into this page 
    (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %>

</body>
</html>