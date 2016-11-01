<%@ page contentType="text/html; charset=UTF-8"%>	<!-- 1) 파일 저장 인코딩 지정 (아래 방식과 같다) / 2) HTML 내용이 어떤 문자셋으로 작성되었는지(브라우저에 전달할 목적) -->
<%@ page pageEncoding="UTF-8" %>	<!-- 파일로 저장할 때 어떤 인코딩셋을 적용할지 (UTF-8은 한글을 3바이트로/ EUC-KR은 한글을 2바이트로 저장) / 위의 1) 방식만 적용-->
<!DOCTYPE html>
<html>
	<head>	
		<meta charset="UTF-8">		<!-- 프로그램에서 사용하는 데이터(body 안에 있는 데이터가 UTF-8 이라는 뜻) / 브라우저에 전달할 목적 2) 방식 -->
									<!-- page contentType="text/html; charset=UTF-8" 의 2) 방식 적용 -->
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
		<link rel="stylesheet" type="text/css" href="../common/bootstrap-3.3/css/bootstrap.min.css">	<!-- min.css를 써라 (사이즈 줄이기 위한 거라고 했던가?) -->
		<script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="../common/bootstrap-3.3/js/bootstrap.min.js"></script>
		<style type="text/css">
		
			#header, #footer{
				padding: 1em;
				color: white;
				background-color: black;
				text-align: center;
				
			}
			
			#content #menu{
				background-color: orange;
				text-align: center;
				padding: 1em;
			}
			
			#content #center{
				flex : 1;
				padding : 1em;
			}
			
			#content #menu ul{
				list-style-type: none;
				padding : 0;
				height: 100%;
				flex:1;
				display: flex;
				flex-direction : column;
			}
		
			#container{
				height:96vh;	
			}
			
		</style>
	</head>
	<body><%-- 이거 들어갈까 --%>
	<div id="container" class="container-fluid">
		
		<div id="header" class="row">
			<div class="col-md-12">
				<div id="header"><h1>City Gallery</h1></div>
			</div>
		</div>
		
		<div id="content" class="row">
			<div id="menu" class="col-xs-12 col-md-2">
				<ul>
						<li><a href="#">London</a></li>
						<li><a href="#">Paris</a></li>
						<li><a href="#">Tokyo</a></li>
						<li><a href="#">Tokyo</a></li>
						<li><a href="#">Tokyo</a></li>
						<li><a href="#">Tokyo</a></li>
						<li><a href="#">Tokyo</a></li>
						<li><a href="#">Tokyo</a></li>
						<li><a href="#">Tokyo</a></li>
						<li><a href="#">Tokyo</a></li>
						<li><a href="#">Tokyo</a></li>
						<li><a href="#">Tokyo</a></li>
						<li><a href="#">Tokyo</a></li>
						<li><a href="#">Tokyo</a></li>
						<li><a href="#">Tokyo</a></li>
						<li><a href="#">Tokyo</a></li>
						<li><a href="#">Tokyo</a></li>
						<li><a href="#">Tokyo</a></li>
				</ul>
			</div>
			<div id="center" class="col-md-10">
				<h1>London</h1>
					<p>London is the capital city of England. It is the most populous
						city in the United Kingdom, with a metropolitan area of over 13
						million inhabitants.</p>
					<p>Standing on the River Thames, London has been a major
						settlement for two millennia, its history going back to its founding
						by the Romans, who named it Londinium.</p>
			</div>
		</div>
		
		<div id="footer" class="row">
			<div class="col-md-12">Copyright © W3Schools.com</div>
		</div>
	</div>	
	</body>
</html>