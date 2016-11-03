<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">
			function checkMid(){
				var mid = document.querySelector("#mid");
				mid.value = mid.value.toLowerCase();
			}
			
			window.onload = function(){
				var input = document.querySelector("#mid");
				input.addEventListener("keypress", checkMid);
				input.addEventListener("change", checkMid);
			}
			
			/* function imgOver(){
				var img1 = document.querySelector("#img1");
				img1.src = "../common/image/Penguins.jpg";
			}
			
			function imgOut(){
				var img1 = document.querySelector("#img1");
				img1.src = "../common/image/photo1.jpg";
			} */
			
			function changeImg(img){	// 매개변수가 안들어오면 무조건 이벤트 객체가 들어온다
				var img = event.target 	// target은 event source (엘리먼트) 를 뜻 한다.
				if(event.type == "mouseover"){
					//console.log(event.type)
					img.src = "../common/image/Penguins.jpg";	// 이벤트가 발생하면 이벤트 객체가 만들어진다. 어떤 이벤트가 발생했는지 알려쥼
				}else if(event.type == "mouseout"){
					//console.log(event.type)
					img.src = "../common/image/photo1.jpg";
				}	
			}
			
			function changeImg2(event){	// 매개변수가 안들어오면 무조건 이벤트 객체가 들어온다
				var img = event.target; 	// target은 event source (엘리먼트) 를 뜻 한다.
				if(event.type == "mouseover"){
					//console.log(event.type)
					img.src = "../common/image/Penguins.jpg";	// 이벤트가 발생하면 이벤트 객체가 만들어진다. 어떤 이벤트가 발생했는지 알려쥼
				}else if(event.type == "mouseout"){
					//console.log(event.type)
					img.src = "../common/image/photo1.jpg";
				}	
			}
			
			window.addEventListener("load", function(){
				/* var img1 = document.querySelector("#img1"); */
				var img2 = document.querySelector("#img2");
				
				/* img1.addEventListener("mouseover", changeImg);
				img1.addEventListener("mouseout", changeImg); */
				
				img2.addEventListener("mouseover", changeImg2);	
				img2.addEventListener("mouseout", changeImg2);
			});
			
			function changeColor(div){
				if(event.type == "mouseover"){
					div.style.backgroundColor = "blue";
				}else if(event.type == "mouseout"){
					div.style.backgroundColor = "red";
				}	
			}
			
		/* 	window.onload = function(){
				document.querySelector("#img2").addEventListener("mouseover", imgOver);
				document.querySelector("#img2").addEventListener("mouseout", imgOut);
			} */
		</script>
	</head>
	<body>
		다양한 Event 처리
		<hr/>
		<h3>[Exam1]</h3>
		<form>
			<!-- <input id="mid" type="text" name="mid" onkeypress="checkMid()" onchange="checkMid()"> -->	<%-- 바뀔 때 마다 mid 확인 --%>
			
			<input id="mid" type="text" name="mid">
		</form>
		<br/>
		
		<h3>[Exam2]</h3>
		<!-- <img id="img1" src="../common/image/photo1.jpg" width="200px" onmouseover="imgOver()" onmouseout="imgOut()"><br><br> -->
		<img id="img1" src="../common/image/photo1.jpg" width="200px" onmouseover="changeImg(this)" onmouseout="changeImg(this)">
		<img id="img2" src="../common/image/photo1.jpg" width="200px">
		
		<h3>[Exam3]</h3>
		<div id="div1" style="width:200px; height: 200px; background-color: red;" onmouseout="changeColor(this)" onmouseover="changeColor(this)"></div>
	</body>
</html>