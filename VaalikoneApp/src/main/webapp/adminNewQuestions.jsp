
<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.Question" %>   
<%@ page import="data.Answer" %>  
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    

<!DOCTYPE html>
<html lang="en">
<head>

	<!-- AD - includes the meta component, into this page -->
    <%@ include file="../components/meta.jsp" %>
    
    <title>Admin: Update Questions</title>
    
    <!-- AD - includes the header component, into this page -->
    <%@ include file="../components/headerBootstrap.jsp" %>    
    
</head>
<body>

    <!-- AD - includes the navbar component, into this page -->
    <%@ include file="../components/navbar.jsp" %> 

    <!-- AD - Beginning the central (yellow container)-->
    <div class="containerMainUpdateCandidates">
        <i class="material-icons resize3">account_balance</i>
        
        <!-- AD - customises the 'ADMIN: Updates Candidates' message-->
        <div class="container6a"> 
        <h3>ADMIN PORTAL: Update Questions</h3>
        </div>
       
        <!-- AD - A small container to amend the admin note background section-->
        <div class="container4">             
            <!-- AD - Introductory statement about the ADMIN: Update Candidates page -->
            <h5>ADMIN NOTE: Once logged in, this page allows for a 'Global Herald Newspaper' 
                IT Admin to enter new questions.
            </h5>        
        </div>        

        <!-- AD - End of the central (yellow container)-->
    </div>

    <!-- AD This is a container to contain the data from the Question Table.
    Created utilising bootstrap, this .table-responsive class creates a responsive table
    which will scroll horizontally on small devices (under 768px). 
    When viewing on anything larger than 768px wide, 
    there is no difference:-->
    <div class="containerUpdateCandidatesTable">   
        <div>                                                                                             
            <div class="table-responsive">
            <form action = "/AdminAddQuestion" method="POST" id="addQuestion">          
                <table class="table">                    
                    <thead class = "tableCustom1">
                        <tr>
<!--                             <th>UPDATE</th>                            -->
                            <th>NEW_QUESTION_ID</th>
                            <th>NEW_QUESTION</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                    
                        <tr>                   
                            <td class = "tableAddBackground"><Button type="submit"><b class = "tableAdd">ADD</b></Button></td>                           
                            <td><input type="text" name="NEW_QUESTION_ID" placeholder="Auto incremented" disabled></td>
                            <td><input size="150" type="text" name="NEW_QUESTION" placeholder="Cannot be blank." required></td>
                        </tr>
                     
                    </tbody>                        
                            
                </table>
                </form>
            </div>
        </div>
    </div>
    
    
<!--       <div class="containerUpdateCandidatesTable">    -->
<!-- 	        <div>                                                                                              -->
<!-- 	            <div class="table-responsive"> -->
<!-- 		            <Select class="body_text" id="select_id" name="critical" onchange="showQuestion()"> -->
<!-- 						<option value="Select">Edit Questions</option> -->
<%-- 						<c:forEach var="question" items="${requestScope.questionlist}"> --%>
<%-- 						<option value="${question.id}">${question.id}</option> --%>
<%-- 			    		</c:forEach> --%>
<!-- 					</select> -->
					
<%-- 					<c:forEach var="question" items="${requestScope.questionlist}"> --%>
<%-- 						<div style="display: none" id="${question.id}"> --%>
						
<!-- 							   <form action = "/AdminEditQuestion" method="POST" id="updateQuestion">  -->
<!-- 								    <table class="table"> -->
<!-- 									    <thead class = "tableCustom1"> -->
<!-- 					                        <tr>  -->
<!-- 					                        	<th>NEW_QUESTION_ID</th>                               -->
<!-- 					                            <th>NEW_QUESTION</th> -->
					                       
<!-- 					                        </tr> -->
<!-- 					                    </thead> -->
<!-- 									    <tbody>                    -->
<!-- 					                       <tr>    -->
<%-- 						                       <td><input disabled size="" type="number" id="QID" name ="QID" value = "${question.id}"></td> --%>
<%-- 						                       <td><input required type="text"  name ="NEW_QUESTION" value = "${question.question}"></td> --%>
						                       
<!-- 					                  		</tr> -->
<!-- 					                   </tbody> -->
					                   
<!-- 				                  </table> -->
				                  		               
<!-- 				                   		<Button id="save_can" type="submit"><b class = "tableCustom2">Save</b></Button> -->
<!-- 				                   		<Button id="cancel_edit" type="button" onclick="cancelEditing()">Cancel</Button> 		 -->
<!-- 			                 </form>		                           -->
<!-- 						</div>  -->
<%-- 			    	</c:forEach> --%>
<!-- 	            </div> -->
<!-- 	        </div> -->
<!-- 	    </div> -->
	

