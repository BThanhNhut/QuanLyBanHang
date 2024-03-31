<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="./css/style_submenu.css">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script type="text/javascript" src="./js/animation.js"></script>
</head>
<body>
	<div class="body_menu">
		<div id="sub-menu">
			<div class="row">
				<a class="col" onmouseover="zoomIn(this)" onmouseout="zoomOut(this)">
					<img src="./img/submenu/new_submenu.png" />
				</a> <a class="col" onmouseover="zoomIn(this)"
					onmouseout="zoomOut(this)"
					href="foodcontroller?id=1&action=showfood"> <img
					src="./img/submenu/burger_submenu.jpg" />
				</a> <a class="col" onmouseover="zoomIn(this)"
					onmouseout="zoomOut(this)"
					href="foodcontroller?id=2&action=showfood"> <img
					src="./img/submenu/chicken_submenu.jpg" />
				</a> <a class="col" onmouseover="zoomIn(this)"
					onmouseout="zoomOut(this)"
					href="foodcontroller?id=5&action=showfood"> <img
					src="./img/submenu/bento_submenu.jpg" />
				</a> <a class="col" onmouseover="zoomIn(this)"
					onmouseout="zoomOut(this)"
					href="foodcontroller?id=6&action=showfood"> <img
					src="./img/submenu/snacks_submenu.jpg" />
				</a> 
			</div>
		</div>
	</div>
</body>