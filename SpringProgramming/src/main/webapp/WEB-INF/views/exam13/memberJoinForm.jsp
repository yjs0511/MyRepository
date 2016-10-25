<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		[회원 가입 폼]<br/>
		<form method="post" action="/myapp/exam13/memberJoin">
			아 이 디   : <input type="text" name="mid" value="winter"> <br/> <%-- 파라미터 이름을 name으로 지정 --%>
			이    름    : <input type="text" name="mname" value="야인마"> <br/>
			비밀번호: <input type="password" name="mpassword" value="help me"> <br/>
			나이: <input type="number" name="mage" value="27"> <br/>
			생년월일 : <input type="date" name="mbirth" value="2016-12-08"> <br/><br/>
			
			<input type="submit" value="회원가입">	
			
		</form>
	</body>
</html>