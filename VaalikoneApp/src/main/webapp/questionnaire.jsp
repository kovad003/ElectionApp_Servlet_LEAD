
   
<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.Question" %>   
<%@ page import="data.Answer" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html lang="en">
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>
    
    <title>Questionnaire</title>
    
    <!-- AD - includes the header component, into this page -->
    <%@ include file="../components/header.jsp" %>     
    
</head>
<body>

<!-- AD - includes the navbar component, into this page -->
   <%@ include file="../components/navbar.jsp" %> 

    <!-- AD - Beginning the central (yellow container)-->
    <div class="container">
        <i class="material-icons resize1">account_balance</i>
        
        <!-- AD - customises the welcome message-->
        <div class="container6"> 
        <h2>Election Machine</h2>

        <!-- AD - Election machine questions -->
        <h5>NOTE: This election machine contains 19 questions.
            Answer them all to find out which candidate suits you best!</h5>

        </div>
       
        <!-- AD - This container adds colourings and style to the intro message -->
        <div class="container5">

        <!-- AD - Election machine questions -->
        <h3>Q1) Statement: I believe that the government 
            should do more for the environment.</h3>

        </div>        
    
        <hr>   

        <!-- AD - Beginning of the selection button section (answers)-->
        <div class="container2">           
            <!-- AD - A small container to amend the disclaimer background section-->
            <div class="container4">  
            
                <!-- AD - Beginning of the section with 5 selection buttons-->
                <div class="input-radio">

                    <form id="form" action="/SubmitAnswer" method="POST">
			             <!-- ******************************************************************************************************** -->
			            <h5>1 = strongly disagree / 2 = disagree / 3 = neither agree nor disagree / 4 = agree / 5 = strongly agree</h5>
			             <!-- ******************************************************************************************************** -->
					    <c:forEach begin="0" end="18" var="question" items="${requestScope.questionlist}" >
					    <h3><c:out value = "${question.id}) ${question.question}"/></h3> <!-- Display question -->
					    <div class="container2">

			        	<!-- ******************************************************************************************************** -->
			            <div class="labels-radio">
			                <b>Select:</b>
			            </div>
			            <!-- ******************************************************************************************************** -->
			            <div class="input-radio">
			            <!-- Display Radio buttons -->
			            <label> <b>(1)</b>
			            <input type = "radio" name = "select${question.id}"  value="1">
			            </label>
			            <label> <b>(2)</b>
			            <input type = "radio" name = "select${question.id}" value = "2">
			            </label>
			            <label> <b>(3)</b>
			            <input type = "radio" name = "select${question.id}" value = "3">
			            </label>
			            <label> <b>(4)</b>
			            <input type = "radio" name = "select${question.id}" value = "4">
			            </label>
			            <label> <b>(5)</b>
			            <input type = "radio" name = "select${question.id}" value = "5">
			            </label>
			            </div>
	        		</div>
	        		</c:forEach>
		        		<button class="button-main button1" type="submit"><b>NEXT</b></button>
	        	</form>	
        
                </div>
            
            </div>

            <!-- AD - Questionnaire guidance for the user -->
            <div class="container7a">             
		    <h5>1 = strongly disagree / 2 = disagree / 3 = neither agree nor disagree / 4 = agree / 5 = strongly agree</h5>
            </div>
		    
            <hr>      
    
            <!-- AD - A container for the login and registration buttons-->
            <div class="container3">

                <!-- AD - Buttons for login and registration-->
                <button class="button-main button1"><b>PREVIOUS</b></button>
                
                <button class="button-main button1"><b>NEXT</b></button>

            </div>
        
        <!-- AD - End of the selection button section (answers)-->
        </div>

	<!-- AD - End of the central (yellow container)-->
    </div>

	<!-- AD - includes the footer component into this page 
    (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %>
	
</body><!-- AD - End of body-->
</html><!-- AD - End of html-->