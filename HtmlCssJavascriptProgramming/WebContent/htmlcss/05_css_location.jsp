<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<!-- external style sheet (가장 많이 씀) -->
		<link rel="stylesheet" type="text/css" href="05_style.css">
		
		<!-- internal style sheet -->
		<style type="text/css">
			.menu{
				background-color: #ffffff;
			}
			
			.menu li{
				color:orange;
			}		
		</style>
	</head>
	<body>
		CSS Location
		<hr/>
		
		<header>제목</header>		<!-- 헤더 태그 쓰는 이유는 검색 엔진에서 찾기 편하게 하기 위해서 -->
		<p>내용</p>
		
		<a href="http://tomcat.apache.org">톰캣</a>
		
		<div class="menu">
			<ul>
				<li>menu1</li>
				<li>menu2</li>
				<li>menu3</li>
			</ul>
		</div>
		
		<div style="background-color: yellow; text-align: center;">
			본문 내용 입니다.
		</div>
				
	</body>
</html>
