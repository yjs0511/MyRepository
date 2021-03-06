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
		5. <a href="/myapp/exam05/index">Exam05</a>: 요청 처리 메소드의 리턴 타입<br>
		6. <a href="/myapp/exam06/index">Exam06</a>: 요청 처리 메소드 매개 변수 타입<br>
		7. <a href="/myapp/exam07/index">Exam07</a>: 컨트롤러에서 JSP로 데이터 객체 전달<br>
		8. <a href="/myapp/exam08/index">Exam08</a>: 리다이렉트<br/>
		
		<br/>
		
		9. <a href="/myapp/exam09/index">Exam09</a> : 의존성 주입(DI): XML 설정 파일 이용<br/>
		10. <a href="/myapp/exam10/index">Exam10</a> : 의존성 주입(DI): 어노테이션 이용<br/>
		11. <a href="/myapp/exam11/index">Exam11</a> : 서비스 계층과 데이터(퍼시스턴스) 계층<br/>
		12. <a href="/myapp/exam12/index">Exam12</a> : 커넥션 풀 설정<br/>
		13. <a href="/myapp/exam13/index">Exam13</a> : jdbcTemplate을 이용한 DAO <br/><br/>
		
	</body>
</html>