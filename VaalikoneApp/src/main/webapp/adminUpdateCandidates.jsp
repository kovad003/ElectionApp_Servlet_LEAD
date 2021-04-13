
<%@ page import="java.util.ArrayList" %>   
<%@ page import="data.Question" %>   
<%@ page import="data.Answer" %>  
    
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
                            <td><input type="text" name="CANDIDATE_ID" placeholder="Auto incremented" disabled></td>
                            <td><input type="text" name="SURNAME" placeholder="Cannot be blank." disabled></td>
                            <td><input type="text" name="FIRSTNAME" placeholder="Cannot be blank." disabled></td>
                            <td><input type="text" name="PARTY" placeholder="Cannot be blank." disabled></td>
                            <td><input type="text" name="LOCATION" placeholder="Cannot be blank." disabled></td>
                            <td><input type="number" name="AGE" placeholder="Cannot be blank." disabled></td>
                            <td><input type="text" name="REASON_FOR_RUNNING" placeholder="Cannot be blank." disabled></td>
                            <td><input type="text" name="AIMS_AND_GOALS" placeholder="Cannot be blank." disabled></td>
                            <td><input type="text" name="PROFESSION" placeholder="Cannot be blank." disabled></td>             
                        </tr>
                     
                    </tbody>                        
                            
                </table>
                </form>
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
                            <th>UPDATE</th>
                            <th>DELETE</th>
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
	                            <td class = "tableCustom5"><Button onclick="enable()"><b class = "tableCustom2">EDIT</b></Button></td>                    
	                            <td class = "tableCustom5"><Button onclick="disable()"><b class = "tableCustom3">DELETE</b></Button></td>  
	                            <td><textarea name ="CANDIDATE_ID" disabled>${candidate.id}</textarea></td>
	                            <td><textarea class="disabled" id="sname" name ="SURENAME" >${candidate.SName}</textarea></td>
	                            <td><textarea id="fname" name ="FIRSTNAME" > ${candidate.FName}</textarea></td>
	                            <td><textarea id="party" name ="PARTY" >${candidate.party}></textarea></td>
	                            <td><textarea id="location" name ="LOCATION" >${candidate.location}</textarea></td>
	                            <td><textarea id="age" name ="AGE" >${candidate.age}</textarea></td>
	                            <td><textarea id="reason" name ="REASON_FOR_RUNNING" >${candidate.reason}</textarea></td>
	                            <td><textarea id="goal" name ="AIMS_AND_GOALS" >${candidate.goals}</textarea></td>
	                            <td><textarea id="profession" name ="PROFESSION" >${candidate.profession}</textarea></td>                
	                        </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>  
        </div>
    </div>
   
    <!-- Make it hidden, edit btn should be triggered with the delete link of the table. It should redirect to a new page where u can edit the data-->
    <div>
		<c:forEach var="candidate" items="${requestScope.candidatelist}">
                   <form action = "/AdminEditCandidate" method="POST" id="updateCandidate"> 
                       <input  size="" type="number" id="CID" name ="CID" value = "${candidate.id}">
                       <br>
                       <input type="text"  name ="SURENAME" value = "${candidate.SName}">
                       <br>
                       <input type="text" name ="FIRSTNAME" value = "${candidate.FName}">
                       <br>
                       <input type="text" name ="PARTY" value = "${candidate.party}">
                       <br>
                       <input type="text" name ="LOCATION" value = "${candidate.location}">
                       <br>
                       <input type="number" name ="AGE" value = "${candidate.age}">
                       <br>
                       <input type="text" name ="REASON_FOR_RUNNING" value = "${candidate.reason}">
                       <br>
                       <input type="text" name ="AIMS_AND_GOALS" value = "${candidate.goals}">
                       <br>
                       <input type="text" name ="PROFESSION" value = "${candidate.profession}">
                       <br>
                       <Button type="submit" name="button"><b class = "tableCustom2">EDIT</b></Button>                    
                   </form>
            </c:forEach>
       </div>
       
       <div>
           
        <!-- Make it hidden, submit btn should be triggered with the delete link of the table-->
		<c:forEach var="candidate" items="${requestScope.candidatelist}">
                   <form action = "/AdminDeleteCandidate" method="POST" id="updateCandidate"> 
                       <input  size="" type="number" id="CID" name ="CID" value = "${candidate.id}">
                       <br>
                       <input type="text"  name ="SURENAME" value = "${candidate.SName}">
                       <br>
                       <input type="text" name ="FIRSTNAME" value = "${candidate.FName}">
                       <br>
                       <input type="text" name ="PARTY" value = "${candidate.party}">
                       <br>
                       <input type="text" name ="LOCATION" value = "${candidate.location}">
                       <br>
                       <input type="number" name ="AGE" value = "${candidate.age}">
                       <br>
                       <input type="text" name ="REASON_FOR_RUNNING" value = "${candidate.reason}">
                       <br>
                       <input type="text" name ="AIMS_AND_GOALS" value = "${candidate.goals}">
                       <br>
                       <input type="text" name ="PROFESSION" value = "${candidate.profession}">
                       <br>
                       <Button type="submit"><b class = "tableCustom3">DELETE</b></Button>
                   </form>
            </c:forEach>
       </div>
    
    <!-- AD - includes the footer component into this page 
    (albeit not visible) -->
	<%@ include file="../components/footer.jsp" %> 

<script type="text/javascript">

	function enable() {
		//document.getElementById('sname').setAttribute("disabled","disabled");
		document.getElementById('sname').removeAttribute("disabled");
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
	*/
	function disableAll(){
		var x = document.getElementsByClassName('disabled');//.setAttribute("disabled","disabled");
		
		//var x = document.getElementsByTagName("P");
		var i;
		for (i = 0; i < x.length; i++) {
		  x[i].setAttribute("disabled","disabled");
		}
		
		/*
		document.getElementsByName('FIRSTNAME').setAttribute("disabled","disabled");
		document.getElementsByName("PARTY").setAttribute("disabled","disabled");
		document.getElementsByName("LOCATION").setAttribute("disabled","disabled");
		document.getElementsByName("AGE").setAttribute("disabled","disabled");
		document.getElementsByName("REASON_FOR_RUNNING").setAttribute("disabled","disabled");
		document.getElementsByName("AIMS_AND_GOALS").setAttribute("disabled","disabled");
		document.getElementsByName("PROFESSION").setAttribute("disabled","disabled");
		*/
	}
</script>

</body><!-- AD - End of body-->
</html><!-- AD - End of html-->