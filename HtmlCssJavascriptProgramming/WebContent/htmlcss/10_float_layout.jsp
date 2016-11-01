<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<style type="text/css">
		
			*{
				margin: 0;
				padding: 0;
			}
		
			div.container{
				width : 100%;
				/* margin : auto;  */
				border : 1px solid gray;
			}
			
			header, footer{
				padding: 1em;
				color: white;
				background-color: black;
				text-align: center;
			/* 	border : 1px solid gray; */
			}
			
			footer{
				clear: both;
			}
			
			nav{
				float: left;
				margin: 0px;
				padding:1em;
				background-color: orange;
				width:300px;
				border-right: 1px solid gray;
			}
			
			
			nav ul{
				list-style-type: none;
				padding : 0;
			}
			
			nav ul a{	/* nav 안의 ul 어딘가의 a */
				text-decoration: none;
			}
			
			article{
				margin-left: 170px;
				/* border-left: 1px solid gray; */
				padding: 1em;
				overflow: hidden;
				
			}
		</style>

	</head>
	<body>
	
		<div class="container">
	
			<header>
				<h1>City Gallery</h1>
			</header>
	
			<nav>
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
			</nav>
	
			<article>
				<h1>London</h1>
				<p>London is the capital city of England. It is the most populous
					city in the United Kingdom, with a metropolitan area of over 13
					million inhabitants.</p>
				<p>Standing on the River Thames, London has been a major
					settlement for two millennia, its history going back to its founding
					by the Romans, who named it Londinium.</p>
			</article>
	
			<footer>Copyright © W3Schools.com</footer>
	
		</div>

	</body>
</html>