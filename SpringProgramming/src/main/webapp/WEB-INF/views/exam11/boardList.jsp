<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		<table style="border: 1px solid black; border-collapse: collapse; width: 600px;">	<%-- 행은 tr 열은 td, th(좀 더 굵게? 였던가? 어쨌든 뭔가 다르다) --%>
			<tr style="background-color: #ffcc0c">
				<td style="border: 1px solid black;">글쓴이</td> 
				<td style="border: 1px solid black;">제목</td> 
				<td style="border: 1px solid black;">내용</td> 
			</tr>
		
			
			<c:forEach var="board" items='${boardList}'>	<%-- 이 표현식은 null값이 들어가도 예외가 발생되지 않는다. --%> 
				<tr>
					<td style="border: 1px solid black;">${board.bwriter }</td> 
					<td style="border: 1px solid black;">${board.btitle }</td> 
					<td style="border: 1px solid black;">${board.bcontent }</td>
				</tr> 
			</c:forEach> 	<%--향상된 for문의 b와 같다, items는  List<Board> list = (List<Board>)request.getAttribute("boardlist") 이거와 같은 효과--%>
		</table>

	</body>
</html>