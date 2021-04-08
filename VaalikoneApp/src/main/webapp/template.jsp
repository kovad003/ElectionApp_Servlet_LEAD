<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>

    <title>Example Template</title>	
    
    <!-- AD - includes the header component, into this page -->
    <%@ include file="../components/header.jsp" %>  

<!-- NOTE: If the page requires the use of AD's 
        Bootstrap-based code (such as the adminUpdateCandidates.jsp page),
        then the '../components/headerBootstrap.jsp' 
        file will need to be used instead of the above line. -->

<!-- Furthermore, if page to be included consists of dynamic elements
        then the 'jsp include' tag may need to be used as an alternative.
        (This does not seem to currently be an issue, however.) -->
   
</head>
<body>

   <!-- AD - includes the navbar component, into this page -->
   <%@ include file="../components/navbar.jsp" %> 

<div class = "container1">
    <h1>
    	This is simply an example template
        to demonstrate how to utilise the 'include' directive.
    </h1>
</div>

    <!-- AD - includes the footer component, into this page -->
	<%@ include file="../components/footer.jsp" %>    

</body><!-- AD - End of body-->
</html><!-- AD - End of html-->