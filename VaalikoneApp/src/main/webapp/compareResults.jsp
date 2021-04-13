<html lang="en">
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>
    
    <title>Compare Results</title>
    
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
        <h2>Compare Results</h2>
        </div>
       
        <!-- AD - This container adds colourings and style to the intro message -->
        <div class="container5">
        <!-- AD - Introductory statement about the candidates page -->
        <h5>Thank you for successfully completing our questionnaire!
            This section allows you to compare your results.
            <br><br>
            By analysing your questionnaire answers, this election machine 
            utilises innovative algorithm techniques to match you with the candidate 
            that suits you best. Below you can can compare your results
            with that of the candidate.
            <br>           
        </h5>
        </div>

        <hr>


            <!-- AD - Start of the User Answers section-->

            <div class="container7b">
                <h6 class = "textRestyle1">Compare your answers (click to view):</h6>
            </div>  

            <!-- AD - button container, containing the UserResults 
            ShowHide Toggle button -->
            <div class="container3">

                <input class = "buttonShowHide2 button1" id = "btnCompareResults" 
                type="button" value="COMPARE" onclick="ShowHideToggle5(this)" >                

            </div>
            <br>
                

  <!-- AD - This 'hidden div' shows the User Results (answers).
            The div becomes visible once the 'ANSWERS'
            button is pressed. Conversely, the div disappears once the
            button is pressed again (toggle button).-->
            <div id="dvCompareResults" style="display: none">

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
                
                <div class="containerUserAnswers">
        
                    <h5>Q4: "I think that parliament should do more for the environment..."
                        <br><br>
                        Your answer (number): 5   
                    </h5>
                </div>
                
                <div class="containerUserAnswers">
                
                    <h5>Q5: "I think that parliament should do more for the environment..."
                        <br><br>               
                        Your answer (number): 1    
                    </h5>
                </div>
            
                <div class="containerUserAnswers">
                  
                    <h5>Q6: "I think that parliament should do more for the environment..."
                        <br><br>
                        Your answer (number): 4              
                    </h5>
                </div>
               
                <div class="containerUserAnswers">
                    
                    <h5>Q7: "I think that parliament should do more for the environment..."
                        <br><br>
                        Your answer (number): 2              
                    </h5>
                </div>

                <div class="containerUserAnswers">
         
                    <h5>Q8: "I think that parliament should do more for the environment..."
                        <br><br>
                        Your answer (number): 3              
                    </h5>
                </div>
             
                <div class="containerUserAnswers">
                   
                    <h5>Q9: "I think that parliament should do more for the environment..."
                        <br><br>
                        Your answer (number): 3              
                    </h5>
                </div>
              
                <div class="containerUserAnswers">
                 
                    <h5>Q10: "I think that parliament should do more for the environment..."
                        <br><br>
                        Your answer (number): 5              
                    </h5>
                </div>
        
                <div class="containerUserAnswers">
              
                    <h5>Q11: "I think that parliament should do more for the environment..."
                        <br><br>
                        Your answer (number): 1              
                    </h5>
                </div>
         
                <div class="containerUserAnswers">
        
                    <h5>Q12: "I think that parliament should do more for the environment..."
                        <br><br>
                        Your answer (number): 4              
                    </h5>
                </div>
        
                <div class="containerUserAnswers">
                  
                    <h5>Q13: "I think that parliament should do more for the environment..."
                        <br><br>
                        Your answer (number): 2              
                    </h5>
                </div>
         
                <div class="containerUserAnswers">
              
                    <h5>Q14: "I think that parliament should do more for the environment..."
                        <br><br>
                        Your answer (number): 5              
                    </h5>
                </div>
         
                <div class="containerUserAnswers">
               
                    <h5>Q15: "I think that parliament should do more for the environment..."
                        <br><br>
                        Your answer (number): 5              
                    </h5>
                </div>
            
                <div class="containerUserAnswers">
            
                    <h5>Q16: "I think that parliament should do more for the environment..."
                        <br><br>
                        Your answer (number): 2              
                    </h5>
                </div>
        
                <div class="containerUserAnswers">
          
                    <h5>Q17: "I think that parliament should do more for the environment..."
                        <br><br>
                        Your answer (number): 4              
                    </h5>
                </div>
        
                <div class="containerUserAnswers">
          
                    <h5>Q18: "I think that parliament should do more for the environment..."
                        <br><br>
                        Your answer (number): 3              
                    </h5>
                </div>
        
                <div class="containerUserAnswers">
        
                    <h5>Q19: "I think that parliament should do more for the environment..."
                        <br><br>
                        Your answer (number): 1              
                    </h5>
                </div>

            </div>            

        <!-- AD - End of the compare results section-->

        <div class="container2">           
            <!-- AD - A small container to amend the disclaimer background section-->
            <div class="container4">  
            
                <!-- AD - Questionnaire guidance for the user -->
		    <h5>DISCLAIMER: Neither the 'Global Herald Newspaper' or 'HAMK's Finest'
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
                for the Compare Results (answers)--> 

            <!-- AD - This HTML markup contains a DIV, which contains inside of it
                another div element, which possesses show / hide functionality.
                The button has been assigned a JavaScript Onclick event handler.
                When clicked, the function is executed. Furthermore, 
                based on the value of the button, the HTML div toggle 
                functionality will be executed. AKA the div will be shown, 
                and the button text and colour changed.-->  
                <script type="text/javascript">
                    function ShowHideToggle5(btnCompareResults) {
                        var dvCompareResults = document.getElementById("dvCompareResults");
                        if (btnCompareResults.value == "COMPARE") {
                            dvCompareResults.style.display = "block";
                            btnCompareResults.value = "HIDE";
                            btnCompareResults.style.backgroundColor = "#E76F51";
                        } else {
                            dvCompareResults.style.display = "none";
                            btnCompareResults.value = "COMPARE";
                            btnCompareResults.style.backgroundColor = "#2ea100";    
                        }
                    }
                </script>
                
    
    <!-- AD - includes the footer component into this page 
    (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %>

</body><!-- AD - End of body-->
</html><!-- AD - End of html-->