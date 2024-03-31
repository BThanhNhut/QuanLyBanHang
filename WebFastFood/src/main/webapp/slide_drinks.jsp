<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Drinks</title>
<link rel="stylesheet" href="./css/style_food.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="./js/addpage.js"></script>
</head>
<body>

	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- Trang có chứa dữ liệu động -->
	<div id="top-banner">
		<img src="./img/banner-drink.jpg" class="img-banner">
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