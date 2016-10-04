<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		SpringProgramming
		<hr/>
		<!-- 1. <a href="http://localhost:8080/myapp/exam01/join">컨트롤러 및 요청 맵핑 메소드 작성</a><br/> --> <!-- 절대 경로 -->
		1. <a href="/myapp/exam01/index">Exam01</a>: 컨트롤러 및 요청 매핑 메소드 작성<br/> <!-- /myapp/... 이런식으로 쓰면 port번호까진 똑같다 (절대경로) -->
		<!-- 3. <a href="exam01/join">컨트롤러 및 요청 맵핑 메소드 작성</a><br/> --> <!-- http://localhost:8080/myapp/ 여기 까지 생략 (현재 페이지에서 추가적으로 썼기 때문에 상대경로) -->
		<!-- = 앞 뒤에 띄어쓰기 하지 말자 -->
		2. <a href="/myapp/exam02/index">Exam02</a>: 요청 파라미터 값 받기<br/>
		3. <a href="/myapp/exam03/index">Exam03</a>: 폼 입력 값 받기<br/>
		4. <a href="/myapp/exam04/index">Exam04</a>: 요청 방식별 처리<br/>
		 <a href="/myapp/exam04/board">게시판</a><br>
		5. <a href="/myapp/exam05/index">Exam05</a>: 요청 처리 메소드의 리턴 타입<br>
		6. <a href="/myapp/exam06/index">Exam06</a>: 요청 처리 메소드 매개 변수 타입<br>
		7. <a href="/myapp/exam07/index">Exam07</a>: 컨트롤러에서 JSP로 데이터 객체 전달<br>
		
		
	</body>
</html>