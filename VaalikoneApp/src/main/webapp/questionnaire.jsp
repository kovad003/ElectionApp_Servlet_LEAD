
   
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
 

    <!-- AD - Beginning of the main yellow container-->
    <div class="container">
        <i class="material-icons resize1">account_balance</i>
        
        <!-- AD - customises the welcome message-->
        <div class="container6"> 
            <h2>Election Machine</h2>
            <!-- AD - Election machine questions -->
            <h5>NOTE: This election machine contains 19 questions.
                Answer them all to find out which candidate suits you best!</h5>
        </div>

        <!-- AD - A small container to amend the disclaimer background section-->
        <div class="container4a">  
            
            <!-- AD - Questionnaire guidance for the user -->
            <h5>DISCLAIMER: Neither the 'Global Herald Newspaper' or 'H�MK's Finest'
            are to be held liable for any views or comments expressed by the candidates 
            or users of this site. Your data is confidential and will not be shared or
            sold in any capacity. All rights reserved.</h5>
        
        </div>       
       
        <hr> 
        
        <!-- AD - Questionnaire guidance for the user -->
        <div class="container7a">             
            <h5>1 = strongly disagree / 2 = disagree / 3 = neither agree nor disagree / 4 = agree / 5 = strongly agree</h5>
        </div>

        <hr>     
        
        
        <!-- AD - Delete this later
         <ul id="questionsContainer">
            <div id="q1">
                  <li style="display:list-item">
                      <h3>Q1) What is the answer to question 1? </h3>
                      <input type="radio" name="q1" value="1"/>1<br/>
                      <input type="radio" name="q1" value="2"/>2<br/>
                      <input type="radio" name="q1" value="3"/>3<br/>
                      <input type="radio" name="q1" value="4"/>4<br/>
                      <input type="radio" name="q1" value="4"/>5<br/>
                  </li>
                </div>
            
                <div id="q2"  >
                  <li style="display:none">
                    <h3>Q2) What is the answer to question 2? </h3>
                    <input type="radio" name="q2" value="1"/>1<br/>
                    <input type="radio" name="q2" value="2"/>2<br/>
                    <input type="radio" name="q2" value="3"/>3<br/>
                    <input type="radio" name="q2" value="4"/>4<br/>
                    <input type="radio" name="q2" value="4"/>5<br/>
                  </li>
                </div>

                <div id="q3" >
                  <li  style="display:none">
                    <h3>Q3) What is the answer to question 3? </h3>
                    <input type="radio" name="q3" value="1"/>1<br/>
                    <input type="radio" name="q3" value="2"/>2<br/>
                    <input type="radio" name="q3" value="3"/>3<br/>
                    <input type="radio" name="q3" value="4"/>4<br/>
                    <input type="radio" name="q3" value="4"/>5<br/>
                  </li>
                </div>

                <div id="q4" >
                    <li  style="display:none">
                      <h3>Q4) What is the answer to question 4? </h3>
                      <input type="radio" name="q4" value="1"/>1<br/>
                      <input type="radio" name="q4" value="2"/>2<br/>
                      <input type="radio" name="q4" value="3"/>3<br/>
                      <input type="radio" name="q4" value="4"/>4<br/>
                      <input type="radio" name="q4" value="4"/>5<br/>
                    </li>
                  </div>

                  <div id="q5" >
                    <li  style="display:none">
                      <h3>All Finished! Please click 'Submit' to continue </h3>            
                      
                    </li>
                  </div>

            </ul>
                <button id="next" >next</button>
        
        -->
        
        
        
        <ul id="questionsContainer">
            <div id="q1">
                  <li style="display:list-item">
                      <h3>Q1) What is the answer to question 1? </h3>
                      <input type="radio" name="q1" value="1"/>1<br/>
                      <input type="radio" name="q1" value="2"/>2<br/>
                      <input type="radio" name="q1" value="3"/>3<br/>
                      <input type="radio" name="q1" value="4"/>4<br/>
                      <input type="radio" name="q1" value="4"/>5<br/>
                  </li>
                </div>
            
                <div id="q2"  >
                  <li style="display:none">
                    <h3>Q2) What is the answer to question 2? </h3>
                    <input type="radio" name="q2" value="1"/>1<br/>
                    <input type="radio" name="q2" value="2"/>2<br/>
                    <input type="radio" name="q2" value="3"/>3<br/>
                    <input type="radio" name="q2" value="4"/>4<br/>
                    <input type="radio" name="q2" value="4"/>5<br/>
                  </li>
                </div>

                <div id="q3" >
                  <li  style="display:none">
                    <h3>Q3) What is the answer to question 3? </h3>
                    <input type="radio" name="q3" value="1"/>1<br/>
                    <input type="radio" name="q3" value="2"/>2<br/>
                    <input type="radio" name="q3" value="3"/>3<br/>
                    <input type="radio" name="q3" value="4"/>4<br/>
                    <input type="radio" name="q3" value="4"/>5<br/>
                  </li>
                </div>

                <div id="q4" >
                    <li  style="display:none">
                      <h3>Q4) What is the answer to question 4? </h3>
                      <input type="radio" name="q4" value="1"/>1<br/>
                      <input type="radio" name="q4" value="2"/>2<br/>
                      <input type="radio" name="q4" value="3"/>3<br/>
                      <input type="radio" name="q4" value="4"/>4<br/>
                      <input type="radio" name="q4" value="4"/>5<br/>
                    </li>
                  </div>

                  <div id="q5" >
                    <li  style="display:none">
                      <h3>All Finished! Please click 'Submit' to continue </h3>            
                      
                    </li>
                  </div>

            </ul>
                <button id="next" >next</button>
           
        
        <!-- AD - Beginning of the selection button section (answers)-->
        <div class="container2">            

            <form id="form" action="/SubmitAnswer" method="POST">

                <!-- AD - The main blue questionnaire container 
                    where the questions will be placed dynamically-->
                <div class="container5a">                  
            

                    <!-- AD - Beginning of the section with 5 selection buttons-->
                    <div class="input-radio">                  
			            
                        <c:forEach begin="0" end="18" var="question" items="${requestScope.questionlist}" >

							<div class = "containerDynamicQuestion">						
							
							
					        <h3><c:out value = "${question.id}) ${question.question}"/></h3> <!-- Display question -->
					    	</div>
                                <!-- ******************************************************************************************************** -->
                                    
                                    <input hidden ="question_text" type = "text" name = "question_text${question.id}"  value="${question.question}">
                                                          
                                    <!-- Display Radio buttons -->
                                    <label class = "questionnaireSelect">
                                        <b>SELECT :</b>
                                    </label>
                                    <label> <b>(1)</b>
                                    <input type = "radio" name = "selected${question.id}"  value="1">
                                    </label>
                                    <label> <b>(2)</b>
                                    <input type = "radio" name = "selected${question.id}" value = "2">
                                    </label>
                                    <label> <b>(3)</b>
                                    <input type = "radio" name = "selected${question.id}" value = "3">
                                    </label>
                                    <label> <b>(4)</b>
                                    <input type = "radio" name = "selected${question.id}" value = "4">
                                    </label>
                                    <label> <b>(5)</b>
                                    <input type = "radio" name = "selected${question.id}" value = "5">
                                    </label>                                                      

	        		    </c:forEach>       		
	        	
                    </div>          

                </div>
                
                
        <!-- AD - Delete this later
        <div class="container2">            

            <form id="form" action="/SubmitAnswer" method="POST">

               
                  
                <div class="container5a">                  
            

                  
                    <div class="input-radio">                  
			            
                        <c:forEach begin="0" end="18" var="question" items="${requestScope.questionlist}" >

							<div class = "containerDynamicQuestion">
					        <h3><c:out value = "${question.id}) ${question.question}"/></h3> 	</div>
                                                                  
                                    <input hidden ="question_text" type = "text" name = "question_text${question.id}"  value="${question.question}">
                                                          
                                   
                                    <label class = "questionnaireSelect">
                                        <b>SELECT :</b>
                                    </label>
                                    <label> <b>(1)</b>
                                    <input type = "radio" name = "selected${question.id}"  value="1">
                                    </label>
                                    <label> <b>(2)</b>
                                    <input type = "radio" name = "selected${question.id}" value = "2">
                                    </label>
                                    <label> <b>(3)</b>
                                    <input type = "radio" name = "selected${question.id}" value = "3">
                                    </label>
                                    <label> <b>(4)</b>
                                    <input type = "radio" name = "selected${question.id}" value = "4">
                                    </label>
                                    <label> <b>(5)</b>
                                    <input type = "radio" name = "selected${question.id}" value = "5">
                                    </label>                                                      

	        		    </c:forEach>       		
	        	
                    </div>          

                </div>
                -->
                
                
                
                
                
                
                
                
                
                

                <!-- AD - A container for the questionnaire button
                <div class="container3">
                    <button class="button-main button1 questionnaireButton" type="submit"><b>NEXT</b></button>
                </div>  
				-->
				
				<br>
                <hr> 

                <!-- AD - Questionnaire guidance for the user -->
                <div class="container7a">             
                    <h5>1 = strongly disagree / 2 = disagree / 3 = neither agree nor disagree / 4 = agree / 5 = strongly agree</h5>
                </div> 

            </form>           
		    
            <hr>      
    
            <!-- AD - button container, containing buttons-->
            <div class="container3">
            
                <button class="button-main button1"><b>PREVIOUS</b></button>
                
                <button class="button-main button1"><b>NEXT</b></button>

            </div>
        
        <!-- AD - End of the selection button section (answers)-->
        </div>

	<!-- AD - End of the central (yellow container)-->
    </div>
    
    
    			<!--  AD - Scripts / functions section */--> 
			    <script>
			    /* AD - This Script will facilitate the questionnaire functionality to
			                    display the questions one by one (dynamically) */
                 document.getElementById('next').addEventListener("click",function(){            
                var questionsContainer = document.getElementById("questionsContainer");
                var question = questionsContainer.getElementsByTagName("li");            
                        for (var i=0; i < question.length-1; i++) 
                        {
                            if(question[i].style.display == "list-item")
                            {
                                question[i].style.display = "none";
                                question[i+1].style.display = "list-item";
                                if(i == question.length-2 )
                                    this.disabled = "true";
                                break;
                            }
                        }                
                    });
                 </script>
    
    
    
    

	<!-- AD - includes the footer component, into this page (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %>
    

</body><!-- AD - End of body-->
</html><!-- AD - End of html-->