<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript" src="../common/jquery-1.12.4.min.js"></script>	<!-- 이게 더 많이 사용됨 -->
		<script type="text/javascript">
			window.onload = function(){
				console.log("0");
			}
		
			$(document).on("ready", function(){});
				console.log("1");
			$(document).ready(function(){
				console.log("2");
			});
			$(function(){
				console.log("3");
			});	// 이거랑 위에 2개랑 같데....
		</script>
	</head>
	
	<body>
		jQuery
		<hr/>
		<img src="../common/image/Penguins.jpg">
	</body>
</html>