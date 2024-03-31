<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chichken</title>
<link rel="stylesheet" href="./css/style_food.css">
</head>
<body>
	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- Trang có chứa dữ liệu động -->

	<div id="top-banner">
		<video src="./img/video-banner-chicken.mp4"
			poster="./img/banner-chicken.jpg" autoplay="autoplay" muted=""
			width="100%" loop="loop">
		</video>
	</div>
	
	<!-- submenu -->
	<jsp:include page="submenu.jsp"></jsp:include>
	<!-- Trang có chứa dữ liệu động -->
	
	<!-- foods -->
	<jsp:include page="food.jsp"></jsp:include>
	<!-- Trang có chứa dữ liệu động -->
	
	<!-- footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- Trang có chứa dữ liệu động -->
</body>
</html>