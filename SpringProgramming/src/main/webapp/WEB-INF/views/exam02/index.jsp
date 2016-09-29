<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		Exam02
		<hr/>
		<a href="/myapp/exam02/join?mid=user1&mname=홍길동&mage=25">가입</a><br/>
		<a href="/myapp/exam02/login?id=user1&password=12345">로그인</a><br/>
		<!-- 요청 파라미터 -> ?뒤에 오는 mid(파라미터 이름)=user1(값) 이런 형태 -->
		<a href="/myapp/exam02/order?pid=user1&pname=마우스&pprice=50000&pcompany=삼성">주문</a><br/>
		<a href="/myapp/exam02/writer?bno=10&title=게시물제목&content=게시물내용">글쓰기</a><br/>
		<a href="/myapp/exam02/update?bno=10&title=게시물제목&content=게시물내용&count=3">글수정</a><br/>
		<a href="/myapp/exam02/send?bno=20&title=게시물제목&content=게시물내용&hitcount=6">보내기</a><br/>
		
	</body>
</html>