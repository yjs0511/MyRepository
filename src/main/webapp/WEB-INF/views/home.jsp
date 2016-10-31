<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		SpringFinalProgramming
		<hr/>
		1. 
		<c:if test="${login == null}">
			<a href="<%=pageContext.getServletContext().getContextPath() %>/member/login">로그인</a><br/>		<%-- 표현식 -> 상대 경로를 지정하려면 앞에 '/' 빼면 된다. context-root는 바뀔 수 있기 때문에 명시 안 하는게 좋다 --%>
		</c:if>
		<c:if test="${login != null}">
			<a href="<%=pageContext.getServletContext().getContextPath() %>/member/logout">로그아웃</a><br/>		<%-- 표현식 -> 상대 경로를 지정하려면 앞에 '/' 빼면 된다. context-root는 바뀔 수 있기 때문에 명시 안 하는게 좋다 --%>
		</c:if>
		2. <a href="${pageContext.servletContext.contextPath}/freeboard/list">자유 게시판</a><br/>			<%-- 표현 언어 -> 동적으로 context를 얻는 방법--%>
		3. <a href="${pageContext.servletContext.contextPath}/photoboard/list">포토 게시판</a><br/>
	</body>
</html>