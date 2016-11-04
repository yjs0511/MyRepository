<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript" src="../common/jquery-1.12.4.min.js"></script>
		<script type="text/javascript">
			$(function() {
				$("#btn1").on("click", function(){
					$.ajax({	// ajax()는 $객체의 메소드
						url: "06_data1.jsp",		// 이 요청을 하면
						success: function(data){	// 응답이 언제 올지 모르지만 성공하면 이 함수가 실행한다
													// 매개변수 data에는 HTML 조각이 들어있다 (특정 일부분에 들어가는 html) xml, json 도 요청할 수 잇다
													// 단, html 조각의 경우 고정된 모양을 사용하기 때문에 바꿀 수가 없다. json + 자바스크립트 권장 ㅋ
													// 이거 옵션이래.....;;
								console.log(data);
								$("#div1").html(data);
						}
					});	
				});
			});
			
			function checkMid(){
				var mid = $("#mid").val();	// mid 엘리먼트의 안의 내용을 가져와라
				$.ajax({
					url:"06_data2.jsp",
					//data: "mid=" + mid,
					data: {"mid":mid},	// 왼쪽은 요청파라미터 이름, 오른쪽 요청 파라미터 값
					success: function(data){
						console.log(data.trim());	//trim() 공백 제거
						if(data.trim() == "true"){
							$("#btn2Result").html("사용할 수 있음");
						}else{
							$("#btn2Result").html("사용할 수 없음");
						}
					}
				});
			}
			
			function getAd(kind, keyword){
				$.ajax({
					url: "06_data3.jsp",
					data: {"kind":kind, "keyword":keyword},	// 여러 데이터를 객체 형태로 넘길 수 있다.
					//method:	"post"				// get or post(요청 방식)
					success: function(data){
						$("#div3").html(data);
					}
				});
			}
			
			function getJson(){
				$.ajax({
					url: "06_data4.jsp",
					//method:	"post"				// get or post(요청 방식)
					success: function(data){
						var html = '<table style="width: 600px;">';
							html += '<tr>';
							html += '	<td>';
							for (var i = 0; i <data.length; i++) {
								html += 		'<div style="width:120px; height:130px; margin:5px; display:inline-block; background-image: url('+ data[i].aimg +'); background-size: 120px 130px">';
								html += 			'<div>';
								html += 				'<table style="width: 100%; height: 30px; background-color: black; opacity: 0.5">';
								html += 					'<tr>';
								html += 						'<td style="text-align: left; color: white">'+ data[i].alocation +'</td>';
								html += 						'<td style="text-align: right; color: aqua">'+ data[i].ahitcount +'</td>';
								html += 					'</tr>';
								html += 				'</table>';
								html += 			'</div>';
								html += 		'</div>' ;
							}
							html += 	'</td>';
							html += '</tr>';
							html += '</table>';
							$("#div4").html(html);
					}
				});
			}
			
		</script>
	</head>
	<body>
		AJAX 통신
		<hr/>
		
		<button id="btn1">버튼1</button>
		<div id="div1" style="height:100px; border:1px solid black;"></div>	<!-- data 의 html 조각을 이 엘리먼트 안에 넣겠다 -->
		
		<br/><br/>
		
		<button id="btn2" onclick="checkMid()">아이디 중복 체크</button>
		<input id ="mid" type="text" name="mid">
		<span id="btn2Result"></span>
		
		<br/>
		<br/>
		
		<button id="btn3" onclick="getAd('book', 'java')">광고 정보 얻기</button>
		<div id="div3"></div>
		
		<br/>
		
		<button id="btn4" onclick="getJson()">Json 응답 이용</button>
		<div id="div4"></div>
	</body>
</html>