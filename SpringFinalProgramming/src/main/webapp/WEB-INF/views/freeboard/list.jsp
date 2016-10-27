<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<style type="text/css">
			a{
				text-decoration:none;
				color:black;
			}
			
			a:hover{
			color:green;
			} 
		</style>
		
	</head>
	<body>
		자유 게시판
		<hr/>
		<c:if test="${login != null}">
			<a href="write">[글쓰기]</a>
		
		</c:if>
		
		<table style="border: 1px solid black; border-collapse: collapse; width: 600px; text-align: center;">	<%-- 행은 tr 열은 td, th(좀 더 굵게? 였던가? 어쨌든 뭔가 다르다) --%>
			<tr style="background-color: #ffcc0c">
				<td style="border: 1px solid black;">번호</td> 
				<td style="border: 1px solid black;">제목</td> 
				<td style="border: 1px solid black;">글쓴이</td>
				<td style="border: 1px solid black;">조회수</td> 
				<td style="border: 1px solid black;">날짜</td>  
			</tr>
		
			<c:forEach var="freeboard" items='${list}'>	<%-- 이 표현식은 null값이 들어가도 예외가 발생되지 않는다. --%> 
				<tr>
					<td style="border: 1px solid black; text-align: center;">${freeboard.bno}</td> 
					<td style="border: 1px solid black; text-align: center;">
						<a href="info?bno=${freeboard.bno}">
							${freeboard.btitle}
						</a>
					</td> 
					<td style="border: 1px solid black; text-align: center;">${freeboard.bwriter}</td>
					<td style="border: 1px solid black; text-align: center;">${freeboard.bhitcount}</td>
					<td style="border: 1px solid black; text-align: center;">${freeboard.bdate}</td>
				</tr> 
			</c:forEach> 	<%--향상된 for문의 b와 같다, items는  List<Board> list = (List<Board>)request.getAttribute("boardlist") 이거와 같은 효과--%>
		</table>
		
		<div style="width: 600px;">
			<a href="list?pageNo=1">[처음]</a>
				<c:if test="${groupNo>1}">
					<a href="list?pageNo=${startPageNo-1}">[이전]</a>
				</c:if>
				<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
					&nbsp;
					<a href="list?pageNo=${i}" 
						<c:if test="${pageNo==i}"> style="color:red"</c:if>>${i}
					</a>
					&nbsp;
				</c:forEach>
			<c:if test="${groupNo<totalGroupNo}">
					<a href="list?pageNo=${endPageNo+1}">[다음]</a>
			</c:if>	
			<a href="list?pageNo=${totalPageNo}">[맨끝]</a>	
		</div>
		
		
		<!-- <a href="#">1&nbsp;</a>	nbsp -- 스페이스 띄어쓰기
		<a href="#">2&nbsp;</a>
		<a href="#" style="color:red">3&nbsp;</a>
		<a href="#">4&nbsp;</a>
		<a href="#">5</a> -->
	</body>
</html>