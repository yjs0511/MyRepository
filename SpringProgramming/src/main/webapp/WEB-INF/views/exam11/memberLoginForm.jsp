<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		[로그인 폼]<br/>
		<form method="post" action="/myapp/exam11/memberLogin">
			아 이 디   : <input type="text" name="mid" value="fall"> <br/> <%-- 파라미터 이름을 name으로 지정 --%>
			
			비밀번호: <input type="password" name="mpassword" value="hoho"> <br/>
			
			<input type="submit" value="로그인"/>
			
		</form>
	</body>
</html>