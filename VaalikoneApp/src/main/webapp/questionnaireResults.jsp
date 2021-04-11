<html lang="en">
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>
    
    <%@ page import="java.util.ArrayList" %>   
	<%@ page import="data.Question" %>   
	<%@ page import="data.Answer" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    
    <title>Questionnaire Results</title>
    
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
        <h2>Your Results</h2>
        </div>
       
        <!-- AD - This container adds colourings and style to the intro message -->
        <div class="container5">
        <!-- AD - Introductory statement about the candidates page -->
	        <h5>Thank you for successfully completing our questionnaire!
	            This section covers your results.
	            <br><br>
	            By analysing your questionnaire answers, this election machine 
	            utilises innovative algorithm techniques to match you with the candidate 
	            that suits you best. Carry on reading below to review your answers.
	            <br>           
	        </h5>
        </div>
        
        <!-- AD - Start of the User Answers section-->

            <div class="container7b">
                <h6 class = "textRestyle1">Your answers (click to view):</h6>
            </div>  

            <!-- AD - button container, containing the UserResults 
            ShowHide Toggle button -->
            <div class="container3">

                <input class = "buttonShowHide2 button1" id = "btnUserResults" 
                type="button" value="ANSWERS" onclick="ShowHideToggle4(this)" >                

            </div>
            <br>
                

  <!-- AD - This 'hidden div' shows the User Results (answers).
            The div becomes visible once the 'ANSWERS'
            button is pressed. Conversely, the div disappears once the
            button is pressed again (toggle button).-->
            <div id="dvUserResults" style="display: none">

                <div class="containerUserAnswers">
          
                    <h5>Q1: "I think that parliament should do more for the environment..."
                        <br><br>
                        Your answer (number): 4    
                    </h5>
                    
                </div>

                <div class="containerUserAnswers">

                    <h5>Q2: "I think that parliament should do more for the environment..."
                        <br><br>
                        Your answer (number): 3    
                    </h5>
                </div>
                
                <div class="containerUserAnswers">
                   
                    <h5>Q3: "I think that parliament should do more for the environment..."
                        <br><br>
                        Your answer (number): 1   
                    </h5>
                </div>              

            </div>
            

            <!-- AD - This container customises the heading to the candidate overviews-->
            <hr>        
            <div class="container7c">
                <h6 class = "textRestyle1">Your top candidate matches (click to view):</h6>
            </div>
        
                <!-- AD - button container, containing the Suitable Candidate 
                    ShowHide Toggle buttons -->
                <div class="container3">
                    <input class = "buttonShowHide button1" id = "btnCandResults1" 
                    type="button" value="1st Place" onclick="ShowHideToggle1(this)" >           
                    
                    <input class = "buttonShowHide button1" id = "btnCandResults2" 
                    type="button" value="2nd Place" onclick="ShowHideToggle2(this)" >             

                    <input class = "buttonShowHide button1" id = "btnCandResults3" 
                    type="button" value="3rd Place" onclick="ShowHideToggle3(this)" >             

                </div>
                <br>        

                <!-- AD - This 'hidden div' shows the 1st place suitable candidate.
                        The div becomes visible once the '1st Place Candidate'
                        button is pressed. Conversely, the div disappears once the
                        button is pressed again (toggle button).-->
                <div id="dvCandResults1" style="display: none">               
                    <div class="container6">         
                        <h5>1st Place Match:
                        <c:out value="${requestScope.profile_1st.FName} ${requestScope.profile_1st.SName} - ${requestScope.profile_1st.party}"></c:out>                  
                            <br>
                            <br>
                            <hr>
                            <br>
                            
							Age: <c:out value="${requestScope.profile_1st.age}"></c:out>
							<br>
							Occupation: <c:out value="${requestScope.profile_1st.profession}"></c:out>
							<br>
                            Location: <c:out value="${requestScope.profile_1st.location}"></c:out>
                            <br>
                            <br>
                            Goals: <c:out value="${requestScope.profile_1st.goals}"></c:out>
                            <br><br>
                           	Reason: <c:out value="${requestScope.profile_1st.reason}"></c:out>
                           	<br>
                           	<br>
                           	<hr>
                        </h5>
                            <!-- AD - button container, containing the compareResults 
                            ShowHide Toggle button -->                    
                        <div class="containerCompareResults"> 
                            <input class = "buttonShowHide3 button1" id = "btnCompareResults" 
                            type="button" value="COMPARE YOUR ANSWERS" onclick="ShowHideToggle5(this)" >                
                        </div>               
                    </div>  
                </div>  
                
                
	                <!-- AD - This 'hidden div' shows the Compare Results (answers).
	            The div becomes visible once the 'COMPARE YOUR ANSWERS'
	            button is pressed. Conversely, the div disappears once the
	            button is pressed again (toggle button).-->
	            <div id="dvCompareResults" style="display: none">
	
	                <div class="containerCompareAnswers">
	          
	                    <h5>Q1: "I think that parliament should do more for the environment..."
	                        <br><br>
	                        Your answer (number): 4    
	                    </h5>
	                    
	                </div>
	
	                <div class="containerCompareAnswers">
	
	                    <h5>Q2: "I think that parliament should do more for the environment..."
	                        <br><br>
	                        Your answer (number): 3    
	                    </h5>
	                </div>
	                
	                <div class="containerCompareAnswers">
	                   
	                    <h5>Q3: "I think that parliament should do more for the environment..."
	                        <br><br>
	                        Your answer (number): 1   
	                    </h5>
	                </div>               
	
	            </div>             


                <!-- AD - This 'hidden div' shows the 2nd place suitable candidate.
                        The div becomes visible once the '2nd Place Candidate'
                        button is pressed. Conversely, the div disappears once the
                        button is pressed again (toggle button).-->       
                <div id="dvCandResults2" style="display: none">             
                    <!-- AD - This section shows the top suitable candidate(s)-->
                    <div class="container6">         
                        <h5>2nd Place Match:
                        <c:out value="${requestScope.profile_2nd.FName} ${requestScope.profile_2nd.SName} - ${requestScope.profile_2nd.party}"></c:out>                  
                            <br>
                            <br>
                            <hr>
                            <br>
                            
							Age: <c:out value="${requestScope.profile_2nd.age}"></c:out>
							<br>
							Occupation: <c:out value="${requestScope.profile_2nd.profession}"></c:out>
							<br>
                            Location: <c:out value="${requestScope.profile_2nd.location}"></c:out>
                            <br>
                            <br>
                            Goals: <c:out value="${requestScope.profile_2nd.goals}"></c:out>
                            <br><br>
                           	Reason: <c:out value="${requestScope.profile_2nd.reason}"></c:out>
                           	<br>
                           	<br>
                           	<hr>
                        </h5>
                            <!-- AD - button container, containing the compareResults 
                            ShowHide Toggle button -->                    
                        <div class="containerCompareResults"> 
                            <input class = "buttonShowHide3 button1" id = "btnCompareResults2" 
                            type="button" value="COMPARE YOUR ANSWERS" onclick="ShowHideToggle6(this)" >                
                        </div> 
                    </div>  
                </div>
                
                
                
                
                <!-- AD - This 'hidden div' shows the 2nd Compare Results (answers).
	            The div becomes visible once the 'COMPARE YOUR ANSWERS'
	            button is pressed. Conversely, the div disappears once the
	            button is pressed again (toggle button).-->
	            <div id="dvCompareResults2" style="display: none">
	
	                <div class="containerCompareAnswers">
	          
	                    <h5>Q1: "I think that parliament should do more for the environment..."
	                        <br><br>
	                        Your answer (number): 4    
	                    </h5>
	                    
	                </div>
	
	                <div class="containerCompareAnswers">
	
	                    <h5>Q2: "I think that parliament should do more for the environment..."
	                        <br><br>
	                        Your answer (number): 3    
	                    </h5>
	                </div>
	                
	                <div class="containerCompareAnswers">
	                   
	                    <h5>Q3: "I think that parliament should do more for the environment..."
	                        <br><br>
	                        Your answer (number): 1   
	                    </h5>
	                </div>               
	
	            </div>  
                     

                <!-- AD - This 'hidden div' shows the 3rd place suitable candidate.
                        The div becomes visible once the '3rd Place Candidate'
                        button is pressed. Conversely, the div disappears once the
                        button is pressed again (toggle button).-->         
                <div id="dvCandResults3" style="display: none">    
                
                    <!-- AD - This section shows the top suitable candidate(s)-->
                    <div class="container6">         
                        <h5>3rd Place Match:
                        <c:out value="${requestScope.profile_3rd.FName} ${requestScope.profile_3rd.SName} - ${requestScope.profile_3rd.party}"></c:out>                  
                            <br>
                            <br>
                            <hr>
                            <br>
                            
							Age: <c:out value="${requestScope.profile_3rd.age}"></c:out>
							<br>
							Occupation: <c:out value="${requestScope.profile_3rd.profession}"></c:out>
							<br>
                            Location: <c:out value="${requestScope.profile_3rd.location}"></c:out>
                            <br>
                            <br>
                            Goals: <c:out value="${requestScope.profile_3rd.goals}"></c:out>
                            <br><br>
                           	Reason: <c:out value="${requestScope.profile_3rd.reason}"></c:out>
                           	<br>
                           	<br>
                           	<hr>
                        </h5>                                     
                        <!-- AD - button container, containing the compareResults 
                        ShowHide Toggle button -->                    
                        <div class="containerCompareResults"> 
                            <input class = "buttonShowHide3 button1" id = "btnCompareResults3" 
                            type="button" value="COMPARE YOUR ANSWERS" onclick="ShowHideToggle7(this)" >                
                        </div> 
                    </div>  
                </div>
            
                <hr>
                <!-- End of the candidate matches section-->
                
                

