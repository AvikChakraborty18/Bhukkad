<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>
<c:forEach  items="${List}" var="l">
<hr>
<p><em>${l.feedname}</em></p>
<p>${l.feedcomment}</p>
<hr>
</c:forEach>	
