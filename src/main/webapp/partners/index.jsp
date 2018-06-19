<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@page isELIgnored="false" import="java.util.*" %>
<c:if test="${not empty rname}">
   	 	<jsp:forward page="home1.jsp" />
	</c:if>
<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Bhukkad</title>

    <!-- Bootstrap core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
     <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Custom styles for this template -->
    <link href="../css/carousel.css" rel="stylesheet">
    <link href="../css/Wendy.css" rel="stylesheet">
     <link href="css/carousel.css" rel="stylesheet">
    <link href="css/Wendy.css" rel="stylesheet">
    <script>
$(document).ready(function(){
    $("#register").click(function(){
    	var x = $("#phn").val();
    	var l=x.toString().length;
    	if(l!=10)
    		{
    	$("#message").html("*Invalid phone number");
    	return false;
    		}
  
    	
    });
});
</script>
  </head>
  <body>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">Bhukkad</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home <span class="sr-only">(current)</span></a>
 
      <li  class="nav-item">
      <div></div>
      </li>
  
    </ul>
   <div style="padding:5">
   <button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#loginModal" >
  Sign In
</button>
      
     
   </div>
  </div>
</nav>
   <div class="modal fade" id="loginModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Please Sign in! </h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       
       <div class="container">

      <form class="form-signin" action="../reslogin.bhukkad" method="post">
     
       
        <input type="text"  class="form-control" placeholder="Restaurant Unique ID" name="rsid" required autofocus>
        <br>
       
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required>
        <br>
   </div>
      </div>
      <div class="modal-footer">
       <label><a href="#">Forgot Password?</a></label>
        <button class="btn btn-success" type="submit">Sign in</button>
       </form>
      </div>
    </div>
  </div>
</div>

   <div class="modal fade" id="registerModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Your food is Waiting!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       
      <form class="form-signin" action="../resRegister.bhukkad" method="post">
      	
        <input type="text"  class="form-control" placeholder="Restaurant name" name="rname" required autofocus/>
        <br>
       
        <input type="text" class="form-control" placeholder="Enter city or area" name="area"/>
        <br>
      
        <input type="email"  class="form-control" placeholder="Email address" name="email" required />
        <br>
       
        <input type="password"  class="form-control" placeholder="Password" name="password" required>
         <br>
       
        <input type="number"  id="phn" class="form-control" placeholder="Phone number" name="phone" maxlength="10" required>
     
      
      </div>
      <div class="modal-footer">
         <div id="message" style="float:left;position: relative;
left: -173px; color:red;"></div>
        <button type="submit" class="btn btn-primary" id="register">Register</button>
       </form>
      </div>
    </div>
  </div>
</div>
<br>
<div class="hero-image">
  <div class="hero-text">
 
    <h1 style="font-size:50px"></h1>
    <br>
    <br>
    <br>
    <br>
    <br>
    <br>
    <p style="font-size:50px">Register and Sell with Us! </p>
    <div style="padding:5">
  
      <button type="button" class="btn btn-primary" data-toggle="modal" data-target="#registerModal" style="width:20%">
 Register
</button>
  </div>
</div>
</div>

      <!-- FOOTER -->
      <div class="container">
      <footer class="footer" style="position: fixed;
   left: 0;
   bottom: 0;
   padding:20px;
   width: 100%;">
      
        <p>&copy; 2018 Bhukkad &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>
  </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="../js/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../../../assets/js/vendor/popper.min.js"></script>
    <script src="../js/bootstrap.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="js/holder.min.js"></script>
    <script src="../js/holder.min.js"></script>
   
    
  </body>
</html>
