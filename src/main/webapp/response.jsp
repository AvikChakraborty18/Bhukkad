 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 
 <%@page isELIgnored="false" import="java.util.*" %>
 <c:if test="${empty email}">
   	 	<jsp:forward page="index.jsp" />
	</c:if>
 <li class="nav-item dropdown" style="list-style:none;">
 
        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
        Hi, ${name}!
        </a>
        <div class="dropdown-menu" aria-labelledby="navbarDropdown">
          <a class="dropdown-item" href="viewmyorders.bhukkad">My Orders</a>
          <a class="dropdown-item" href="editmyprofile.bhukkad">Edit Profile</a>
          <a class="dropdown-item" href="cartview.bhukkad">My Cart</a>
          <a class="dropdown-item" href="logout.bhukkad">Log out!</a>
          
          
         
        </div>
      </li>