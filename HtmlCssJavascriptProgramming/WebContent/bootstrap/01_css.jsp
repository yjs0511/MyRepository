<%@ page contentType="text/html; charset=UTF-8"%>	<!-- 1) 파일 저장 인코딩 지정 (아래 방식과 같다) / 2) HTML 내용이 어떤 문자셋으로 작성되었는지(브라우저에 전달할 목적) -->
<%-- <%@ page pageEncoding="UTF-8" %> --%>	<!-- 파일로 저장할 때 어떤 인코딩셋을 적용할지 (UTF-8은 한글을 3바이트로/ EUC-KR은 한글을 2바이트로 저장) / 위의 1) 방식만 적용-->
<!DOCTYPE html>
<html>
	<head>	
		<meta charset="UTF-8">		<!-- 프로그램에서 사용하는 데이터(body 안에 있는 데이터가 UTF-8 이라는 뜻) / 브라우저에 전달할 목적 2) 방식 -->
									<!-- page contentType="text/html; charset=UTF-8" 의 2) 방식 적용 -->
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
										<!-- meta name이 viewport로 되있으면 화면을 디바이스에 맞춘다 / 처음 화면을 확대 레벨 1로 주어서 축소(확대)하지 말라는 의미 / 사용자가 멀티터치로 확대 축소 시도 하더라도 크기를 변경하지 말라는 의미 -->
										<!-- 데스크탑에선 의미 없음 ㅋ -->	
		<link rel="stylesheet" type="text/css" href="../common/bootstrap-3.3/css/bootstrap.min.css">	<!-- min.css를 써라 (사이즈 줄이기 위한 거라고 했던가?) -->
		<script type="text/javascript" src="../common/js/jquery-1.12.4.min.js"></script>
		<script type="text/javascript" src="../common/bootstrap-3.3/js/bootstrap.min.js"></script>
	</head>
	<body><%-- 이거 들어갈까 --%>
		Bootstrap
		<hr/>
		[Button]
		<br/>
		<!-- Standard button -->
		<button type="button" class="btn btn-default">Default</button>
		
		<!-- Provides extra visual weight and identifies the primary action in a set of buttons -->
		<button type="button" class="btn btn-primary">Primary</button>
		
		<!-- Indicates a successful or positive action -->
		<button type="button" class="btn btn-success">Success</button>
		
		<!-- Contextual button for informational alert messages -->
		<button type="button" class="btn btn-info">Info</button>
		
		<!-- Indicates caution should be taken with this action -->
		<button type="button" class="btn btn-warning">Warning</button>
		
		<!-- Indicates a dangerous or potentially negative action -->
		<button type="button" class="btn btn-danger">Danger</button>
		
		<!-- Deemphasize a button by making it look like a link while maintaining button behavior -->
		<button type="button" class="btn btn-link">Link</button>
		<br/><br/>
		
		[Tables]
		<br/>
		<table class="table table-bordered">
			<tr class="success">
				<td>번호</td>
				<td>제목</td>
				<td>내용</td>
			</tr>
			<tr class="danger">
				<td>1</td>
				<td>제목1</td>
				<td>내용1</td>
			</tr>
			<tr class="info">
				<td>2</td>
				<td>제목2</td>
				<td>내용2</td>
			</tr>
		</table>
		
		[Image]
		<br/>
		<img src="../common/image/Penguins.jpg" class="img-rounded" width="100px" height="100px">
		<img src="../common/image/photo1.jpg" class="img-circle" width="100px" height="100px">
		<img src="../common/image/photo11.jpg" class="img-thumbnail" width="100px" height="100px"><br/><br/>
		
		[Icon]<br/>
		<span class="glyphicon glyphicon-search" aria-hidden="true"></span><br/><br/>
		
		[split button dropdowns]
		<br/>
		<!-- Split button -->
		<div class="btn-group">
		  	<button type="button" class="btn btn-danger">Action</button>
		  	<button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			    <span class="caret"></span>
			    <span class="sr-only">Toggle Dropdown</span>
		  	</button>
		<ul class="dropdown-menu">
		    <li><a href="#">Action</a></li>
		    <li><a href="#">Another action</a></li>
		    <li><a href="#">Something else here</a></li>
		    <li role="separator" class="divider"></li>
		    <li><a href="#">Separated link</a></li>
		</ul>
		</div>
		
	</body>
</html>