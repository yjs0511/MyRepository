<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		데이터 찾기 및 이용 <hr/>
		[HttpServletRequest를 이용해서 찾기] <br/>
		
		데이터1 : <%=(String)request.getAttribute("data1") %><br/>  <%-- HttpServletRequest 객체로부터 data1이란 키로 값을 조회하라는 뜻 --%>		
		데이터2 : <%=(String)request.getAttribute("data2") %><br/>
		
		[HttpSession을 이용해서 찾기] <br/>
		데이터1 : <%=(String)session.getAttribute("data1") %><br/>
		데이터2 : <%=(String)session.getAttribute("data2") %><br/>
		
		[EL을 이용해서 찾기] <br/>	
		데이터1 : ${data1} <br/>	<%-- 이녀석은 HttpServletRequest 이 객체부터 조회해서 있으면 가져오고 없으면 --%>
		데이터2 : ${data2} <br/>	<%-- HttpSession 객체를 조회하여 찾는다. HttpServletRequest -> HttpSession 순으로 조회 --%>
	</body>
</html>