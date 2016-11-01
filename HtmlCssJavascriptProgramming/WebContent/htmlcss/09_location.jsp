<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<style type="text/css">
			#div1{
				position: absolute;
				left: 100px;
				top: 200px;
				width: 100px;
				height: 100px;
				background-color: red;
			}
			
			#div2{
				width: 100px;
				height: 100px;
				background-color: blue;
			}
			
			#div3{
				position: fixed;
				left: 300px;
				top: 200px;
				width: 100px;
				height: 100px;
				background-color: red;
			}
			
			#div4{
				position: relative;
				left: 500px;	/* 의미 없다 */
				top: 100px;		/* 얘도 */
				width: 300px;
				height: 300px;
				border: 1px solid black;
			}
			
			#div5{
			position: absolute;
				width: 50px;
				height: 50px;
				background-color: green;
				left: 150px;
				top: 150px;
			}
		</style>
	</head>
	<body>
		<div id="div1"></div>
		<div id="div2"></div>
		<div id="div3"></div>
		<div id="div4">
			<div id="div5"></div>
		</div>
		
		<%for(int i=0; i<30; i++){ %>
		<br/>
		<%} %>
	</body>
</html>