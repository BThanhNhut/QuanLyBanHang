<%@page import="java.util.List"%>
<%@page import="model.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style_header.css" />
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg bg">
			<a href="#" class="logo fs-3"><img src="./Image/logo.png"></a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="bx bx-menu"></span>
			</button>
			<% List <ChiTiet> lst_ct = (List <ChiTiet>) session.getAttribute("cart"); %>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a href="arnoldburger.jsp"
						class="nav-link mx-3 text-white">HOME</a></li>
					<li class="nav-item"><a href="arnoldburger.jsp"
						class="nav-link mx-3 text-white">ARNOLD BURGER</a></li>
					<li class="nav-item"><a href="menu.jsp"
						class="nav-link mx-3 text-white">MENU</a></li>
					<li class="nav-item"><a href="store.jsp"
						class="nav-link mx-3 text-white">STORES</a></li>
					<li class="nav-item"><a href="career.jsp"
						class="nav-link mx-3 text-white">CAREER</a></li>
					<li class="nav-item"><a href="contact.jsp"
						class="nav-link mx-3 text-white">CONTACT</a></li>
					<li class="nav-item"><a href="cart.jsp"
						class="nav-link mx-3 text-white"><img alt=""
							src="./Image/shopping-cart.png"><%=lst_ct != null ? lst_ct.size() : "0"%></a></li>
				</ul>
			</div>
		</nav>
	</header>
</body>
</html>