<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<!-- AD - This line might potentially be necessary later on 
	<meta charset="ISO-8859-1">
	-->
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
    <!-- allows for the use of special 'materialize' icons -->
    <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
    
    <!-- AD - Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

    <!-- AD - links to the election machine external css file-->
    <link href="../css/style.css" rel="stylesheet"> 

    <title>Admin: Update Candidates</title>
    
</head>
<body>

<!-- AD - customises the navbar-->
<div class="container-nav1">

    <div class="container-nav3">
        <div class="container-nav4">
          
                  <!-- AD - icon customisation 
                            Bold styling had to be added due to bootstrap
                            causing a few issues to the some of
                            the text sizes-->
                <div class = "container-nav-links-icon">
                <i class="material-icons resize3">account_balance</i>              
                </div>
                <div class = "container-nav-links">
                  <a href="#"><h5><b>Register</b></h5></a>
                </div>
                <div class = "container-nav-links">
                  <a href="#"><h5><b>Login</b></h5></a>
                </div>
                <div class = "container-nav-links">
                  <a href="#"><h5><b>Candidates</b></h5></a>
                </div>
                <div class = "container-nav-links">
                  <a href="#"><h5><b>About</b></h5></a>
                </div>           
            
        </div>
    </div>
</div>

    <!-- AD - Beginning the central (yellow container)-->
    <div class="containerMainUpdateCandidates">
        <i class="material-icons resize3">account_balance</i>
        
        <!-- AD - customises the 'ADMIN: Updates Candidates' message-->
        <div class="container6a"> 
        <h3>ADMIN PORTAL: Update Candidates</h3>
        </div>
       
        <!-- AD - A small container to amend the disclaimer background section-->
        <div class="container4">             
            <!-- AD - Introductory statement about the ADMIN: Update Candidates page -->
            <h5>ADMIN NOTE: Once logged in, this page allows for a 'Global Herald Newspaper' 
                IT Admin to add, edit and remove candidate information.
                <br><br>
                Regular users and candidates do not have access to this page 
                (or its functionality).
            </h5>        
        </div>        

        <!-- AD - End of the central (yellow container)-->
    </div>

    <!-- AD This is a container to contain the data from the Candidate Table.
            Created utilising bootsrap, this .table-responsive class creates a responsive table
            which will scroll horizontally on small devices (under 768px). 
            When viewing on anything larger than 768px wide, 
            there is no difference:-->
    <div class="containerUpdateCandidatesTable">   
        <div>                                                                                             
            <div class="table-responsive">          
                <table class="table">
                <thead>
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
                    <tr>
                    <td>UPDATE</td>
                    <td>DELETE</td>
                    <td>Demo CANDIDATE_ID 1</td>
                    <td>Demo SURNAME</td>
                    <td>Demo FIRSTNAME</td>
                    <td>Demo PARTY</td>
                    <td>Demo LOCATION</td>
                    <td>Demo AGE</td>
                    <td>Demo REASON FOR RUNNING</td>
                    <td>Demo AIMS AND GOALS</td>
                    <td>Demo PROFESSION</td>                  
                    </tr>
                </tbody>
                <tbody>
                    <tr>
                    <td>UPDATE</td>
                    <td>DELETE</td>
                    <td>Demo CANDIDATE_ID 1</td>
                    <td>Demo SURNAME</td>
                    <td>Demo FIRSTNAME</td>
                    <td>Demo PARTY</td>
                    <td>Demo LOCATION</td>
                    <td>Demo AGE</td>
                    <td>Demo REASON FOR RUNNING</td>
                    <td>Demo AIMS AND GOALS</td>
                    <td>Demo PROFESSION</td>                  
                    </tr>
                </tbody>
                <tbody>
                    <tr>
                    <td>UPDATE</td>
                    <td>DELETE</td>
                    <td>Demo CANDIDATE_ID 1</td>
                    <td>Demo SURNAME</td>
                    <td>Demo FIRSTNAME</td>
                    <td>Demo PARTY</td>
                    <td>Demo LOCATION</td>
                    <td>Demo AGE</td>
                    <td>Demo REASON FOR RUNNING</td>
                    <td>Demo AIMS AND GOALS</td>
                    <td>Demo PROFESSION</td>                  
                    </tr>
                </tbody>
                <tbody>
                    <tr>
                    <td>UPDATE</td>
                    <td>DELETE</td>
                    <td>Demo CANDIDATE_ID 1</td>
                    <td>Demo SURNAME</td>
                    <td>Demo FIRSTNAME</td>
                    <td>Demo PARTY</td>
                    <td>Demo LOCATION</td>
                    <td>Demo AGE</td>
                    <td>Demo REASON FOR RUNNING</td>
                    <td>Demo AIMS AND GOALS</td>
                    <td>Demo PROFESSION</td>                  
                    </tr>
                </tbody>
                <tbody>
                    <tr>
                    <td>UPDATE</td>
                    <td>DELETE</td>
                    <td>Demo CANDIDATE_ID 1</td>
                    <td>Demo SURNAME</td>
                    <td>Demo FIRSTNAME</td>
                    <td>Demo PARTY</td>
                    <td>Demo LOCATION</td>
                    <td>Demo AGE</td>
                    <td>Demo REASON FOR RUNNING</td>
                    <td>Demo AIMS AND GOALS</td>
                    <td>Demo PROFESSION</td>                  
                    </tr>
                    <tbody>
                        <tr>
                        <td>UPDATE</td>
                        <td>DELETE</td>
                        <td>Demo CANDIDATE_ID 1</td>
                        <td>Demo SURNAME</td>
                        <td>Demo FIRSTNAME</td>
                        <td>Demo PARTY</td>
                        <td>Demo LOCATION</td>
                        <td>Demo AGE</td>
                        <td>Demo REASON FOR RUNNING</td>
                        <td>Demo AIMS AND GOALS</td>
                        <td>Demo PROFESSION</td>                  
                        </tr>
                    </tbody>
                    <tbody>
                        <tr>
                        <td>UPDATE</td>
                        <td>DELETE</td>
                        <td>Demo CANDIDATE_ID 1</td>
                        <td>Demo SURNAME</td>
                        <td>Demo FIRSTNAME</td>
                        <td>Demo PARTY</td>
                        <td>Demo LOCATION</td>
                        <td>Demo AGE</td>
                        <td>Demo REASON FOR RUNNING</td>
                        <td>Demo AIMS AND GOALS</td>
                        <td>Demo PROFESSION</td>                  
                        </tr>
                    </tbody>
                </tbody>
                </table>
            </div>
        </div>
    </div>

</body><!-- AD - End of body-->
</html><!-- AD - End of html-->