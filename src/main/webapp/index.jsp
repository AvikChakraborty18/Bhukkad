<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@page isELIgnored="false" import="java.util.*" %>
<html lang="en">
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
<script type="text/javascript">
function startAjax()
{
	var xmlHttp;
	xmlHttp=new XMLHttpRequest();
	var email=document.regform.email.value;
	var url="checkuser.bhukkad?email="+email;
	xmlHttp.open('GET', url, true)
	xmlHttp.send();
	xmlHttp.onreadystatechange=function()
	{
		if(xmlHttp.readyState==4)
			{
			document.getElementById("message").innerHTML=xmlHttp.responseText;
			
			}
	}
}
function loginAjax()
{
	var xmlHttp;
	xmlHttp=new XMLHttpRequest();
	var email=document.loginform.email.value;
	var password=document.loginform.password.value
	var url="login.bhukkad?email="+email+"&password="+password;
	xmlHttp.open('POST', url, true)
	xmlHttp.send();
	xmlHttp.onreadystatechange=function()
	{
		if(xmlHttp.readyState==4)
		{
		result=xmlHttp.responseText;
		result=result.trim();
		}
		
		
		if(result=="successful")
			{
			window.location.href = "index.jsp";
			
			}
		else
			{
			document.getElementById("message1").innerHTML=result;
			}
		 
		
	}
	
	
}
</script>
    <!-- Custom styles for this template -->
    <link href="css/carousel.css" rel="stylesheet">
    <link href="css/Wendy.css" rel="stylesheet">
  </head>
  <body>
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
          <a class="dropdown-item" href="viewRestaurants.bhukkad">Find a Restuarant</a>
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
  <br>
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
       
      <form class="form-signin" action="register.bhukkad" method="post" name="regform">
      	
        <input type="text"  class="form-control" placeholder="First name" name="fname" required autofocus/>
        <br>
       
        <input type="text" class="form-control" placeholder="Surname" name="sname"/>
        <br>
      
        <input type="email"  class="form-control" placeholder="Email address" name="email" onblur="startAjax();" required />
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

      <form class="form-signin" action="login.bhukkad" method="post" name="loginform">
     
       
        <input type="email" id="inputEmail" class="form-control" placeholder="Email address" name="email" required autofocus>
        <br>
       
       
        <input type="password" id="inputPassword" class="form-control" placeholder="Password" name="password" required >
        <br>
        
       
     

    </div>
       
      
      </div>
      <div class="modal-footer">
      <div id="message1" style="float:left;color:red;"></div>
       <label><a href="#">Forgot Password?</a></label>
        <button class="btn btn-success" type="button" onclick="loginAjax();">Sign in</button>
       </form>
      </div>
    </div>
  </div>
</div>
   
    

      
      <div id="myCarousel" class="carousel slide" data-ride="carousel">
     
        <ol class="carousel-indicators">
          <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
          <li data-target="#myCarousel" data-slide-to="1"></li>
          <li data-target="#myCarousel" data-slide-to="2"></li>
        </ol>
      
        <div class="carousel-inner">
        
          <div class="carousel-item active">
            <img class="first-slide" src="images/1.jpg" alt="First slide">
            <div class="container">
              <div class="carousel-caption">
              <!-- <h1 style="font-family:Comic Sans MS, cursive, sans-serif;">Search Your Food Now!</h1> -->
                <!--   <form>
            <input class="form-control" type="text" placeholder="Search Restuarants" aria-label="Search" >
            <br>
            <button class="btn btn-success" type="submit" id="search">Search</button>
          </form> -->
          
          <br>
          
              </div>
              
            </div>
          </div>
          <div class="carousel-item">
            <img class="second-slide" src="images/2.jpg" alt="Second slide">
            <div class="container">
              <div class="carousel-caption text-right">
               <!--  <h1 style="font-family:Comic Sans MS, cursive, sans-serif;">You eat, we Love!</h1>
              -->
              <!--   <form >
            <input class="form-control" type="text" placeholder="Search Restuarants" aria-label="Search" >
            <br>
            <button class="btn btn-success" type="submit" id="search">Search</button>
          </form> -->
                <!-- <p>We will make sure, your Fridge and Stomach are never empty!</p>
                <p><a class="btn btn-lg btn-primary" href="#" role="button">About Us</a></p> -->
              </div>
            </div>
          </div>
          <div class="carousel-item">
            <img class="third-slide" src="images/download.jpg" alt="Third slide">
            <div class="container">
              <div class="carousel-caption text-right">
               <!--  <h1 style="font-family:Comic Sans MS, cursive, sans-serif;">Feeling hungry? Why worry?</h1>
                <br> -->
               <!--  <p><a class="btn btn-lg btn-primary" href="#" role="button">Order</a></p> -->
              </div>
            </div>
          </div>
        </div>
        <a class="carousel-control-prev" href="#myCarousel" role="button" data-slide="prev">
          <span class="carousel-control-prev-icon" aria-hidden="true"></span>
          <span class="sr-only">Previous</span>
        </a>
        <a class="carousel-control-next" href="#myCarousel" role="button" data-slide="next">
          <span class="carousel-control-next-icon" aria-hidden="true"></span>
          <span class="sr-only">Next</span>
        </a>
       <br>
       <br>
      </div>
     <div class="container">
     	  <form method="post" action="viewRestaurants.bhukkad" style="width: 100%;margin-top: -164; margin-bottom:150;">
     	<div class="row" style="z-index: 2;">
     	
     	 <div class="col-md-2"></div>
     	  
            <div class="col-md-7" style="padding-top:5px;"><input class="form-control" type="text" placeholder="Search Restuarants" aria-label="Search" style=" float:left; width:100%" name="searchname"/></div>
           <div class="col-md-2" style="padding-top:5px;"><button class="btn btn-success" type="submit" id="search" style="float:left;">Search</button></div>
          
         <div class="col-md-1"></div>   
          
          </div>
          </form>
