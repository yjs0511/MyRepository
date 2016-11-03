<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- <script
		  src="https://code.jquery.com/jquery-1.12.4.min.js"
		  integrity="sha256-ZosEbRLbNQzLpnKIkEdrPv7lOy9C27hHQ+Xp8a4MxAQ="
		  crossorigin="anonymous">
		</script> -->
		<script type="text/javascript" src="../common/jquery-1.12.4.min.js"></script>	<!-- 이게 더 많이 사용됨 -->
		<script type="text/javascript">
		
			// 함수(객체) 대입
			var $ = function(selector){
				console.log("aaa");
				return document.querySelectorAll(selector);
			};
		
			// 동적 메소드 추가
			$.ajax = function(){	
				console.log("bbb");
			};
			
			function test(){
				$("#div1")[0].innerHTML = "수정내용";
				$.ajax();
			}
		</script>
	</head>
	<body>
		$는 함수형 객체
		<hr/>
		<button onclick="test()">버튼!</button>
		<div id="div1">최초내용</div>
		
		
	</body>
</html>