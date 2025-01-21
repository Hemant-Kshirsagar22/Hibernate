<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>SEARCH STUDENT</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
    
    <style type="text/css">
	    .center-container 
	    {
	      display: flex;
	      justify-content: center;
	      align-items: center;
	    }
	    
    </style>
  </head>
  <body>

<jsp:include page="./mainNav.html"></jsp:include>
  
  <div class="container border border-success w-75 p-3 align-items-center" style ="margin-top:75px;">
  <h2 class="center-container">SEARCH STUDENT</h2><br>
	  	<div class="col-md-12 center-container fs-5">
	  		
			<form method="post" action="./SearchStudent" class="w-50" >
                <div id="msg">
                </div>
			 	<div class="mb-3">
				  <label for="selectOption" class="form-label">Select Search Option</label>
                    <select class="form-control custom-select" id="selectOption" onchange="select()" name="selectOption">
                    <option value="" selected>Choose...</option>
                    <option value="name">By Name</option>
                    <option value="city">By City</option>
                    <option value="per">By per</option>
                    </select>
                    
				</div>

				<div id="inputField"></div>
				<input class="btn btn-outline-success w-100" type="submit" id="btn" value="SEARCH" disabled>
		  	</form>
	  	</div>
	</div>
	<script type="text/javascript" src="./src/js/searchStudent.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-kenU1KFdBIe4zVF0s0G1M5b4hcpxyD9F7jL+jjXkk+Q2h455rYXK/7HAuoJl+0I4" crossorigin="anonymous"></script>
  </body>
</html>