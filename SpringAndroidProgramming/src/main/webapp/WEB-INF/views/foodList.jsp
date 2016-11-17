<%@ page contentType="application/json; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

[
<c:forEach var="food" items="${flist}" varStatus="status">
	{
		"image" : "${food.image}",	
		"imageLarge" : "${food.imageLarge}",
		"name" : "${food.name}",
		"price" : "${food.price}",
		"content" : "${food.content}"
	}	
	<c:if test="${!status.last}">,</c:if>
</c:forEach>
]