<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		게시물 상세 보기
		<hr/>
		제목 : ${board.btitle }<br/>	<%-- board 라는 객체의 getBtitle()을 호출한다. --%>
		내용 : ${board.bcontent }<br/>
		글쓴이 : ${board.bwriter }<br/>
	</body>
</html>