<!-- 	         <div class="containerUpdateCandidatesTable">    -->
<!-- 	        <div>                                                                                              -->
<!-- 	            <div class="table-responsive"> -->
<!-- 		            <Select class="body_text" id="select_id_del" name="critical" onchange="startDeleting()"> -->
<!-- 						<option value="Select">Remove Question</option> -->
<%-- 						<c:forEach var="question" items="${requestScope.questionlist}"> --%>
<%-- 						<option value="${question.id}">${question.id}</option> --%>
<%-- 			    		</c:forEach> --%>
<!-- 					</select> -->
					
<%-- 					<c:forEach var="question" items="${requestScope.questionlist}"> --%>
<%-- 						<div style="display: none" id="del${question.id}"> --%>
						
<!-- 							   <form action = "/AdminDeleteNewQuestion" method="POST" id="updateQuestion">  -->
<!-- 								    <table class="table"> -->
<!-- 									    <thead class = "tableCustom1"> -->
<!-- 					                        <tr>  -->
<!-- 					                        	<th>NEW_QUESTION_ID</th>                               -->
<!-- 					                            <th>NEW_QUESTION</th> -->
					                            
<!-- 					                        </tr> -->
<!-- 					                    </thead> -->
<!-- 									    <tbody>                    -->
<!-- 					                       <tr>    -->
<%-- 						                       <td><input disabled size="" type="number" id="QID" name ="QID" value = "${question.id}"></td> --%>
<%-- 						                       <td><input required type="text"  name ="NEW_QUESTION" value = "${question.question}"></td> --%>
						                       
<!-- 					                  		</tr> -->
<!-- 					                   </tbody> -->
					                   
<!-- 				                  </table>			           		                -->
<!-- 			                   		<Button id="save_can" type="submit"><b class = "tableCustom3">Delete</b></Button> -->
<!-- 			                   		<Button id="cancel_edit" type="button" onclick="cancelDeleting()">Cancel</Button>  -->
<!-- 			                 </form>		                           -->
<!-- 						</div>  -->
<%-- 			    	</c:forEach> --%>
<!-- 	            </div> -->
<!-- 	        </div> -->
<!-- 	    </div> -->
    

    <!-- AD This is a container to contain the data from the Candidate Table.
            Created utilising bootstrap, this .table-responsive class creates a responsive table
            which will scroll horizontally on small devices (under 768px). 
            When viewing on anything larger than 768px wide, 
            there is no difference:-->
    <div class="containerUpdateCandidatesTable">   
        <div>                                                                                             
            <div class="table-responsive">   
                   
                <table class="table">                    
                    <thead class = "tableCustom1">
                        <tr>
<!--                             <th>UPDATE</th> -->
<!--                             <th>DELETE</th> -->
                            <th>NEW_QUESTION_ID</th>
                            <th>NEW_QUESTION</th>
                            
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="new_question" items="${requestScope.newQuestionsList}">
	                        <tr>
<!-- 	                            <td class = "tableCustom5"><Button onclick="window.open('AdminEditNewQuestion')"><b class = "tableCustom2">EDIT</b></Button></td>                     -->
<!-- 	                            <td class = "tableCustom5"><Button onclick="window.open('AdminDeleteNewQuestion')"><b class = "tableCustom3">DELETE</b></Button></td>   -->
	                            <td><c:out value = "${new_question.id}"/></td>
	                            <td><c:out value = "${new_question.question}"/></td>
	                             
	                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>  
        </div>
    </div>
    
    <!-- Make it hidden, edit btn should be triggered with the delete link of the table. It should redirect to a new page where u can edit the data-->
    <div>
		<c:forEach var="question" items="${requestScope.questionlist}">
                   <form action = "/AdminEditCandidate" method="POST" id="updateQuestion"> 
                       <input  size="" type="number" id="QID" name ="QID" value = "${new_question.id}">
                       <br>
                       <input type="text"  name ="NEWQUESTION" value = "${new_question.question}">
                       <br>
                   </form>
            </c:forEach>
       </div>
           <div>
           
        <!-- Make it hidden, submit btn should be triggered with the delete link of the table-->
		<c:forEach var="question" items="${requestScope.questionlist}">
                   <form action = "/AdminDeleteCandidate" method="POST" id="updateQuestion"> 
                       <input  size="" type="number" id="QID" name ="QID" value = "${new_question.id}">
                       <br>
                       <input type="text"  name ="NEWQUESTION" value = "${new_question.question}">
                       <br>
                       
                   </form>
            </c:forEach>
       </div>
    
    <!-- AD - includes the footer component into this page 
    (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %> 

</body><!-- AD - End of body-->
</html><!-- AD - End of html-->