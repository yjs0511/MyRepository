<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		Exam03
		<hr/>
		[회원 가입 폼]<br/>
		<form action="/myapp/exam03/join">
			아 이 디   : <input type="text" name="mid" value="fall"> <br/> <%-- 파라미터 이름을 name으로 지정 --%>
			 이     름    : <input type="text" name="mname" value="한가을"> <br/>
			비밀번호: <input type="password" name="mpassword" value="hoho"> <br/>
			이 메 일 : <input type="email" name="email" value="aaa@aaa.com"> <br/>
			전화번호: <input type="tel" name="mtel" value="010-2222-3333"> <br/>
			직    업: 
					<input type="radio" name="mjob" checked="checked" value="대학생">대학생
				    <input type="radio" name="mjob" value="회사원"> 회사원
				    <input type="radio" name="mjob" value="공무원">공무원<br/> 
			개발분야 : 
					<input type="checkbox" name="mskill" value="웹">웹개발
					<input type="checkbox" name="mskill" value="시스템">시스템 개발
					<input type="checkbox" name="mskill" value="빅데이터">빅데이터 개발
					<input type="checkbox" name="mskill" value="IoT">IoT 개발 <br/> <%-- skill=웹개발&skill=시스템개발&skill=빅데이터개발 ... 이런식으로 받는다--%>
			주소 : 
					<select name="maddress1">
						<option>서울특별시</option>
						<option selected="selected">경기도</option>
						<option>부산특별시</option>
						<option>대구광역시</option>
					</select> -
					<select name="maddress2">
						<option>인천시</option>
						<option>수원시</option>
						<option selected="selected">용인시</option>
						<option>부천시</option>
						<option>의왕시</option>
					</select>
					 <br/>		
			<%-- 
			<input type="submit" value="가입">	
			<button>가입</button> 
			--%> <%-- jsp일 경우 주석을 --%를 사용하라 <-- --> 이걸 쓰면 톰캣이 jsp를 java로 변환하기 때문에 저 내용도 브라우저에 보여진다 --%>
			<%-- -- 둘의 기능이 같다 --%>	 
			생년월일: <input type="date" name="mbirth" value="2016-09-29"><br/>
			<input type="image" src="/myapp/resources/image/join.png" width="100px">
		</form>
	</body>
</html>