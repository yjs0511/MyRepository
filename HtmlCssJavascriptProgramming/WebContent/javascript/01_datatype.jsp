<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">
			var v1 = 10;
			var v2 = "자바스크립트";
			var v3 = true;
			var v4 = {name:"홍길동", age:27};	/* 자바스크립트 객체 선언 */
			var v5 = function(){};	/* 자바스크립트 함수 */
			var v6 = null;	
			var v7 = new Date();	/* 객체를 만들어서 대입 */
			var v8 = [1, 2, 3];		/* 자바스크립트 배열 */
			
		 	console.log("v1 : " + typeof(v1));
		 	console.log("v2 : " + typeof(v2));
		 	console.log("v3 : " + typeof(v3));
		 	console.log("v4 : " + typeof(v4));
		 	console.log("v5 : " + typeof(v5));
		 	console.log("v6 : " + typeof(v6));
		 	console.log("v7 : " + typeof(v7));
		 	console.log("v8 : " + typeof(v8));
		 	
		 	v1 = 3.14;
		 	v1 = "Java";
		 	v1 = "Java" + 8;
		 	console.log("v1 : " + typeof(v1));
		</script>
	</head>
	<body>
		데이터 타입
		<hr/>
		
				
	</body>
</html>