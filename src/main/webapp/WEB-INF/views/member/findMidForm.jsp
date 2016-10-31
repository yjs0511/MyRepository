<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		아이디 찾기<hr/>
		<form method="post" > <%-- 액션 태그 안 쓰면 현재 요청 경로로 요청 / get, post 방식의 요청 경로가 같기 때문에 액션 태그를 꼭 안 써도 된다 --%>
			이메일: <input type="email" name="memail">	${error} <br/>
			<input type="submit" value="찾기"> <br/>
		</form>	
	</body>
</html>