<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		로그인<hr/>
		<form method="post" > <%-- 액션 태그 안 쓰면 현재 요청 경로로 요청 / get, post 방식의 요청 경로가 같기 때문에 액션 태그를 꼭 안 써도 된다 --%>
			아이디: <input type="text" name="mid" value="${findMid}">
			<c:if test="${error == 'LOGIN_FAIL_MID'}"> *아이디가 존재하지 않습니다</c:if>
			<br/>
			패스워드: <input type="password" name="mpassword">
			<c:if test="${error == 'LOGIN_FAIL_MPASSWORD'}"> *패스워드를 잘못 입력했습니다</c:if>
			<br/>
			<input type="submit" value="로그인"><br/>
		</form>
		<a href="${pageContext.servletContext.contextPath}/member/join">회원 가입</a><br/>	
		<a href="findMid">아이디 찾기</a><br/>
	</body>
</html>