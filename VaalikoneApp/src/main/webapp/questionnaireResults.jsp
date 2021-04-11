<html lang="en">
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>
    
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
            <br><br>
            Please note, that you can make amendments if necessary.
        </h5>
        </div>
        
       
        <!-- AD - This container customises the heading to the candidate overviews-->
        <hr>
        <div class="container7">
            <h3>Your suitable candidate matches (click buttons to view):</h3>
        </div>
        <hr>
                

            <!-- AD - button container, containing the Suitable Candidate 
                ShowHide Toggle buttons -->
            <div class="container3">

                <input class = "buttonShowHide button1" id = "btnCandResults1" 
                type="button" value="1st Place" onclick="ShowHideToggle1(this)" >
                </input>
                
                <input class = "buttonShowHide button1" id = "btnCandResults2" 
                type="button" value="2nd Place" onclick="ShowHideToggle2(this)" >
                </input>

                <input class = "buttonShowHide button1" id = "btnCandResults3" 
                type="button" value="3rd Place" onclick="ShowHideToggle3(this)" >
                </input>

            </div>
            <br>
            <hr>     


            <!-- AD - This 'hidden div' shows the 1st place suitable candidate.
                      The div becomes visible once the '1st Place Candidate'
                      button is pressed. Conversely, the div disappears once the
                      button is pressed again (toggle button).-->
            <div id="dvCandResults1" style="display: none">
            
                
                <div class="container6">         
                    <h5>Suitable Candidate Match: 1st Place                  
                        <br><br>
                        Mikko Savolainen
                        <br><br>
                        <hr>
                        <br>
                        Overview: I care deeply about the environment and social issue.
                        <br><br>
                        sed do eiusmod tempor incididunt ut labore 
                        et dolore magna aliqua. Ut enim ad minim veniam, 
                        quis nostrud exercitation ullamco laboris nisi ut aliquip 
                        ex ea commodo consequat. Duis aute irure dolor in reprehenderit 
                        in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                        Excepteur sint occaecat cupidatat non proident, sunt in culpa qui 
                        officia deserunt mollit anim id est laborum.
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
                    <h5>Suitable Candidate Match: 2nd Place 
                        <br><br>
                        Sara Koskinen 
                        <br><br>
                        <hr>
                        <br>
                        Overview: I care deeply about the environment and social issue.
                        <br><br>
                        sed do eiusmod tempor incididunt ut labore 
                        et dolore magna aliqua. Ut enim ad minim veniam, 
                        quis nostrud exercitation ullamco laboris nisi ut aliquip 
                        ex ea commodo consequat. Duis aute irure dolor in reprehenderit 
                        in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                        Excepteur sint occaecat cupidatat non proident, sunt in culpa qui 
                        officia deserunt mollit anim id est laborum.
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
                    <h5>Suitable Candidate Match: 3rd Place 
                        <br><br>
                        Timo Salomaa
                        <br><br>
                        <hr>
                        <br>
                        Overview: I care deeply about the environment and social issue.
                        <br><br>
                        sed do eiusmod tempor incididunt ut labore 
                        et dolore magna aliqua. Ut enim ad minim veniam, 
                        quis nostrud exercitation ullamco laboris nisi ut aliquip 
                        ex ea commodo consequat. Duis aute irure dolor in reprehenderit 
                        in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                        Excepteur sint occaecat cupidatat non proident, sunt in culpa qui 
                        officia deserunt mollit anim id est laborum.
                    </h5>
                </div>  
            </div>
        
        
        
        
        
        <!-- AD - Beginning of the selection button section (answers)-->
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
    
    
    <!-- AD - Here are the extra two candidates that may be revealed later
         <div class="container6">
          
            <h5>Suitable candidate number 2 (the 2nd best match):
                <br><br>
                Sara Koskinen 
                <br><br>
                <hr>
                <br>
                Overview: I care deeply about the environment and social issue.
                <br><br>
                sed do eiusmod tempor incididunt ut labore 
                et dolore magna aliqua. Ut enim ad minim veniam, 
                quis nostrud exercitation ullamco laboris nisi ut aliquip 
                ex ea commodo consequat. Duis aute irure dolor in reprehenderit 
                in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui 
                officia deserunt mollit anim id est laborum.
            </h5>
        </div>

       
         <div class="container6">
          
            <h5>Suitable candidate number 3 (the 3rd best match):
                <br><br>
                Timo Salomaa
                <br><br>
                <hr>
                <br>
                Overview: I care deeply about the environment and social issue.
                <br><br>
                sed do eiusmod tempor incididunt ut labore 
                et dolore magna aliqua. Ut enim ad minim veniam, 
                quis nostrud exercitation ullamco laboris nisi ut aliquip 
                ex ea commodo consequat. Duis aute irure dolor in reprehenderit 
                in voluptate velit esse cillum dolore eu fugiat nulla pariatur. 
                Excepteur sint occaecat cupidatat non proident, sunt in culpa qui 
                officia deserunt mollit anim id est laborum.
            </h5>
        </div>

        -->


     <!-- AD - This section contains the full list of selected answers
        <hr>       
        <div class="container7">
        <h3>Your answers:</h3>
        </div>       
        
        <div class="container8">
          
            <h5>Q1: "I think that parliament should do more for the environment..."
                <br><br>
                Your answer (Number): 4    
            </h5>
        </div>

        <div class="container8">

            <h5>Q2: "I think that parliament should do more for the environment..."
                <br><br>
                Your answer (Number): 3    
            </h5>
        </div>
        
        <div class="container8">
           
            <h5>Q3: "I think that parliament should do more for the environment..."
                <br><br>
                Your answer (Number): 1   
            </h5>
        </div>
        
        <div class="container8">

            <h5>Q4: "I think that parliament should do more for the environment..."
                <br><br>
                Your answer (Number): 5   
            </h5>
        </div>
        
        <div class="container8">
        
            <h5>Q5: "I think that parliament should do more for the environment..."
                <br><br>               
                Your answer (Number): 1    
            </h5>
        </div>
    
        <div class="container8">
          
            <h5>Q6: "I think that parliament should do more for the environment..."
                <br><br>
                Your answer (Number): 4              
            </h5>
        </div>
       
        <div class="container8">
            
            <h5>Q7: "I think that parliament should do more for the environment..."
                <br><br>
                Your answer (Number): 2              
            </h5>
        </div>
       
        <div class="container8">
         
            <h5>Q8: "I think that parliament should do more for the environment..."
                <br><br>
                Your answer (Number): 3              
            </h5>
        </div>
     
        <div class="container8">
           
            <h5>Q9: "I think that parliament should do more for the environment..."
                <br><br>
                Your answer (Number): 3              
            </h5>
        </div>
      
        <div class="container8">
         
            <h5>Q10: "I think that parliament should do more for the environment..."
                <br><br>
                Your answer (Number): 5              
            </h5>
        </div>

        <div class="container8">
      
            <h5>Q11: "I think that parliament should do more for the environment..."
                <br><br>
                Your answer (Number): 1              
            </h5>
        </div>
 
        <div class="container8">

            <h5>Q12: "I think that parliament should do more for the environment..."
                <br><br>
                Your answer (Number): 4              
            </h5>
        </div>

        <div class="container8">
          
            <h5>Q13: "I think that parliament should do more for the environment..."
                <br><br>
                Your answer (Number): 2              
            </h5>
        </div>
 
        <div class="container8">
      
            <h5>Q14: "I think that parliament should do more for the environment..."
                <br><br>
                Your answer (Number): 5              
            </h5>
        </div>
 
        <div class="container8">
       
            <h5>Q15: "I think that parliament should do more for the environment..."
                <br><br>
                Your answer (Number): 5              
            </h5>
        </div>
    
        <div class="container8">
    
            <h5>Q16: "I think that parliament should do more for the environment..."
                <br><br>
                Your answer (Number): 2              
            </h5>
        </div>

        <div class="container8">
  
            <h5>Q17: "I think that parliament should do more for the environment..."
                <br><br>
                Your answer (Number): 4              
            </h5>
        </div>

        <div class="container8">
  
            <h5>Q18: "I think that parliament should do more for the environment..."
                <br><br>
                Your answer (Number): 3              
            </h5>
        </div>

        <div class="container8">

            <h5>Q19: "I think that parliament should do more for the environment..."
                <br><br>
                Your answer (Number): 1              
            </h5>
        </div>
        -->
        
        
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
                        } else {
                            dvCandResults1.style.display = "none";
                            btnCandResults1.value = "1st Place";
                        }
                    }
                </script>

            <!-- AD - This is the function for the ShowHideToggle 
                for the 2nd Place Suitable Candidate-->    
                <script type="text/javascript">
                    function ShowHideToggle2(btnCandResults2) {
                        var dvCandResults2 = document.getElementById("dvCandResults2");
                        if (btnCandResults2.value == "2nd Place") {
                            dvCandResults2.style.display = "block";
                            btnCandResults2.value = "HIDE";
                        } else {
                            dvCandResults2.style.display = "none";
                            btnCandResults2.value = "2nd Place";
                        }
                    }
                </script>


            <!-- AD - This is the function for the ShowHideToggle 
                for the 3rd Place Suitable Candidate-->    
                <script type="text/javascript">
                    function ShowHideToggle3(btnCandResults3) {
                        var dvCandResults3 = document.getElementById("dvCandResults3");
                        if (btnCandResults3.value == "3rd Place") {
                            dvCandResults3.style.display = "block";
                            btnCandResults3.value = "HIDE";
                        } else {
                            dvCandResults3.style.display = "none";
                            btnCandResults3.value = "3rd Place";
                        }
                    }
                </script>
        
    
    <!-- AD - includes the footer component into this page 
    (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %>

</body><!-- AD - End of body-->
</html><!-- AD - End of html-->