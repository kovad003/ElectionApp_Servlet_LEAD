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
            that suits you best. Carry on reading below to review your anwsers.
            <br><br>
            Please note, that you can make amendments if necessary.
        </h5>
        </div>
        
       
        <!-- AD - This container customises the heading to the candidate overviews-->
        <hr>
        <div class="container7">
            <h3>Your candidate matches:</h3>
        </div>  

        <!-- AD - Matched candidate colourings and text -->
        <div class="container6">
            <!-- AD - Overview info about the matched candidate -->
            <h5>Suitable candidate number 1 (the best match):                
                <br><br>
                Mikki Savolainen
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

         <!-- AD - Matched candidate colourings and text -->
         <div class="container6">
            <!-- AD - Overview info about the matched candidate -->
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

         <!-- AD - Matched candidate colourings and text -->
         <div class="container6">
            <!-- AD - Overview info about the matched candidate -->
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

        <!-- End of the candidate intro / overview section-->
        <hr>

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
    
            <!-- AD - A container for the login and registration buttons-->
            <div class="container3">

                <!-- AD - Buttons for login and registration-->
                <button class="button-main button1"><b>RESTART</b></button>
                
                <button class="button-main button1"><b>HOME</b></button>

            </div>
        
        <!-- AD - End of the selection button section (answers)-->
        </div>

    <!-- AD - End of the central (yellow container)-->
    </div>
    
    
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
        
    
    <!-- AD - includes the footer component into this page 
    (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %>

</body><!-- AD - End of body-->
</html><!-- AD - End of html-->