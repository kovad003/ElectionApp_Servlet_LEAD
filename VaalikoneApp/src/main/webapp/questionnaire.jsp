
   
<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.Question" %>   
<%@ page import="data.Answer" %>

 <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
        <a href="../index.jsp"><i class="material-icons resize1">account_balance</i></a>
        
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
            <h5>DISCLAIMER: Neither the 'Global Herald Newspaper' or 'HAMK's Finest'
            are to be held liable for any views or comments expressed by the candidates 
            or users of this site. Your data is confidential and will not be shared or
            sold in any capacity. All rights reserved.</h5>
        
        </div>       
       
        <hr> 
        
        <!-- AD - Questionnaire guidance for the user -->
        <div class="container7a">             
            <h5>1 = strongly disagree / 2 = disagree / 3 = neither agree nor disagree / 4 = agree / 5 = strongly agree</h5>
        <!--  <a id="clicks"></a>  -->
        <!-- AD Click counter removed. Was only for Debugging purposes 
            <p> Clicks: <a id="clicks">1</a></p>-->
        </div>
		
        <hr>     

        <!-- AD - Beginning of the selection button section (answers)-->
        <div class="container2">            

            <form id="form" action="/SubmitAnswer" method="POST">				
               
                <br>                 
	            
	            
			            
                <!-- AD - The main blue questionnaire container 
                    where the questions will be placed dynamically-->
                <div class="container5a">                  
            
					<span id="spnError" class="error" style="display: none">Please select.</span>
                     
                    <!-- AD - This div contains and centers the 'Start' button -->
                    <div class="container3">  
                    <button class="button-main button1 questionnaireButton" onclick="onStart()" id="start"><b>Start</b></button>
                    </div>
                    
                    <div class="input-radio">
	                    
                        <c:forEach var="question" items="${requestScope.questionlist}" >
							
						<div style="display: none" id="q${question.id}">
						
							<div class = "containerDynamicQuestion">
					        	<h3><c:out value = "${question.id}/${fn:length(requestScope.questionlist)} - ${question.question}"/></h3> <!-- Display question -->
					   		</div>
					   		
                                <!-- ******************************************************************************************************** -->
                                    
                                    <input hidden ="question_text" type = "text" name = "question_text${question.id}"  value="${question.question}">
                                                          
                                    <!-- Display Radio buttons -->
                                    <label class = "questionnaireSelect">
                                        <b class = "customText1">SELECT :</b>
                                    </label>
                                    <label> <b>(1)</b>
                                    <input type = "radio" name = "selected${question.id}"  value="1" required>
                                    </label>
                                    <label> <b>(2)</b>
                                    <input type = "radio" name = "selected${question.id}" value = "2" required>
                                    </label>
                                    <label> <b>(3)</b>
                                    <input type = "radio" name = "selected${question.id}" value = "3" required checked ="checked">
                                    </label>
                                    <label> <b>(4)</b>
                                    <input type = "radio" name = "selected${question.id}" value = "4" required>
                                    </label>
                                    <label> <b>(5)</b>
                                    <input type = "radio" name = "selected${question.id}" value = "5" required>
                                    </label>                                                                                         
							</div>						
	        		    
	        		    </c:forEach> <!-- AD End of forEach loop -->         		        		    
	        		    
                    </div> <!-- AD End of container input-radio -->                   	      
				
                </div> <!-- AD End of container 5a -->
                
                <!-- AD - This div contains and centers the 'Next' button, which becomes visible after
						  the 'start' button has been clicked. In addition, this container
						  centres the 'previous' button, once it becomes visible. Finally,
						  once the questionnaire has been completed, the 'submit' and 'cancel'
						  buttons become visible, in the same container. -->
                    	<div class="container3a">						
						<button class="button-main button1 questionnaireButton" onclick="onPrev()" id="previous" style="display: none"><b>Previous</b></button>
						<button class="button-main button1 questionnaireButton" onclick="onNext()" id="next" style="display: none"><b>Next</b></button>
						<button class="button-main button1 questionnaireButton" onclick="toMain()" id="cancel" style="display: none"><b>Cancel</b></button>
						<button class="buttonSubmit button1" type="submit" id="submission" style="display: none"><b>Submit</b></button>                
						</div> 	
				
				<br>  
				
            </form>           
		    
            <hr>      
                    
        <!-- AD - End of the selection button section (answers)-->
        </div>

	<!-- AD - End of the central (yellow container)-->
    </div>
    
	<!-- AD - includes the footer component, into this page (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %>

	<script type="text/javascript">
	
	// Event Listeners: Suspending button default functions => Validation will not work.
		document.getElementById("start").addEventListener("click", function(event){ //will prevent submission with these buttons
		event.preventDefault()});
	
		document.getElementById("next").addEventListener("click", function(event){
		event.preventDefault()});
		
		document.getElementById("previous").addEventListener("click", function(event){
		event.preventDefault()});
		
		document.getElementById("cancel").addEventListener("click", function(event){
			event.preventDefault()});
		
			
	// Variables:
		var collection_size = ${fn:length(requestScope.questionlist)};
		
		var q_id = 0; //Current block.
		var string = "q"; //String for the id tag.
		var div_id; //The questin div's ID.
		
		var q_id_prev; //The questin div's ID.
		var div_id_prev; //The previous ("on the right" or "on the left" => depends on which btn is used: N/P) questin div's ID.
		
		var radio = "selected";
		var radio_tag;
		var validator = false;
	
	// START button
		function onStart() 
		{	
			string = "q"; 
		    q_id += 1; 
			div_id = string + q_id
			
			// Prev block
			q_id_prev = q_id - 1;
			div_id_prev = string + q_id_prev;
			
			/* AD - Click counter (displaying) was removed. Was only for debugging purposes
		    document.getElementById("clicks").innerHTML = div_id;
			*/
		    
		    var div = document.getElementById(div_id); // Event Listener for question div.
			div.style.display = 'block';
		    
		    var div = document.getElementById("start"); // Event Listener for start btn => needs to be hidden on start.
			div.style.display = 'none';
		    
			//var div = document.getElementById("previous"); // Event Listener for prev btn => needs to be displayed on start.
			//div.style.display = 'block';
			
			var div = document.getElementById("next"); // Event Listener for next btn => needs to be displayed on start.
			div.style.display = 'block';
			
			
		};
		
	//NEXT button
		function onNext() 
		{	
		
			var isValid = false;
			
			var curr_q_id = q_id;
			radio = "selected";	
			radio_tag = radio + (curr_q_id);
			
			var rad = document.getElementsByName(radio_tag);
			
			for (var i = 0; i < rad.length; i++) {
	            if (rad[i].checked) {
	                isValid = true;
	                break;
	            }
	        }
			
			if(isValid == true)
			{
				string = "q"; //String for the id tag.
				
			    q_id += 1; // Displayed block.
				div_id = string + q_id
				
				
				q_id_prev = q_id - 1; // Prev block: div "on the left".
				div_id_prev = string + q_id_prev; // Prev block: div "on the left" => div id
				
				radio_tag = radio + (q_id - 1);
				//validator = false;
				
				/* AD - Click counter (displaying) was removed. Was only for debugging purposes 
			    document.getElementById("clicks").innerHTML = div_id;
				*/
			    
				var div = document.getElementById(div_id); // Event Listener for question div.
				if(q_id != collection_size + 1)
				{
					div.style.display = 'block';
				}
				
				
				var div = document.getElementById(div_id_prev); 
				div.style.display = 'none';
				
				var next = document.getElementById("next");
				var sbmt = document.getElementById("submission");
				var cancel = document.getElementById("cancel");
				if(q_id == collection_size + 1)
					{
					//alert("q_id = " + q_id + "collection_size = " + collection_size);
						next.style.display = 'none';
						sbmt.style.display = 'block';
						cancel.style.display = 'block'
					}

				var prev = document.getElementById("previous"); 
				if(q_id == collection_size + 1)
				{
					prev.style.display = 'none';
				}
				else if(q_id == 1)
				{
					prev.style.display = 'none';
				}
				else
				{
					prev.style.display = 'block';
				}
			}
			else
			{
				alert("Please select!");
			}
			
		};

	//NEXT button
		function onPrev() 
		{				
			string = "q" //String for the id tag
			
		    q_id -= 1; //Current block
			div_id = string + q_id //Div id for questions => q1, q2, q3, ...
			
			// Next block
			q_id_prev = q_id + 1; // Div block on the "right"
			div_id_prev = string + q_id_prev; // Div block on the "right" => div id
			
			/* AD - Click counter (displaying) was removed. Was only for debugging purposes
		    document.getElementById("clicks").innerHTML = div_id;
			*/
		    
			var div = document.getElementById(div_id); // Event Listener for question div.
			div.style.display = 'block';
			
			var div = document.getElementById(div_id_prev); // Event Listener for the div "on the right".
			div.style.display = 'none';
			
			//alert("q_id = " + q_id + "collection_size = " + collection_size);
			var sbmt = document.getElementById("submission");
			sbmt.style.display = 'none';

			
			var nxt = document.getElementById("next");			
			if(q_id >= collection_size)
			{
				nxt.style.display = 'none';
			}
			else
			{
				nxt.style.display = 'block';
			}

			var prev = document.getElementById("previous");
			if(q_id == 1)
				{
					prev.style.display = 'none';
				}

		};
		
		function toMain()
		{
			window.location = "/index.jsp";
		}

		// SOME USEFUL LINES:
		//div.style.visibility = 'hidden';
		//div.style.visibility = 'visible';
	</script>


</body><!-- AD - End of body-->
</html><!-- AD - End of html-->

