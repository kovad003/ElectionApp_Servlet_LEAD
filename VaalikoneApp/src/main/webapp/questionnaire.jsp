
   
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
            <p> Clicks: <a id="clicks">1</a></p>
        </div>
		
        <hr>     

        <!-- AD - Beginning of the selection button section (answers)-->
        <div class="container2">            

            <form id="form" action="/SubmitAnswer" method="POST">

                <!-- AD - The main blue questionnaire container 
                    where the questions will be placed dynamically-->
                <div class="container5a">                  
            
					<span id="spnError" class="error" style="display: none">Please select.</span>
                    <!-- AD - Beginning of the section with 5 selection buttons-->
                    <div class="input-radio">
	                    <button class="button-main button1 questionnaireButton" onclick="onStart()" id="start"><b>Start</b></button>
	                     <button class="button-main button1 questionnaireButton" type="submit" id="Submit"><b>Submit</b></button>
	                    <br>                 
			            <button class="button-main button1 questionnaireButton" onclick="onPrev()" id="previous" style="display: none"><b>Previous</b></button>
			            <button class="button-main button1 questionnaireButton" onclick="onNext()" id="next" style="display: none"><b>Next</b></button>
			            
                        <c:forEach var="question" items="${requestScope.questionlist}" >
							
						<div style="display: none" id="q${question.id}">
						
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
                                    <input type = "radio" name = "selected${question.id}"  value="1" required>
                                    </label>
                                    <label> <b>(2)</b>
                                    <input type = "radio" name = "selected${question.id}" value = "2" required>
                                    </label>
                                    <label> <b>(3)</b>
                                    <input type = "radio" name = "selected${question.id}" value = "3" required>
                                    </label>
                                    <label> <b>(4)</b>
                                    <input type = "radio" name = "selected${question.id}" value = "4" required>
                                    </label>
                                    <label> <b>(5)</b>
                                    <input type = "radio" name = "selected${question.id}" value = "5" required>
                                    </label>                                                                                         
						</div>
							
	        		    </c:forEach>       		
	        	
                    </div>          
				
                </div>	
				
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
    
	<!-- AD - includes the footer component, into this page (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %>

	<script type="text/javascript">
	
	// Event Listeners: Suspending button default functions => Validation will not work.
		document.getElementById("start").addEventListener("click", function(event){
		event.preventDefault()});
	
		document.getElementById("next").addEventListener("click", function(event){
		event.preventDefault()});
		
		document.getElementById("previous").addEventListener("click", function(event){
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
			
		    document.getElementById("clicks").innerHTML = div_id; // Displaying counter
		    
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
			string = "q"; //String for the id tag.
			
		    q_id += 1; // Displayed block.
			div_id = string + q_id
			
			
			q_id_prev = q_id - 1; // Prev block: div "on the left".
			div_id_prev = string + q_id_prev; // Prev block: div "on the left" => div id
			
			radio_tag = radio + (q_id - 1);
			//validator = false;
			
		    document.getElementById("clicks").innerHTML = div_id; // Displaying counter.
		    
			var div = document.getElementById(div_id); // Event Listener for question div.
			div.style.display = 'block';
			
			var div = document.getElementById(div_id_prev); 
			div.style.display = 'none';
			
			displayPrevBtn() // Event Listener for prev btn => needs to be displayed after Q2.
			displayNextBtn() // Event Listener for the div "on the left".
			
			
			var rad = document.getElementsByName(radio_tag);
			var isValid = false;
			
			for (var i = 0; i < rad.length; i++) {
	            if (rad[i].checked) {
	                isValid = true;
	                break;
	            }
	        }
			if(isValid == false)
				{
					alert("Please select!");
				}
           	//alert(rad[1].checked);
			// alert('rad.value = ' + rad.value + ' | radio_tag = ' + radio_tag + ' | rad.checked = ' + rad.checked);
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
			
		    document.getElementById("clicks").innerHTML = div_id; // Displaying counter
		    
			var div = document.getElementById(div_id); // Event Listener for question div.
			div.style.display = 'block';
			
			var div = document.getElementById(div_id_prev); // Event Listener for the div "on the right".
			div.style.display = 'none';
					
			displayPrevBtn() // Event Listener for prev btn => needs to be displayed after Q2.
			 
			displayNextBtn() // Event Listener for next btn => needs to be displayed before question.				
		};
		
	// Validation:	
		function Validate() {
	        //Reference the Table.
	        var radio = document.getElementById("form");
	 
	        //Reference the Group of RadioButtons.
	        var radio = document.getElementsByName("selected"+q_id);
	 
	        //Set the Valid Flag to False initially.
	        var isValid = false;
	 
	        //Loop and verify whether at-least one RadioButton is checked.
	        for (var i = 0; i < radio.length; i++) {
	            if (radio[i].checked) {
	                isValid = true;
	                break;
	            }
	        }
	 
	        //Display error message if no RadioButton is checked.
	        document.getElementById("spnError").style.display = isValid ? "none" : "block";
	        return isValid;
	    }
		
	// Other|Custom methods	
		function displayNextBtn()
		{
			var div = document.getElementById("next");
			if(q_id == collection_size)
				{
					div.style.display = 'none';
				}
			else
				{
					div.style.display = 'block';
				}
		}
		
		function displayPrevBtn()
		{
			var div = document.getElementById("previous"); 
			if(q_id > 1)
				{
					div.style.display = 'block';
				}
			else
				{
					div.style.display = 'none';
				}
		}
		
		// SOME USEFUL LINES:
		//div.style.visibility = 'hidden';
		//div.style.visibility = 'visible';
	</script>


</body><!-- AD - End of body-->
</html><!-- AD - End of html-->

