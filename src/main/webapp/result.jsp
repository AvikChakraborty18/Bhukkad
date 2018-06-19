<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <%@page isELIgnored="false" import="java.util.*" %>

<c:forEach items="${user}" var="p">
<c:out value="${p.customerreg.email}"></c:out>
<c:out value="${p.password}"></c:out>




</c:forEach>
${ans}
