
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@page isELIgnored="false" import="java.util.*" %>
 <c:if test="${empty email}">
   	 	<jsp:forward page="index.jsp" />
	</c:if>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet">
  <script type="text/javascript"src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
  
  <link rel="stylesheet" href="css/payment.css">
<meta name="robots" content="noindex,follow" />


</head>
<body>

<div id="xyz">
  <div class="checkout-panel">
    <div class="panel-body">
    <br>
      <h2 class="title"></h2>

      <div class="progress-bar">
        <div class="step active"></div>
        <div class="step active"></div>
        <div class="step active"></div>
        <div class="step active"></div>
      </div>
<div class="container" style="height:500px;">
<img src="images/successful.png" style="margin-left:230px">
<h3 style="color:green;margin-left:100px"> Your Order Successful! Your Order ID : ${oid}</h3>
<br>
<form action="index.jsp" style="margin-left:300px"><button type="submit" class="btn btn-primary">Home</button></form>




</div>
	
     
      
    </div>

    
  </div>
  </div>

  <script src="js/jquery.min.js"></script>
  <script src="js/payment.js"></script>
</body>
</html>