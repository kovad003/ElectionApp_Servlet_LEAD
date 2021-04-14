
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
    
    <title>Admin: Update Candidates</title>
    
    <!-- AD - includes the header component, into this page -->
    <%@ include file="../components/headerBootstrap.jsp" %>    
    
</head>
<body onload="disableAll();">

    <!-- AD - includes the navbarBootstrap component, 
    		which is modified version of our regular navbar,
    		in order to offset some negative effects
    		caused by bootsrap, onto our code. -->
    <%@ include file="../components/navbarBootstrap.jsp" %> 

    <!-- AD - Beginning the central (yellow container)-->
    <div class="containerMainUpdateCandidates">
        <i class="material-icons resize3">account_balance</i>
        
        <!-- AD - customises the 'ADMIN: Updates Candidates' message-->
        <div class="container6a"> 
        <h3 class = "adminTextCorrection1">ADMIN PORTAL: Update Candidates</h3>
        </div>
       
        <!-- AD - A small container to amend the admin note background section-->
        <div class="container4">             
            <!-- AD - Introductory statement about the ADMIN: Update Candidates page -->
            <h5 class = "adminTextCorrection2">ADMIN NOTE: Once logged in, this page allows for a 'Global Herald Newspaper' 
                IT Admin to add, edit and remove candidate information.
                <br><br>
                Regular users and candidates do not have access to this page 
                (or its functionality).
            </h5>        
        </div>        

        <!-- AD - End of the central (yellow container)-->
    </div>

    <!-- AD This is a container to contain the data from the Candidate Table.
    Created utilising bootstrap, this .table-responsive class creates a responsive table
    which will scroll horizontally on small devices (under 768px). 
    When viewing on anything larger than 768px wide, 
    there is no difference:-->
    <div class="containerUpdateCandidatesTable">   
        <div>                                                                                             
            <div class="table-responsive">
            <form action = "/AdminAddCandidate" method="POST" id="addCandidate">          
                <table class="table">                    
                    <thead class = "tableCustom1">
                        <tr>
                            <th>UPDATE</th>                           
                            <th>CANDIDATE_ID</th>
                            <th>SURNAME</th>
                            <th>FIRSTNAME</th>
                            <th>PARTY</th>
                            <th>LOCATION</th>
                            <th>AGE</th>
                            <th>REASON FOR RUNNING</th>
                            <th>AIMS AND GOALS</th>
                            <th>PROFESSION</th>
                        </tr>
                    </thead>
                    <tbody>
                    
                        <tr>                   
                            <td class = "tableAddBackground"><Button type="submit"><b class = "tableAdd">ADD</b></Button></td>                           
                            <td><input disabled type="text" name="CANDIDATE_ID" placeholder="Auto incremented" ></td>
                            <td><input required type="text" name="SURNAME" placeholder="Cannot be blank." ></td>
                            <td><input required type="text" name="FIRSTNAME" placeholder="Cannot be blank." ></td>
                            <td><input required type="text" name="PARTY" placeholder="Cannot be blank." ></td>
                            <td><input required type="text" name="LOCATION" placeholder="Cannot be blank." ></td>
                            <td><input required type="number" name="AGE" placeholder="Cannot be blank." ></td>
                            <td><input required type="text" name="REASON_FOR_RUNNING" placeholder="Cannot be blank." ></td>
                            <td><input required type="text" name="AIMS_AND_GOALS" placeholder="Cannot be blank." ></td>
                            <td><input required type="text" name="PROFESSION" placeholder="Cannot be blank." ></td>             
                        </tr>
                     
                    </tbody>                        
                            
                </table>
                </form>
            </div>
        </div>
    </div>
    <!-- ASH, CUSTOMISE IT PLEASE -->

     <div class="containerUpdateCandidatesTable">   
        <div>                                                                                             
            <div class="table-responsive">
	            <Select class="body_text" id="select_id" name="critical" onchange="showCandidate()">
					<option value="Select">Edit Candidate Profile</option>
					<c:forEach var="candidate" items="${requestScope.candidatelist}">
					<option value="${candidate.id}">${candidate.id}</option>
		    		</c:forEach>
				</select>
				
				<c:forEach var="candidate" items="${requestScope.candidatelist}">
					<div style="display: none" id="${candidate.id}">
					
						   <form action = "/AdminEditCandidate" method="POST" id="updateCandidate"> 
							    <table class="table">
								    <thead class = "tableCustom1">
				                        <tr> 
				                        	<th>CANDIDATE_ID</th>                              
				                            <th>SURNAME</th>
				                            <th>FIRSTNAME</th>
				                            <th>PARTY</th>
				                            <th>LOCATION</th>
				                            <th>AGE</th>
				                            <th>REASON FOR RUNNING</th>
				                            <th>AIMS AND GOALS</th>
				                            <th>PROFESSION</th>
				                        </tr>
				                    </thead>
								    <tbody>                   
				                       <tr>   
					                       <td><input disabled size="" type="number" id="CID" name ="CID" value = "${candidate.id}"></td>
					                       <td><input required type="text"  name ="SURENAME" value = "${candidate.SName}"></td>
					                       <td><input required type="text" name ="FIRSTNAME" value = "${candidate.FName}"></td>
					                       <td><input required type="text" name ="PARTY" value = "${candidate.party}"></td>
					                       <td><input required type="text" name ="LOCATION" value = "${candidate.location}"></td>
					                       <td><input required type="number" name ="AGE" value = "${candidate.age}"></td>
					                       <td><input required type="text" name ="REASON_FOR_RUNNING" value = "${candidate.reason}"></td>
					                       <td><input required type="text" name ="AIMS_AND_GOALS" value = "${candidate.goals}"></td>
					                       <td><input required type="text" name ="PROFESSION" value = "${candidate.profession}"></td>
				                  		</tr>
				                   </tbody>
				                   
			                  </table>
			                  		               
			                   		<Button id="save_can" type="submit"><b class = "tableCustom2">Save</b></Button>
			                   		<Button id="cancel_edit" type="button" onclick="cancelEditing()">Cancel</Button> 		
		                 </form>		                          
					</div> 
		    	</c:forEach>
            </div>
        </div>
    </div>

         <div class="containerUpdateCandidatesTable">   
        <div>                                                                                             
            <div class="table-responsive">
	            <Select class="body_text" id="select_id_del" name="critical" onchange="startDeleting()">
					<option value="Select">Remove Candidate Profile</option>
					<c:forEach var="candidate" items="${requestScope.candidatelist}">
					<option value="${candidate.id}">${candidate.id}</option>
		    		</c:forEach>
				</select>
				
				<c:forEach var="candidate" items="${requestScope.candidatelist}">
					<div style="display: none" id="del${candidate.id}">
					
						   <form action = "/AdminDeleteCandidate" method="POST" id="updateCandidate"> 
							    <table class="table">
								    <thead class = "tableCustom1">
				                        <tr> 
				                        	<th>CANDIDATE_ID</th>                              
				                            <th>SURNAME</th>
				                            <th>FIRSTNAME</th>
				                            <th>PARTY</th>
				                            <th>LOCATION</th>
				                            <th>AGE</th>
				                            <th>REASON FOR RUNNING</th>
				                            <th>AIMS AND GOALS</th>
				                            <th>PROFESSION</th>
				                        </tr>
				                    </thead>
								    <tbody>                   
				                       <tr>   
					                       <td><input disabled size="" type="number" id="CID" name ="CID" value = "${candidate.id}"></td>
					                       <td><input required type="text"  name ="SURENAME" value = "${candidate.SName}"></td>
					                       <td><input required type="text" name ="FIRSTNAME" value = "${candidate.FName}"></td>
					                       <td><input required type="text" name ="PARTY" value = "${candidate.party}"></td>
					                       <td><input required type="text" name ="LOCATION" value = "${candidate.location}"></td>
					                       <td><input required type="number" name ="AGE" value = "${candidate.age}"></td>
					                       <td><input required type="text" name ="REASON_FOR_RUNNING" value = "${candidate.reason}"></td>
					                       <td><input required type="text" name ="AIMS_AND_GOALS" value = "${candidate.goals}"></td>
					                       <td><input required type="text" name ="PROFESSION" value = "${candidate.profession}"></td>
				                  		</tr>
				                   </tbody>
				                   
			                  </table>			           		               
		                   		<Button id="save_can" type="submit"><b class = "tableCustom3">Delete</b></Button>
		                   		<Button id="cancel_edit" type="button" onclick="cancelDeleting()">Cancel</Button> 
		                 </form>		                          
					</div> 
		    	</c:forEach>
            </div>
        </div>
    </div>
    

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
                            <th>CANDIDATE_ID</th>
                            <th>SURNAME</th>
                            <th>FIRSTNAME</th>
                            <th>PARTY</th>
                            <th>LOCATION</th>
                            <th>AGE</th>
                            <th>REASON FOR RUNNING</th>
                            <th>AIMS AND GOALS</th>
                            <th>PROFESSION</th>
                        </tr>
                    </thead>
                     
                    <tbody>
                        <c:forEach var="candidate" items="${requestScope.candidatelist}">
	                        <tr> 
	                            <td><textarea name ="CANDIDATE_ID" disabled>${candidate.id}</textarea></td>
	                            <td><textarea disabled id="sname${candidate.id}" name ="SURENAME" >${candidate.SName}</textarea></td>
	                            <td><textarea disabled id="fname${candidate.id}" name ="FIRSTNAME" > ${candidate.FName}</textarea></td>
	                            <td><textarea disabled id="party${candidate.id}" name ="PARTY" >${candidate.party}></textarea></td>
	                            <td><textarea disabled id="location${candidate.id}" name ="LOCATION" >${candidate.location}</textarea></td>
	                            <td><textarea disabled id="age${candidate.id}" name ="AGE" >${candidate.age}</textarea></td>
	                            <td><textarea disabled id="reason${candidate.id}" name ="REASON_FOR_RUNNING" >${candidate.reason}</textarea></td>
	                            <td><textarea disabled id="goal${candidate.id}" name ="AIMS_AND_GOALS" >${candidate.goals}</textarea></td>
	                            <td><textarea disabled id="profession${candidate.id}" name ="PROFESSION" >${candidate.profession}</textarea></td>                
	                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>  
        </div>
    </div>
    
    <!-- AD - includes the footer component into this page 
    (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %> 


<script type="text/javascript">

	function showCandidate() {
	    d = document.getElementById("select_id").value; // Getting the value of selection
	    alert(d);
	    
	    document.getElementById(d).style.display = "block"; // block display
	    
	    document.getElementById("select_id").style.display = "none"; // no display
	    
	}
	
	function cancelEditing(){		
		document.getElementById("select_id").style.display = "block";
		d = document.getElementById("select_id").value;
	    //alert(d);	    
	    document.getElementById(d).style.display = "none";
	}
	
	function cancelDeleting() {
		document.getElementById("select_id_del").style.display = "block";
		g = document.getElementById("select_id_del").value;
	    //alert(g);	    
	    document.getElementById("del"+g).style.display = "none";

	}
	
	function startDeleting(){
	    g = document.getElementById("select_id_del").value; // Getting the value of selection
	    //alert(g);
	    //confirm("Press a button!");
	    document.getElementById("del"+g).style.display = "block"; // block display
	    
	    document.getElementById("select_id_del").style.display = "none"; // no display
	}

	
/* 		This can be used later pls do not remove it. Thanks!
		document.getElementById("cancel_edit").addEventListener("click", function(event){
			event.preventDefault()}); //prevents submission with CANCEL btn!
			
		document.getElementById("del_can").addEventListener("click", function(event){
			event.preventDefault()}); //prevents submission!
			
		document.getElementById("save_can").addEventListener("click", function(event){
			event.preventDefault()}); //prevents submission!
			
*/ 
	   
/*
	function enable(){
		/*
		document.getElementById('sname'${candidate.SName};).removeAttribute("disabled");
		document.getElementById('fname'${candidate.SName};).removeAttribute("disabled");	
		document.getElementById("party").removeAttribute("disabled");
		document.getElementById("location").removeAttribute("disabled");
		document.getElementById("age").removeAttribute("disabled");
		document.getElementById("reason").removeAttribute("disabled");
		document.getElementById("goal").removeAttribute("disabled");
		document.getElementById("profession").removeAttribute("disabled");	
		
		var x = document.getElementsByClassName('disabled');
		var i;
		for (i = 0; i < x.length; i++) {
		  x[i].setAttribute("disabled","disabled");
		}
*/
/*	
		
	}
	
	function enableAll() {
		
		var collection_size = ${fn:length(requestScope.candidatelist)};		
		
		var j;
		var id;
		
		for (j = 1001; j >collection_size; j++){
			id[j] = document.getElementsByClassName('disabled');
			
		}
		
		
		var x = document.getElementById('sname');
		var i;
		for (i = 0; i < x.length; i++) {
		  x[i].setAttribute("disabled","disabled");
		  
		  
		}
		

		
		document.getElementById('fname').removeAttribute("disabled");	
		document.getElementById("party").removeAttribute("disabled");
		document.getElementById("location").removeAttribute("disabled");
		document.getElementById("age").removeAttribute("disabled");
		document.getElementById("reason").removeAttribute("disabled");
		document.getElementById("goal").removeAttribute("disabled");
		document.getElementById("profession").removeAttribute("disabled");	
	}
	
/*
	function disableAll(){
		document.getElementById('sname').setAttribute("disabled","disabled");
		document.getElementById('fname').setAttribute("disabled","disabled");
		document.getElementById("party").setAttribute("disabled","disabled");
		document.getElementById("location").setAttribute("disabled","disabled");
		document.getElementById("age").setAttribute("disabled","disabled");
		document.getElementById("reason").setAttribute("disabled","disabled");
		document.getElementById("reason").setAttribute("disabled","disabled");
		document.getElementById("goal").setAttribute("disabled","disabled");
		document.getElementById("profession").setAttribute("disabled","disabled");	
	}
	
	function disableAll(){
		var x = document.getElementsByClassName('disabled');//.setAttribute("disabled","disabled");
		
		//var x = document.getElementsByTagName("P");
		var i;
		for (i = 0; i < x.length; i++) {
		  x[i].setAttribute("disabled","disabled");
		}

	}
*/
</script>

</body><!-- AD - End of body-->
</html><!-- AD - End of html-->