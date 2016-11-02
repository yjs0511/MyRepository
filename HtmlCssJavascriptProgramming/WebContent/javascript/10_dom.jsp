<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<script type="text/javascript">
			function onClickButton1(){
				console.log("onClickButton1() 실행");
				//var div1 = document.getElementById("div1");	/* id를 이용하여 요소를 찾아라 */
				var div1 = document.querySelector("#div1");
				console.log(div1);
				div1.innerHTML = "수정 내용";	// div 내용을 바꿔 치기 해준다
			}
			
			function onClickButton2(){
				console.log("onClickButton2() 실행");
				var imgArr = document.querySelectorAll(".photo");	/* id를 이용하여 요소를 찾아라 */
				imgArr[0].src="../common/image/Penguins.jpg";
			}
			
			function onClickButton3(){
				var mid;
				var mpassword;
				console.log("onClickButton3() 실행");
				
				
				// how1
				//mid = document.querySelector("#form1 [name=mid]").value;	/* id를 이용하여 요소를 찾아라 */
				//mpassword = document.querySelector("#form1 [name=mpassword]").value;	/* id를 이용하여 요소를 찾아라 */
				
				// how2
				mid = document.form1.mid.value;					// '.'으로 접근하는 방식은 name 속성이 반드시 있어야 한다.
				mpassword = document.form1.mpassword.value; 	// 쉬운 방법이지만 권장하지 않는다.
				
				/* console.log("mid : " + mid);
				console.log("mpassword : " + mpassword); */
				
				// 1차(클라이언트 단에서) 유효성 검사
				if(mid == ""){				// 값이 안 들어가면 일단 무조건 null
					alert("아이디를 입력하세요");		// 가장 안 좋고 허접하고 ㅆㄹㄱ 같은 방법
				}else if(mpassword == ""){
					alert("비빌번호 입력하세요.");
				}
				
				// 서버 전송
				//var form1 = document.querySelector("#form1")
				//form1.submit();
				
				document.form1.submit();
				
			}
		</script>
	</head>
	<body>
		DOM 사용
		<hr/>
		<button onclick="onClickButton1()">버튼1	</button>
		<div id="div1">최초 내용</div>
		
		<button onclick="onClickButton2()">버튼2	</button>
		<div>
			<img class="photo" src="../common/image/photo1.jpg" width="200px">
		</div>
		
		<button onclick="onClickButton3()">버튼3	</button>
		<div>
			<form id="form1" name="form1">
				아이디 : <input type="text" name="mid" value=""><br/>
				비밀번호 : <input type="password" name="mpassword" value=""><br/>  
			</form>
			
			<!-- <form id="form2" name="form2">
				아이디 : <input type="text" name="mid" value=""><br/>
				비밀번호 : <input type="password" name="mpassword" value=""><br/>  
			</form> -->
		</div>
	</body>
</html>