<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="com.mycompany.myproject.exam07.*" %>
<%@ page import="java.util.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		데이터 찾기 및 이용<br/><br/>
		[HttpServletRequest를 이용해서 찾기]<br/>
		
		데이터1 : <%=(String) request.getAttribute("data1") %><br/>
		데이터2 : <%=(String) request.getAttribute("data2") %><br/><br/>
		
		[HttpSession을 이용해서 찾기]<br/>
		데이터1 : <%=(String) session.getAttribute("data1") %><br/>
		데이터2 : <%=(String) session.getAttribute("data2") %><br/><br/>
		
		[El을 이용해서 찾기]<br/>
		데이터1 : ${data1} <br/>
		데이터2 : ${data2} <br/><br/>
		
		[객체의 속성(필드) 값 얻기]
		번호 : ${board.bno}<br/>
		제목 :${board.title }<br/>
		내용 :${board.content }<br/>
		조회수 :${board.hitcount }<br/><br/>
		
		[컬렉션 이용하기]<br/>
		
		<table style="border: 1px solid black; border-collapse: collapse; width: 600px">
			<tr style="background-color: #ffcc0c">
				<td style="border: 1px solid black">번호</td>
				<td style="border: 1px solid black">제목</td>
				<td style="border: 1px solid black">내용</td>
				<td style="border: 1px solid black">조회수</td>
			</tr>
			
		<c:forEach var="b" items='${boardlist }'>
			<tr>
				<td style="border : 1px solid black;">${b.bno}</td>
				<td style="border : 1px solid black;">${b.title}</td>
				<td style="border : 1px solid black;">${b.content}</td>
				<td style="border : 1px solid black;">${b.hitcount}</td>
			</tr>
		</c:forEach>
			
		
		</table>
	</body>
</html>


<%-- jsp는 톰캣에 의해 자바로 변환된다. request와 session, out, response 같은 객체는 jsp에서
	 따로 선언 안해도 지역 변수로서 자동으로 선언된다. --%>