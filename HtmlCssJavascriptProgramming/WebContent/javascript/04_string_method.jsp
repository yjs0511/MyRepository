<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		String 객체의 메소드
		<hr/>
		<script type="text/javascript">
			var v1 = "hello world"
			console.log("v1의 길이 : " + v1.length)
			
			var v2 = "Javascript is easy";
			console.log(v2.indexOf("easy"));
			console.log(v2.indexOf("spting"));
			console.log(v2.search("easy"));
			
			var v3 = "123456-9876543";
			console.log(v3.substring(0, 6));
			console.log(v3.substr(0, 6));
			
			console.log(v3.substring(7, 14));
			console.log(v3.substr(7, 7));
			console.log(v3.charAt(7));
			
			var str = "Please visit Microsoft!";
			var v5 = str.replace("Microsoft", "W3schools");
			console.log(v5);
			
			var v6 = "10:20:30";
			var v7 = v6.split(":");
			
			console.log(v7[0]);
			console.log(v7[1]);
			console.log(v7[2]);
		</script>
	</body>
</html>