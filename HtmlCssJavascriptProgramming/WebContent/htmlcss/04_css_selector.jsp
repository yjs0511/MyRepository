<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<style type="text/css">
			/* *{color: red;} */
			#div4, #p1, #h1{background-color: orange;}
			div{background-color: yellow;}
			.div3{background-color: green;}
			#div2{background-color: aqua;}
			
			#div5 p{background-color: blue;}	/* div5 밑의 모든 p태그 */
			#div6 > p{background-color: fuchsia;}	/* div6 바로 밑의 p태그 */
			#div7 + p{background-color: maroon;}	/* div7 바로 다음(안 이라는 뜻이 아니다)에 나오는 P */
			
			[checked] { color: green}	/* 속성이 checked 인 모든 태그에 적용 */
			[selected=true] { color: aqua;}		/* selected 속성값이 true인 태그에 적용 */
			
			#form1 [checked] {background-color:green }
			
			a {color:black; text-decoration: none;}
			/* a:active {color: red;} */  /* 선택했을 때 */
			/* a:link {color:green;} */	/* 현재 방문되지 않은 링크 */
			a:hover {color:green; text-decoration: underline;}	/* 마우스를 갔다 댔을 때 */
			
			
		</style>
	</head>
	<body>
		CSS 선택자
		<hr />
		<div>A</div>
		<div id="div2" class="div3">B</div>
		<div class="div3">C</div>
		<div class="div3">D</div>
		<br/>
		<div id="div4">E</div>
		<p id="p1">F</p>
		<h3 id="h1">G</h3>
		
		<br/>
		
		<div id="div5">
			<p>A</p>
			<p>A</p>
		</div>
		
		<div id="div6">
			<div><p>A</p></div>
			<p>A</p>
		</div>
		
		<div id="div7"></div>	<!-- 잘 안쓴다 -->
		<p>A</p>
		<p>B</p>
		
		<div>
			<div checked="true"> A</div>
			<div checked="false"> B</div>
			<div selected="false"> C</div>
			<div selected="true"> D</div>
			<div selected="true"> E</div>
		</div>
		
		<form id="form1">
			<div checked="true">A</div>
			<div checked="false">B</div>
		</form>
		
		<br/>
		
		<div style="background-color: white">	<!-- 인 라인 스타일 / css가 아닌 스타일로 넣는 경우 -->
			<a href="http://www.naver.com">네이버</a><br/>
			<a href="http://tomcat.apache.org">톰캣</a><br/>
			<a href="http://www.w3c.org">W3C</a><br/>
		</div>
		
		
	</body>
</html>
