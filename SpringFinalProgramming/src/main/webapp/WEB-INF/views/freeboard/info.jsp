<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
	</head>
	<body>
		글내용
		<hr/>
			<table>
				<tr>
					<td style="background-color:orange; width:70px">번호</td>
					<td>
						${freeBoard.bno}
					</td>
				</tr>
				<tr>
					<td style="background-color:orange; width:70px">제목</td>
					<td>
						${freeBoard.btitle}
					</td>
				</tr>
				<tr>
					<td style="background-color:orange; width: 70px">내용</td>
					<td>
						<pre>${freeBoard.bcontent}</pre>	<%-- pre 태그는 개행 표시 --%>
					</td>
				</tr> 
				<tr>
					<td style="background-color:orange; width:70px">글쓴이</td>
					<td>
						${freeBoard.bwriter}
					</td>
				</tr>
				<tr>
					<td style="background-color:orange; width:70px">조회수</td>
					<td>
						${freeBoard.bhitcount}
					</td>
				</tr>
				<tr>
					<td style="background-color:orange; width:70px">날짜</td>
					<td>
						${freeBoard.bdate}
					</td>
				</tr>
				<tr>
					<td style="background-color:orange; width:70px">조회수</td>
					<td>
						${freeBoard.bdate}
					</td>
				</tr>
			</table>
			<div>
				<a href="modify?bno=${freeBoard.bno}">[수정]</a>
				<a href="remove?bno=${freeBoard.bno}">[삭제]</a>
				<a href="list">[목록]</a>
			</div>
	</body>
</html>