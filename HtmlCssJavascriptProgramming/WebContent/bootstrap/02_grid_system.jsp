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
			div{
				border: 1px solid gray;
			}
		</style>
	</head>
	<body><%-- 이거 들어갈까 --%>
		Gid System(Layout 작성)
		<hr/>
	<!-- <div class="row">
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
		<div class="col-md-1">.col-md-1</div>
	</div>
	<br/> -->
	
	<div class="row">
		<div class="col-xs-12 col-md-8">The Apache Tomcat® software is an open source implementation of the Java Servlet, JavaServer Pages, Java Expression Language and Java WebSocket technologies. The Java Servlet, JavaServer Pages, Java Expression Language and Java WebSocket specifications are developed under the Java Community Process.</div>
		<div class="col-xs-6 col-md-4">The Apache Tomcat® software is an open source implementation of the Java Servlet, JavaServer Pages, Java Expression Language and Java WebSocket technologies. The Java Servlet, JavaServer Pages, Java Expression Language and Java WebSocket specifications are developed under the Java Community Process.</div>
	</div><br/>
	
	 <div class="row">
		<div class="col-xs-6 col-md-4">.col-md-4</div>
		<div class="col-xs-3 col-md-4">.col-md-4</div>
		<div class="col-xs-3 col-md-4">.col-md-4</div>
	</div><br/>
	
	<div class="row">
		<div class="col-md-6">.col-md-6</div>
		<div class="col-md-6">.col-md-6</div>
	</div>
	
</body>
</html>