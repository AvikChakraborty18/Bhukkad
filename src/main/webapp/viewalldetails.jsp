<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@page isELIgnored="false" import="java.util.*" %>
<c:if test="${empty email}">
   	 	<jsp:forward page="index.jsp" />
	</c:if>
<html lang="en">
  <head>
    <meta charset="utf-8">
   <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../../../../favicon.ico">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Bhukkad</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <!-- Custom styles for this template -->
    <link href="css/carousel.css" rel="stylesheet">
    <link href="css/Wendy.css" rel="stylesheet">
    <style>
.checked {
    color: orange;
}
</style>
</head>
<body>
<!-- navbar -->
 <nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="index.jsp">Bhukkad</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarSupportedContent">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="index.jsp">Home <span class="sr-only">(current)</span></a>
      </li>
     
      <li class="nav-item dropdown">
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
          Quick Bites!
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="#">Find a Restuarant</a>
          <a class="dropdown-item" href="#">Rate a Restuarant</a>
          <div class="dropdown-divider"></div>
          <a class="dropdown-item" href="Review.jsp">Suggest Us</a>
        </div>
      </li>
      <li  class="nav-item">
      <div></div>
      </li>
       
      <li class="nav-item">
        <button type="button" class="btn btn-danger" data-toggle="modal" data-target="#orderModal" id="orderNow">Order Now! </button>
      </li>
    </ul>
   <div style="padding:5" id="signin">
   <c:if test="${not empty name}">
   	 	<%@ include file="response.jsp" %>
	</c:if>
	<c:if test="${empty name}">
		   <button type="button" class="btn btn-outline-success" data-toggle="modal" data-target="#loginModal" >
				  Sign In
			</button>
		      <button type="button" class="btn btn-outline-primary" data-toggle="modal" data-target="#registerModal">
				 Register
			</button>
	</c:if>     
   </div>
  </div>
</nav>
     <div class="modal fade" id="orderModal">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Search quick! Order quick!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       
      <form class="form-signin" action="viewRestaurants.bhukkad">
      	
        <input type="text"  class="form-control" placeholder="Search Food" name="fname" autofocus/>
        <br>
       
        <input type="text" class="form-control" placeholder="Search Restuarants" name="searchname"/>
 
       
     
      </div>
      <div class="modal-footer">
       
        <button type="submit" class="btn btn-danger">Search</button>
        </form>
      </div>
    </div>
  </div>
</div>

   <div class="modal fade" id="registerModal" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Your food is Waiting!</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
       
      <form class="form-signin" action="register.bhukkad" method="post">
      	
        <input type="text"  class="form-control" placeholder="First name" name="fname" required autofocus/>
        <br>
       
        <input type="text" class="form-control" placeholder="Surname" name="sname"/>
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

      <form class="form-signin" action="login.bhukkad" method="post">
     
       
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" name="email" required autofocus>
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
<!---------------- body --------------------> 
<c:forEach items="${detaillist}" var="p">
<div class="container" style="padding-left: 75px;padding-top:15px; background-color: #f9fafc; margin-top:20px;">

<img src="images/1.jpg" style="width:1000px;height:300px;"/>
<br>
<br>
<h2>${p.rname}</h2>

<span class="fa fa-star checked"></span>
<span class="fa fa-star checked"></span>
<span class="fa fa-star checked"></span>
<span class="fa fa-star"></span>
<span class="fa fa-star"></span>

<form action="OrderOnline.bhukkad"><button style="float:right;margin-right: 50; margin-top: 30;" type="submit" class="btn btn-success">Order Online</button></a>
</form>
<hr>
<h6><span class="text-muted">${p.area}</span></h6>
<br>


</div>
<div class="container" style="padding-left: 75px;padding-top:15px; background-color: #f9fafc; margin-top:10px;">

<h4><span class="text-muted">Overview</span></h4>
<hr>
<div class="row">
<div class="col-md-3">
<h5>Phone number</h5>
<h5 style="color:green">${p.phone}</h5>
</div>
<div class="col-md-6">


<h5>Cuisines</h5>
<p style="color:red;"><c:forEach items="${menulist}" var="m">
<i>${m.menucat},</i>
</c:forEach></p>
</div>
<div class="col-md-3">
<h5>Address</h5>
<p><b>${p.area}</b></p>
</div>
</div>
<br>
<div class="row">
<div class="col-md-3">


<div id="map" style="width: 90%;height: 200px;"></div>

</div>

<div class="col-md-4">
<h5>Average Cost</h5>
<p>Rs.${p.averagecost} for two people (approx.)</p>
<p style="font-size:15px;"><span class="text-muted">Exclusive of applicable taxes and charges, if any</span></p>
</div>

<br>
</div>
<br>

</div>
<!-- <div class="container" style="padding-left: 75px;padding-top:15px; background-color: #f9fafc; margin-top:10px;">
<h4><span class="text-muted">Reviews</span></h4>
<hr>
<br>
<br>
<br>
<br>
</div> -->


</c:forEach>


<!-- footer -->
 <script>
function myMap() {
  var myCenter = new google.maps.LatLng(51.508742,-0.120850);
  var mapCanvas = document.getElementById("map");
  var mapOptions = {center: myCenter, zoom: 15};
  var map = new google.maps.Map(mapCanvas, mapOptions);
  var marker = new google.maps.Marker({position:myCenter});
  marker.setMap(map);
  google.maps.event.addListener(marker,'click',function() {
    var infowindow = new google.maps.InfoWindow({
      content:"Hi There!"
    });
  infowindow.open(map,marker);
  });
}
</script>

<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCsJbHFniN38nrA959spjWgdbIqRcHCNnk&callback=myMap"></script>
<!--
To use this code on your website, get a free API key from Google.
Read more at: https://www.w3schools.com/graphics/google_maps_basic.asp
-->

 

<script src="../js/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../../../assets/js/vendor/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="js/holder.min.js"></script>
</body>
</html>