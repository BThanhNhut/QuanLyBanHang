<%@page import="java.util.Locale"%>
<%@page import="java.text.NumberFormat"%>
<%@page import="model.Menu"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Food Info</title>
<link rel="stylesheet" href="./css/style_foodinfo.css">
<script src="https://code.jquery.com/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="./js/addpage.js"></script>
</head>
<body>
	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- Trang có chứa dữ liệu động -->
	<%
	Menu product = (Menu) request.getAttribute("product");
	NumberFormat vndFormat = NumberFormat.getNumberInstance(new Locale("Svi", "VN"));
	String formattedAmount = vndFormat.format(product.getGiaBan());
	%>
	<div class="body">
		<div id="item-content-pop" class="row">
			<div class="col-lg-6">
				<img src="./Image/<%=product.getHinh()%>" id="imgAvatar"
					style="width: 100%">
			</div>
			<div class="col-lg-6">
				<div class="item-name" style="color: #ec1e24" id="lblName"><%=product.getTenMon()%></div>
				<div class="item-desc" id="lblDesc"></div>
				<!-- header -->
				<%-- <jsp:include page="side_dish.jsp"></jsp:include> --%>
				<!-- Trang có chứa dữ liệu động -->

				<br> <b class="item-note">Note:</b><br>
				<textarea id="txtNote" class="form-control" rows="3"></textarea>
				<hr>
				<form action="cartcontroller" method="get">
					<div id="quantity" style="display: flex; align-items: center;">
						Số lượng
						<div class="quantity-control">
							<button class="quantity-button" onclick="MinusQty()" type="button">-</button>
							<input min="1" type="number" id="txtNo" name="txtnumber"
								value="1" oninput="ChangeQtyS()" onkeyup="ChangeQtyS()"
								onchange="ChangeQtyS()" readonly>
							<button class="quantity-button" onclick="PlusQty()" type="button">+</button>
						</div>
						<div class="item-price" id="lblTotal"><%=formattedAmount + " VNĐ"%></div>
					</div>
					<!-- Gía trị ẩn -->
					<input type="hidden" name="id" value="<%=product.getId()%>"> 
					<input type="hidden" name="action" value="showcart">
					<p></p>
					<input type="submit" class="btn-buy" id="btn-add-to-cart" onclick="AddToCart()" value="Thêm vào giỏ hàng">
				</form>

			</div>
		</div>
	</div>

	<!-- footer -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- Trang có chứa dữ liệu động -->
</body>
<script>
	function MinusQty() {
		// Lấy giá trị hiện tại của input
		var txtNo = document.getElementById("txtNo");
		var currentVal = parseInt(txtNo.value);
		// Giảm giá trị nếu giá trị hiện tại lớn hơn 1
		if (currentVal > 1) {
			txtNo.value = currentVal - 1;
			ChangeQtyS(); // Gọi hàm để cập nhật giá trị
		}
	}

	function PlusQty() {
		// Lấy giá trị hiện tại của input
		var txtNo = document.getElementById("txtNo");
		var currentVal = parseInt(txtNo.value);
		// Tăng giá trị
		txtNo.value = currentVal + 1;
		ChangeQtyS(); // Gọi hàm để cập nhật giá trị
	}

	function ChangeQtyS() {
		// Tại đây, bạn có thể thực hiện các tác vụ cần thiết khi số lượng thay đổi,
		// ví dụ: cập nhật tổng giá trị hoặc gửi dữ liệu lên máy chủ.
		// Ví dụ: tính tổng giá trị dựa trên giá trị số lượng và giá sản phẩm.
		var txtNo = document.getElementById("txtNo");
		var lblTotal = document.getElementById("lblTotal");
		var giaban =
<%= product.getGiaBan()%>
	; // Lấy giá sản phẩm từ mã máy chủ
		var currentVal = parseInt(txtNo.value);
		var totalPrice = currentVal * giaban;
		
		var amountInVND = totalPrice.toLocaleString('vi-VN');

		lblTotal.textContent = amountInVND + "VNĐ"; // Cập nhật tổng giá trị
	}
</script>
</html>