<!-- AD - This 'hidden div' shows the 3rd Compare Results (answers).
	            The div becomes visible once the 'COMPARE YOUR ANSWERS'
	            button is pressed. Conversely, the div disappears once the
	            button is pressed again (toggle button).-->
	            <div id="dvCompareResults3" style="display: none">
	
	                <div class="containerCompareAnswers">
	          
	                    <h5>Q1: "I think that parliament should do more for the environment..."
	                        <br><br>
	                        Your answer (number): 4    
	                    </h5>
	                    
	                </div>
	
	                <div class="containerCompareAnswers">
	
	                    <h5>Q2: "I think that parliament should do more for the environment..."
	                        <br><br>
	                        Your answer (number): 3    
	                    </h5>
	                </div>
	                
	                <div class="containerCompareAnswers">
	                   
	                    <h5>Q3: "I think that parliament should do more for the environment..."
	                        <br><br>
	                        Your answer (number): 1   
	                    </h5>
	                </div>               
	
	            </div> 
 



        <div class="container2">           
            <!-- AD - A small container to amend the disclaimer background section-->
            <div class="container4">  
            
                <!-- AD - Questionnaire guidance for the user -->
		    <h5>DISCLAIMER: Neither the 'Global Herald Newspaper' or 'HÄMK's Finest'
                are to be held liable for any views or comments expressed by the candidates 
                or users of this site. Your data is confidential and will not be shared or
                sold in any capacity. All rights reserved.</h5>
            
            </div>
		    
            <hr>      
    
            <!-- AD - button container, containing buttons-->
            <div class="container3">

                <button class="button-main button1"><b>RESTART</b></button>
                
                <button class="button-main button1"><b>HOME</b></button>

            </div>
        
        <!-- AD - End of the selection button section (answers)-->
        </div>

    <!-- AD - End of the central (yellow container)-->
    </div>  


            <!-- AD - This is the function for the ShowHideToggle 
                for the 1st Place Suitable Candidate-->

            <!-- AD - This HTML markup contains a DIV, which contains inside of it
                another div element, which possesses show / hide functionality.
                The button has been assigned a JavaScript Onclick event handler.
                When clicked, the function is executed. Furthermore, 
                based on the value of the button, the HTML div toggle 
                functionality will be executed. AKA the div will be shown, 
                and the button text and colour changed.-->       
                <script type="text/javascript">
                    function ShowHideToggle1(btnCandResults1) {
                        var dvCandResults1 = document.getElementById("dvCandResults1");
                        if (btnCandResults1.value == "1st Place") {
                            dvCandResults1.style.display = "block";
                            btnCandResults1.value = "HIDE";
                            btnCandResults1.style.backgroundColor = "#E76F51";
                            
                        } else {
                            dvCandResults1.style.display = "none";
                            btnCandResults1.value = "1st Place";
                            btnCandResults1.style.backgroundColor = "#2A9D8F";                           
                        }
                    }
           
		            /* AD - This is the function for the ShowHideToggle 
		                for the 2nd Place Suitable Candidate */		          
                    function ShowHideToggle2(btnCandResults2) {
                        var dvCandResults2 = document.getElementById("dvCandResults2");
                        if (btnCandResults2.value == "2nd Place") {
                            dvCandResults2.style.display = "block";
                            btnCandResults2.value = "HIDE";
                            btnCandResults2.style.backgroundColor = "#E76F51";
                        } else {
                            dvCandResults2.style.display = "none";
                            btnCandResults2.value = "2nd Place";
                            btnCandResults2.style.backgroundColor = "#2A9D8F";    
                        }
                    }
    


		            /* AD - This is the function for the ShowHideToggle 
		                for the 3rd Place Suitable Candidate */          
                    function ShowHideToggle3(btnCandResults3) {
                        var dvCandResults3 = document.getElementById("dvCandResults3");
                        if (btnCandResults3.value == "3rd Place") {
                            dvCandResults3.style.display = "block";
                            btnCandResults3.value = "HIDE";
                            btnCandResults3.style.backgroundColor = "#E76F51";
                        } else {
                            dvCandResults3.style.display = "none";
                            btnCandResults3.value = "3rd Place";
                            btnCandResults3.style.backgroundColor = "#2A9D8F";    
                        }
                    }
       
            

		            /* AD - This is the function for the ShowHideToggle 
		                for the User Results (answers) */             
                    function ShowHideToggle4(btnUserResults) {
                        var dvUserResults = document.getElementById("dvUserResults");
                        if (btnUserResults.value == "ANSWERS") {
                            dvUserResults.style.display = "block";
                            btnUserResults.value = "HIDE";
                            btnUserResults.style.backgroundColor = "#E76F51";
                        } else {
                            dvUserResults.style.display = "none";
                            btnUserResults.value = "ANSWERS";
                            btnUserResults.style.backgroundColor = "#2ea100";    
                        }
                    }


                      /* AD - This is the function for the ShowHideToggle 
		                for the 1st compareResults (answers) */             
                        function ShowHideToggle5(btnCompareResults) {
                        var dvCompareResults = document.getElementById("dvCompareResults");
                        if (btnCompareResults.value == "COMPARE YOUR ANSWERS") {
                            dvCompareResults.style.display = "block";
                            btnCompareResults.value = "HIDE";
                            btnCompareResults.style.backgroundColor = "#E76F51";                          
                        } else {
                            dvCompareResults.style.display = "none";
                            btnCompareResults.value = "COMPARE YOUR ANSWERS";
                            btnCompareResults.style.backgroundColor = "purple";                         
                        }
                    }
                      
                      
                        /* AD - This is the function for the ShowHideToggle 
		                for the compareResults (answers) */             
                        function ShowHideToggle6(btnCompareResults2) {
                        var dvCompareResults2 = document.getElementById("dvCompareResults2");
                        if (btnCompareResults2.value == "COMPARE YOUR ANSWERS") {
                        	dvCompareResults2.style.display = "block";
                            btnCompareResults2.value = "HIDE";
                            btnCompareResults2.style.backgroundColor = "#E76F51";
                        } else {
                        	dvCompareResults2.style.display = "none";
                            btnCompareResults2.value = "COMPARE YOUR ANSWERS";
                            btnCompareResults2.style.backgroundColor = "purple";    
                        }
                    }
                        
                        
                        /* AD - This is the function for the 3rd ShowHideToggle 
		                for the compareResults (answers) */             
                        function ShowHideToggle7(btnCompareResults3) {
                        var dvCompareResults3 = document.getElementById("dvCompareResults3");
                        if (btnCompareResults3.value == "COMPARE YOUR ANSWERS") {
                        	dvCompareResults3.style.display = "block";
                        	btnCompareResults3.value = "HIDE";
                        	btnCompareResults3.style.backgroundColor = "#E76F51";
                        } else {
                        	dvCompareResults3.style.display = "none";
                        	btnCompareResults3.value = "COMPARE YOUR ANSWERS";
                        	btnCompareResults3.style.backgroundColor = "purple";    
                        }
                    }        
                      
                </script>
        
                
    
    <!-- AD - includes the footer component into this page 
    (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %>

</body><!-- AD - End of body-->
</html><!-- AD - End of html-->