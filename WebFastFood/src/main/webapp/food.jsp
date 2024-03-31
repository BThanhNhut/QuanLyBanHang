<%@page import="database.MenuDAO"%>
<%@page import="model.Menu"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="java.util.Locale"%>
<%@page import="model.Menu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="./css/style_food.css">
</head>
<body>
	<div class="body">
		<div class="col-lg-10" style="padding: 0;">

			<div class="row row-3c">
				<!--Moi dong 3 cai-->
				<%
				List<Menu> lst_MonAn = (List<Menu>)session.getAttribute("lst_monan");
				NumberFormat vndFormat = NumberFormat.getNumberInstance(new Locale("Svi", "VN"));
				
				for(Menu item : lst_MonAn)
				{
				String formattedAmount = vndFormat.format(item.getGiaBan());
				%>
				<div class="col-lg-4 col-xs-6 col-6" id="abc">
                    <center class="item-block" onclick="OrderV3(134,'bogo')">
                        <a href="foodcontroller?id=<%=item.getId()%>&action=showdetail"><img src="./Image/<%=item.getHinh()%>" class="item-img shadow"></a>
                        <div class="item-name"><%= item.getTenMon() %></div>
                        <div class="item-price" style="color:#ec1e24 !important"><%=formattedAmount + "VNĐ"%></div>
                    </center>
                </div>
				<%
				}
				%>
				<div>
				xin chào = ${so}>
				</div>
			</div>
		</div>
	</div>
</body>
</html>