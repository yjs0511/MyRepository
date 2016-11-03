<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">
			function checkLoginForm(){
				console.log("checkLoginForm");
				var mid = document.querySelector("#mid").value;
				var mpassword = document.querySelector("#mpassword").value;
				
				if(mid == "" || mpassword == ""){
					alert("아이디 혹은 패스워드가 입력되지 않았습니다.");		//alert는 위치나 디자인을 바꿀 수가 없다
					return false;
				}else if(mid.length < 4 || mid.length > 10){
					alert("아이디의 길이가 맞지 않습니다.");
					return false;
				}else if(mpassword.length < 4 || mpassword.length > 10){
					alert("패스워드의 길이가 맞지 않습니다.");
					return false;
				}
				return true;	// submit 이벤트가 발생했을 때 어떤 문제가 발생하면 false를 리턴한다(엘리먼트에 / 여기선 form)
			}
		</script>
	</head>
	<body>
		유효성 검사 (입력 값 검사)
		<hr/>
		
		<form id="loginForm" onsubmit="return checkLoginForm()">	<!-- submit 이벤트가 발생됬을 때 이 함수가 실행되면 false 가 실행되는데 return 값을 false로 한다는 뜻 -->
			아이디 : <input id="mid" type="text" name="mid"/><br/>
			비밀번호 : <input id="mpassword" type="password" name="mpassword"/><br/>
			<input type="submit" value="로그인">	<!-- 이거 누른 순간 화면 갱신 -->
		</form>
	</body>
</html>