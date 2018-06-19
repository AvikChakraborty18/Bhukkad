<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@page isELIgnored="false" import="java.util.*" %>
<html>
<head>
<meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">

    <title>Bhukkad</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Custom styles for this template -->
    <link href="css/carousel.css" rel="stylesheet">
    <link href="css/Wendy.css" rel="stylesheet">

</head>
 <body>    	
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

 <form name="f">
 <button  onclick="getLocation()" class="btn btn-outline-primary" style="float:right">Update Location</button>
 </form>
 <button class="btn btn-outline-danger" style="float:right; margin-right:10px;">Upload Pictures!</button>
 <c:forEach items="${list}" var="p">
  <form action="updateName.bhukkad" method="post" class=form-sign>     <input type="text" style="width:30%;" class="form-control" placeholder="${p.rname}" name="rname" required autofocus/><button  style="width:20%; margin-top:4px;" class="btn btn-success" type="submit">Edit Restaurant Name</button>
        </form> 
      <br> 
    <form action="updateArea.bhukkad" method="post" class=form-sign>    <input type="text" style="width:25%; "class="form-control" placeholder="${p.area}" name="area"/><button style="width:15%;margin-top:4px;"  class="btn btn-success" type="submit">Edit Area</button>
        </form>
      
<br>
       
  <form action="updatePassword.bhukkad" method="post" class=form-sign>      <input type="password" style="width:20%;"  class="form-control"  name="password" required><button style="width:12%;margin-top:4px;"  class="btn btn-success" type="submit">Edit password</button>
        </form>
     <br>  
   <form action="updatePhone.bhukkad" method="post" class=form-sign>     <input type="number" style="width:15%;"  id="phn" class="form-control" placeholder="${p.phone}" name="phone" maxlength="10" required><button  style="width:10%;margin-top:4px;" class="btn btn-success" type="submit">Edit phone</button>
 </form>
 
  <form action="updateaveragecost.bhukkad" method="post" class=form-sign>     <input type="number" style="width:15%;"   class="form-control" placeholder="${p.averagecost}" name="averagecost"  required><button  style="width:10%;margin-top:4px;" class="btn btn-success" type="submit">Average cost</button>
 </form>
 </c:forEach>
 
 </div>
 
<p id="demo"></p>

<script>
var x = document.getElementById("demo");

function getLocation() {
    if (navigator.geolocation) {
        navigator.geolocation.getCurrentPosition(showPosition);
    } else { 
        x.innerHTML = "Geolocation is not supported by this browser.";
    }
}

function showPosition(position) {
	
	document.f.method="post";
	document.f.action="updateLocation.bhukkad?latitude="+position.coords.latitude+"&longitude="+position.coords.longitude;
   document.f.submit(); 
}
</script>




<script src="../js/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../../../assets/js/vendor/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="js/holder.min.js"></script>
 </body>
 </html>