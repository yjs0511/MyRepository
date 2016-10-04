<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		Exam03
		<hr/>
		[회원가입 폼]<br>
		<form action="/myproject/exam03/join">
			아이디:<input type="text" name="mid" value="fall"><br>
			이름:<input type="text" name="mname" value="한가을"><br>
			비밀번호:<input type="password" name="mname" value="12345"><br>
			이메일:<input type="email" name="email" value="asd@naver.com"><br>
			전화번호: <input type="tel" name="mtel" value="010-1234-5667"><br>
			직업: 
				<input type="radio" name="mjob" checked="checked" value="대학생">
				<input type="radio" name="mjob" value="회사원">
				<input type="radio" name="mjob" value="공무원"><br>
			개발분야:
				<input type="checkbox" name="mskill" value="웹">웹개발
				<input type="checkbox" name="mskill" value="시스템">시스템
				<input type="checkbox" name="mskill" value="빅데이터">빅데이터
				<input type="checkbox" name="mskill" value="IoT">아이오티
			주소:
				<select name="maddress1">
					<option selected="selected">서울 특별시</option>
					<option>경기도</option>
					<option>부산 특별시</option>
					<option>대구 광역시</option>
				</select>
				
				<select name="maddress2">
						<option selected="selected">인천시</option>
						<option>수원시</option>
						<option>용인시</option>
						<option>부천시</option>
						<option>의왕시</option>
					</select>
			생년월일:<input type="date" name="mbirth" value="2016-01-21"><br/>
			<input type="image" src="/myproject/resources/image/Penguins.jpg" width="100px">
		</form>
		
		
		
	</body>
</html>