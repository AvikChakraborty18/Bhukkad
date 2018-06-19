<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" import="java.util.*" %>
<c:if test="${empty email}">
   	 	<jsp:forward page="index.jsp" />
	</c:if>
<div><p style="color:green"><b><span>&#10003;</span>${msg}!</b></p></div>
<br>