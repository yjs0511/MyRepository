<%@ page contentType="text/html; charset=UTF-8"%>	<!-- 1) 파일 저장 인코딩 지정 (아래 방식과 같다) / 2) HTML 내용이 어떤 문자셋으로 작성되었는지(브라우저에 전달할 목적) -->
<%@ page pageEncoding="UTF-8" %>	<!-- 파일로 저장할 때 어떤 인코딩셋을 적용할지 (UTF-8은 한글을 3바이트로/ EUC-KR은 한글을 2바이트로 저장) / 위의 1) 방식만 적용-->
<!DOCTYPE html>
<html>
	<head>	
		<meta charset="UTF-8">		<!-- 프로그램에서 사용하는 데이터(body 안에 있는 데이터가 UTF-8 이라는 뜻) / 브라우저에 전달할 목적 2) 방식 -->
									<!-- page contentType="text/html; charset=UTF-8" 의 2) 방식 적용 -->
		<title>index</title>
	</head>
	<body><%-- 이거 들어갈까 --%>
		Bootstrap
		<hr/>
		1. <a href="01_css.jsp">부트스트랩 CSS 사용하기 ㅋ</a><br>
		2. <a href="02_grid_system.jsp">Gid System(Layout 작성)</a><br>
		3. <a href="03_layout.jsp">layout 작성</a><br>
	</body>
</html>