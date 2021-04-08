<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>

    <%@ include file="../components/meta1.html" %>

    <title>Example Template</title>	
    
    <% include file="../components/header1.html" %>  

<!-- NOTE: If the page requires the use of AD's 
        Bootstrap-based code (such as the adminUpdateCandidates.jsp page),
        then the '../components/headerBootstrap.jsp' 
        file will need to be used instead of the above line. -->

<!-- Furthermore, if page to be included consists of dynamic elements
        then the <jsp:include> tag may need to be used as an alternative.
        (This does not seem to currently be an issue, however.) -->
   
</head>
<body>

   

    <h1>
    	This is simply an example template
        to demonstrate how to utilise the 'include' directive.
    </h1>

    

</body><!-- AD - End of body-->
</html><!-- AD - End of html-->