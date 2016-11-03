<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">
			function changeImg1(){
				var img1 = document.querySelector("#img1");
				img1.src="../common/image/Penguins.jpg";
			}
			
			function changeImg2(){
				var img2 = document.querySelector("#img2");
				img2.src="../common/image/Penguins.jpg";
			}
			
			function changeImg3(){
				var img3 = document.querySelector("#img3");
				img3.src="../common/image/Penguins.jpg";
			}
			
			window.onload = function(){
				var btn2 = document.querySelector("#btn2").onclick = changeImg2;	// 이벤트 소스 주고 만드는 방법
				
				var btn3 = document.querySelector("#btn3");
				/* btn3.addEventListener("click", function(){	// click 이라는 이벤트가 발생하면 함수를 실행하겠다
					var img3 = document.querySelector("#img3");
				img3.src = "../common/image/Penguins.jpg"
				});	 */
				
				btn3.addEventListener("click", changeImg3);		// 이벤트 이름과 메소드(괄호 넣으면 안된다)
																// 정확히 click 이라는 이벤트가 발생했을 때 changeImg3() 라는 메소드를 등록 시켜라
																// 게임 만들 때 많이 사용되는 방법
			};

			
			
			
			/* function init(){	// 이렇게 해도 된다.
				var img2 = document.querySelector("#img2");
				img2.src="../common/image/Penguins.jpg";
			} */
			
			/* 
			var btn2 = document.querySelector("#btn2");
			btn2.onclick = changeImg2;
			*/
			
			
			
			
			
			
			//button.onclick = changeImg1;
			
			/* window.onload = function(){
				console.log("window.onload");
			} */
		</script>
	</head>
	<body>	<%-- onload="init()" 여기에 이렇게 넣고 함수 호출 해도 된다. --%>
		Event 처리
		<hr/>
		<h3>[how1]</h3>		<!-- block 요소 -->
		<button onclick="changeImg1()">버튼1</button>	<br/>
		<img id="img1" width="200px">	
		
		<h3>[how2]</h3>		<!-- block 요소 -->
		<button id="btn2">버튼2</button>	<br/>
		<img id="img2" src="" width="200px">
		
		<h3>[how3]</h3>		<!-- block 요소 -->
		<button id="btn3">버튼3</button>	<br/>
		<img id="img3" src="" width="200px">
		
	</body>
</html>