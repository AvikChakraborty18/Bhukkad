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
<script type="text/javascript">
$(document).ready(function() {
	$("#card").click(function() {
		$(".input-fields").show("slow");
	});
	$("#confirm").click(function(){
		var x="OID"+Date.now();
		document.f.method="post";
		document.f.action="ordercomplete.bhukkad?OID="+x;
		document.f.submit();
	});
	
});
$(function() {
	$("#cod").click(function() {
		$(".input-fields").hide("slow");
	});
});



</script>
<script>
function myFunction() {
    alert(Date.now());
}
</script>
</head>
<body>

<div id="xyz">
  <div class="checkout-panel">
    <div class="panel-body">
    <br>
      <h2 class="title">Checkout</h2>

      <div class="progress-bar">
        <div class="step active"></div>
        <div class="step active"></div>
        <div class="step"></div>
        <div class="step"></div>
      </div>

	
      <div class="payment-method">
        <label for="card" class="method card">
          <div class="card-logos">
            <img src="images/visa_logo.png"/>
            <img src="images/mastercard_logo.png"/>
          </div>

          <div class="radio-input">
            <input id="card" type="radio" name="payment" checked="checked">
            Pay  <b>Rs. ${gtotal}.00</b> with debit card
          </div>
        </label>

        <label for="paypal" class="method paypal">
          <img src="images/123.png" height="50px" width=100/>
          <div class="radio-input">
            <input id="cod" type="radio" name="payment">
            Pay <b>Rs. ${gtotal}.00</b> Cash On Delivery
          </div>
        </label>
      </div>

      <div id="form" class="input-fields">
        <div class="column-1">
          <label for="cardholder">Cardholder's Name</label>
          <input type="text" id="cardholder" />

          <div class="small-inputs">
            <div>
              <label for="date">Valid thru</label>
              <input type="text" id="date" placeholder="MM / YY" />
            </div>

            <div>
              <label for="verification">CVV / CVC *</label>
              <input type="password" id="verification"/>
            </div>
          </div>

        </div>
        <div class="column-2">
          <label for="cardnumber">Card Number</label>
          <input type="password" id="cardnumber"/>

          <span class="info">* CVV or CVC is the card security code, unique three digits number on the back of your card separate from its number.</span>
        </div>
      </div>
    </div>

    <div class="panel-footer">
  
     <form name="f"><button class="btn next-btn" id="confirm">Confirm</button></form>
    </div>
  </div>
  </div>

  <script src="js/jquery.min.js"></script>
  <script src="js/payment.js"></script>
</body>
</html>