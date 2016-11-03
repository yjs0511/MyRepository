<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript" src="../common/jquery-1.12.4.min.js"></script>
		<script type="text/javascript">
			function test(){
				$("#div1").html("수정 내용");	// 배열로 객체를 가져온다.
			}
			
			function test2(){
				$(".div2").html("수정 내용");
				$(".div2").css("background-color", "#ffff00");
			}
			
			function test3(){
				$("#img3").attr("src", "../common/image/photo1.jpg");
			}
		</script>
	</head>
	<body>
		객체 찾기
		<hr/>
		<button onclick="test()">버튼!</button>
		<div id="div1">최초 내용</div>
		
		<button onclick="test2()">버튼!</button>
		<div class="div2">최초 내용</div>
		<div class="div2">최초 내용</div>
		<div class="div2">최초 내용</div>
		
		<button onclick="test3()">버튼3</button>		<br/>
		<img id="img3" src="../common/image/Penguins.jpg">
	</body>
</html>