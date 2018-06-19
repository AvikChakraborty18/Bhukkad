<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@page isELIgnored="false" import="java.util.*" %>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Bhukkad</title>

     <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Custom styles for this template -->
    <link href="css/carousel.css" rel="stylesheet">
    <link href="css/Wendy.css" rel="stylesheet">
    <script>
$(document).ready(function(){
	$("#sel1").change(function()
	{
		var x=$("#sel1").val();
		if(x=="others")
			{
			$("#menuitem").html("<input type='text' style='width:20%'  class='form-control' placeholder='add menu category' name='menucat' required autofocus><br> <input type='text' style='width:15%'  class='form-control' placeholder='add menu' name='menuitem' required autofocus><br><input type='number'  style='width:8%' class='form-control' placeholder='price' name='price' required><br><button class='btn btn-success' type='submit'>ADD </button>");

			
			}
		else
			{
		$("#menuitem").html("<input type='text' style='width:15%'  class='form-control' placeholder='add menu' name='menuitem' required autofocus><br><input type='number'  style='width:8%' class='form-control' placeholder='price' name='price' required><br><button class='btn btn-success' type='submit'>ADD </button>");
			}   
		        
		        
	});
    });

</script>
</head>
<body>
<!-- navbar -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Bhukkad</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
    <li class="nav-item">
      <form style="margin-left:10px; margin-top:10px;" action="orders.bhukkad" ><button type="submit" class="btn btn-danger">Orders</button></form>
      </li> 
      
  
    </ul><ul>
  
 <li class="nav-item dropdown" style="list-style:none;">
 
        <a style="width:150%; font-size:22px;" class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
      Hi, ${rname}!
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="updateDetail.bhukkad">Edit Details</a>
          <a class="dropdown-item" href="updateMenu.bhukkad">Update Menu</a>
           <a class="dropdown-item" href="viewMenu.bhukkad">View Menu</a>
          <a class="dropdown-item" href="#">My reviews</a>
          <a class="dropdown-item" href="reslogout.bhukkad">Log out!</a>
         
        </div>
      </li>
     

    </ul>  
     
   
  </div>
</nav>
<br>

<div class="container">
<c:if test="${not empty msg}">
   	 	<%@ include file="response.jsp" %>
	</c:if>

   <form action="insertMenu.bhukkad" method="post">    
                            
     
      <select class="form-control" id="sel1" style="width:20%; height:40px;" name="menu" >
      <option value="" disabled selected>Select Menu Category :</option>
        <option value="starters">Starters</option>
        <option value="drinks">Drinks</option>
        <option value="main course">Main Course</option>
        <option value="rice">Rice</option>
        <option value="chinese">Chinese</option>
        <option value="veg">Veg</option>
        <option value="nonveg">Non-Veg</option>
        <option value="others">Others</option>
       
        
      </select>
       <br>
      <div id="menuitem"></div>
    
      
</form>
</div>


<!-- footer -->
 <div class="container">
      <footer class="footer" style="position: fixed;
   left: 0;
   bottom: 0;
   padding:20px;
   width: 100%;">
      
        <p>&copy; 2018 Bhukkad &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>
  </div>




<script src="../js/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../../../assets/js/vendor/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="js/holder.min.js"></script>
</body>
</html>