</div>
      <!-- Marketing messaging and featurettes
      ================================================== -->
      <!-- Wrap the rest of the page in another container to center all the content. -->

      <div class="container marketing">

        <!-- Three columns of text below the carousel -->
        <div class="row">
          <div class="col-lg-4">
            <img class="rounded-circle" src="images/4.jpg" alt="Generic placeholder image" width="140" height="140">
            <br>
            <br>
            <p><b><i>""One cannot think well, love well, sleep well, if one has not dined well"</i></b></p>
            
            
          </div><!-- /.col-lg-4 -->
          <div class="col-lg-4">
            <img class="rounded-circle" src="images/5.jpg" alt="Generic placeholder image" width="140" height="140">
            <br>
            <br>
            <p><b><i>"Your diet is a bank account. Good food choices are good investments"</i></b></p>
            
          </div><!-- /.col-lg-4 -->
          <div class="col-lg-4">
            <img class="rounded-circle" src="images/6.jpg" alt="Generic placeholder image" width="140" height="140">
            <br>
            <br>
            <p><b><i>"A house is not a home unless it contains food and fire for the mind as well as the body"</i></b></p>
           
          </div><!-- /.col-lg-4 -->
        </div><!-- /.row -->


        <!-- START THE FEATURETTES -->

        <hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7">
            <h2 class="featurette-heading">Your need for Food Shopping, <span class="text-muted">Ends Here!</span></h2>
            <br>
            <p class="lead">There is no sincere love than the love of Food!</p>
             <p class="lead">- George Bernard Shaw</p>
          </div>
          <div class="col-md-5">
            <img class="featurette-image img-fluid mx-auto" src="images/5.jpg" alt="Generic placeholder image">
          </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7 order-md-2">
            <h2 class="featurette-heading">Oh yeah, it's that good. <span class="text-muted">See for yourself.</span></h2>
            <br>
            <p class="lead">People who love to eat, are always the best People!</p>
          
          </div>
          <div class="col-md-5 order-md-1">
            <img class="featurette-image img-fluid mx-auto" src="images/7.jpg" alt="Generic placeholder image">
          </div>
        </div>

        <hr class="featurette-divider">

        <div class="row featurette">
          <div class="col-md-7">
            <h2 class="featurette-heading">And lastly, this one. <span class="text-muted">Checkmate.</span></h2>
            <br>
            <p class="lead">Hard work should be rewarded with good Food!</p>
            <p class="lead">- Ken Follett</p>
          </div>
          <div class="col-md-5">
            <img class="featurette-image img-fluid mx-auto" src="images/4.jpg" alt="Generic placeholder image">
          </div>
        </div>

        <hr class="featurette-divider">

        <!-- /END THE FEATURETTES -->

      </div><!-- /.container -->


      <!-- FOOTER -->
      <footer class="container">
        <p class="float-right"><a href="#">Back to top</a></p>
        <p>&copy; 2018 Bhukkad &middot; <a href="#">Privacy</a> &middot; <a href="#">Terms</a></p>
      </footer>
  

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="js/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script>window.jQuery || document.write('<script src="../../../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
    <script src="../../../../assets/js/vendor/popper.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="js/holder.min.js"></script>
   
    
  </body>
</html>
