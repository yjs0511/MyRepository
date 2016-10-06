<%@ page contentType="text/html; charset=UTF-8"%>
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
	</body>
</html>


<%-- jsp는 톰캣에 의해 자바로 변환된다. request와 session, out, response 같은 객체는 jsp에서
	 따로 선언 안해도 지역 변수로서 자동으로 선언된다. --%>