<%@ page import="com.mycompany.myapp.exam07.*"%>
<%@ page import="java.util.*" %>
								<%-- '<%@'는  지시자를 사용하겠다는 의미 --%>
<%@ page contentType="text/html; charset=UTF-8"%>
													<%-- page 지시자는 이 페이지 전체에 영향을 미치는 속성을 설정할 수 있다 --%>
													<%-- 아래 페이지를 아무리 잘 작성해도 page의 속성을 잘 못 작성해 버리면 (contentType 속성을 잘못 작성하면) 브라우저가 다운로드를 시켜버린다. --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>	<%-- 우측의 네임 스페이스를 쓰고 싶으면 접두사로 'c'를 붙여라 보통 core는 c를 많이 붙인다 --%>
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
		<%-- '<%='는  어떤 값을 받겠다는 의미 --%>
		
		[HttpSession을 이용해서 찾기] <br/>
		데이터1 : <%=(String)session.getAttribute("data1") %><br/>
		데이터2 : <%=(String)session.getAttribute("data2") %><br/>
		
		[EL을 이용해서 찾기] <br/>	
		데이터1 : ${data1} <br/>	<%-- 이녀석은 HttpServletRequest 이 객체부터 조회해서 있으면 가져오고 없으면 --%>
		데이터2 : ${data2} <br/>	<%-- HttpSession 객체를 조회하여 찾는다. HttpServletRequest -> HttpSession 순으로 조회 --%>
		
		[객체의 속성(필드) 값 얻기] <br/>
		<%-- 
		번호 : ${board.bno}<br/>	여기서의 .은 getter 메소드를 호출하라는 의미 (board.getBno()와 같다)
		제목 : ${board.title }<br/>
		내용 : ${board.content }<br/>
		조회수 : ${board.hitcount } <br/> <br/> 
		--%>
		
		<%-- '<%'는 자바 코드를 실행하겠다는 의미 --%>
		<%Board board = (Board) request.getAttribute("board"); %>
		<%if(board != null){ %>
			번호 : <%=board.getBno() %><br/>	<!-- 여기서의 .은 getter 메소드를 호출하라는 의미 (board.getBno()와 같다) -->
			제목 : <%=board.getTitle() %><br/>
			내용 : <%=board.getContent() %><br/>
			조회수 : <%=board.getHitcount() %> <br/> 
		<%} %> 
		<br/>
		[컬렉션 이용하기] <br/>
		
		<table style="border: 1px solid black; border-collapse: collapse; width: 600px;">	<%-- 행은 tr 열은 td, th(좀 더 굵게? 였던가? 어쨌든 뭔가 다르다) --%>
		<tr style="background-color: #ffcc0c">
			<td style="border: 1px solid black;">번호</td> 
			<td style="border: 1px solid black;">제목</td> 
			<td style="border: 1px solid black;">내용</td> 
			<td style="border: 1px solid black;">조회수</td>
		</tr>
		
		<%List<Board> list = (List<Board>)request.getAttribute("boardlist");%>
		<%-- <%if(list!=null){ %>
			<%for(Board b : list){ %>
			<tr>
				<td style="border: 1px solid black;"><%b.getBno(); %></td> 
				<td style="border: 1px solid black;"><%b.getTitle(); %></td> 
				<td style="border: 1px solid black;"><%b.getContent(); %></td> 
				<td style="border: 1px solid black;"><%b.getHitcount(); %></td>
			</tr> 
			<%}%>
		<%}%>   --%>
		
		
		 <c:forEach var="b" items='${boardlist}'>	<%-- 이 표현식은 null값이 들어가도 예외가 발생되지 않는다. --%> 
			<tr>
			<tr>
				<td style="border: 1px solid black;">${b.bno }</td> 
				<td style="border: 1px solid black;">${b.title }</td> 
				<td style="border: 1px solid black;">${b.content }</td> 
				<td style="border: 1px solid black;">${b.hitcount }</td>
			</tr> 
		</c:forEach> 	<%--향상된 for문의 b와 같다, items는  List<Board> list = (List<Board>)request.getAttribute("boardlist") 이거와 같은 효과--%>
		</table>
	</body>
</html>