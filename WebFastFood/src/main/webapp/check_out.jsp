<%@page import="model.Menu"%>
<%@page import="java.util.List"%>
<%@page import="model.ChiTiet"%>
<%@page import="model.DonHangOnline"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--  -->
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<title>Check out</title>
<!-- Bootstrap core CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
	crossorigin="anonymous"></script>
<!-- Custom styles for this template -->
<link href="form-validation.css" rel="stylesheet">
</head>
<body>
	<!-- header -->
	<jsp:include page="header.jsp"></jsp:include>
	<!-- Trang có chứa dữ liệu động -->
	<br>
	<br>

	<%
	List<ChiTiet> lst_ct = (List<ChiTiet>)session.getAttribute("cart");
	%>
	<div class="container">
		<div class="row">
			<div class="col-md-4 order-md-2 mb-4">
				<h4 class="d-flex justify-content-between align-items-center mb-3">
					<span class="text-muted">Giỏ hàng</span> <span
						class="badge badge-secondary badge-pill">3</span>
				</h4>
				<ul class="list-group mb-3">
					<%
					if(lst_ct != null){
					for(ChiTiet item : lst_ct) {
					%>
					<li
						class="list-group-item d-flex justify-content-between lh-condensed">
						<!--for san pham-->
						<div>
							<h6 class="my-0"><%=item.getTenmon()%></h6>
							<!--ten san pham-->
							<small class="text-muted">X <%=item.getSl() %></small>
							<!--thuc an kem (neu co)-->
						</div> <span class="text-muted"><%=item.getGiaban()*item.getSl()%></span>
						<!--gia tien-->
					</li>
					
					<%
					}}
					%>
					<li class="list-group-item d-flex justify-content-between bg-light">
						<div class="text-success">
							<h6 class="my-0">Tiền ship</h6>
							<small></small> mã voucher
						</div> <span class="text-success">20.000 VNĐ</span> giá giảm
					</li>
					<%
					int total = 0;
					for(ChiTiet a : lst_ct)
					{
						total += a.getThanhtien();
					}
					%>

					<li class="list-group-item d-flex justify-content-between"><span>Tổng
							cộng</span> <strong><%=total + 20000 %></strong></li>
				</ul>

				<form class="card p-2">
					<div class="input-group">
						<input type="text" class="form-control" placeholder="VOUCHER">
						<div class="input-group-append">
							<button type="submit" class="btn btn-success">THÊM</button>
						</div>
					</div>
				</form>
			</div>
			<div class="col-md-8 order-md-1">
				<h4 class="mb-3">THÔNG TIN ĐƠN HÀNG</h4>
				<form class="needs-validation" novalidate method="get"
					action="checkoutcontroller">
					<div class="row">
						<div class="mb-3">
							<label for="firstName">Họ và tên</label> <input type="text"
								class="form-control" id="firstName" name="firstName"
								placeholder="" value="" required>
							<div class="invalid-feedback">Họ và tên là field bắt buộc</div>
						</div>

						<div class="mb-3">
							<label for="email">Email <span class="text-muted">(Bắt
									buộc)</span></label> <input type="email" class="form-control" name="email"
								id="email" placeholder="you@example.com">
							<div class="invalid-feedback">Vui lòng nhập email hợp lệ</div>
						</div>

						<div class="mb-3">
							<label for="Phone">Phone <span class="text-muted">(Bắt
									buộc)</span></label> <input class="form-control" name="phone" placeholder="01010101">
							<div class="invalid-feedback">sdt không hợp lệ</div>
						</div>

						<div class="mb-3">
							<label for="address">Địa chỉ</label> <input type="text"
								class="form-control" id="address" name="address"
								placeholder="140 Lê Trọng Tấn" required>
							<div class="invalid-feedback">Vui lòng nhập địa chỉ nhận
								hàng</div>
						</div>

						<div class="row">
							<div class="mb-3">
								<label for="country">Tỉnh thành</label> <select
									class="form-select mb-3" id="city" aria-label=".form-select-sm"
									required>
									<option value="" selected>Chọn tỉnh thành</option>
								</select>
								<div class="invalid-feedback">Vui lòng chọn Tỉnh Thành!</div>

								<label for="country">Quận</label> <select
									class="form-select mb-3" id="district"
									aria-label=".form-select-sm" required>
									<option value="" selected>Chọn quận huyện</option>
								</select>
								<div class="invalid-feedback">Vui lòng chọn Quận!</div>

								<label for="country">Phường</label> <select
									class="form-select mb-3" id="ward" aria-label=".form-select-sm"
									required>
									<option value="" selected>Chọn phường xã</option>
								</select>
								<div class="invalid-feedback">Vui lòng chọn Phường!</div>
							</div>
						</div>
						<hr class="mb-4">
						<input type="hidden" name="action" value="checkout">
						<button class="btn btn-primary btn-lg btn-block" type="submit">ĐẶT
							HÀNG</button>
				</form>
			</div>
		</div>
	</div>
	</div>
	<br>
	<br>
	<br>
	<!-- header -->
	<jsp:include page="footer.jsp"></jsp:include>
	<!-- Trang có chứa dữ liệu động -->
</body>
<!-- Bootstrap core JavaScript
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="../../../../../code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery-slim.min.js"><\/script>')</script>
<script src="../../assets/js/vendor/popper.min.js"></script>
<script src="../../dist/js/bootstrap.min.js"></script>
<script src="../../assets/js/vendor/holder.min.js"></script>
<script>
      // Example starter JavaScript for disabling form submissions if there are invalid fields
      (function() {
        'use strict';

        window.addEventListener('load', function() {
          // Fetch all the forms we want to apply custom Bootstrap validation styles to
          var forms = document.getElementsByClassName('needs-validation');

          // Loop over them and prevent submission
          var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
              if (form.checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
              }
              form.classList.add('was-validated');
            }, false);
          });
        }, false);
      })();
    </script>

<script
	src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.21.1/axios.min.js"></script>
<script>
  var citis = document.getElementById("city");
  var districts = document.getElementById("district");
  var wards = document.getElementById("ward");
  var Parameter = {
    url: "https://raw.githubusercontent.com/kenzouno1/DiaGioiHanhChinhVN/master/data.json", 
    method: "GET", 
    responseType: "application/json", 
  };
  var promise = axios(Parameter);
  promise.then(function (result) {
    renderCity(result.data);
  });

  function renderCity(data) {
    for (const x of data) {
    citis.options[1] = new Option("Thành phố Hồ Chí Minh", 79);
  }
  citis.onchange = function () {
  district.length = 1;
  ward.length = 1;
    if(this.value != ""){
      const result = data.filter(n => n.Id === this.value);
      for (const k of result[0].Districts) {
        district.options[district.options.length] = new Option(k.Name, k.Id);
      }
    }
  };
  district.onchange = function () {
    ward.length = 1;
    const dataCity = data.filter((n) => n.Id === citis.value);
    if (this.value != "") {
      const dataWards = dataCity[0].Districts.filter(n => n.Id === this.value)[0].Wards;

      for (const w of dataWards) {
        wards.options[wards.options.length] = new Option(w.Name, w.Id);
      }
    }
  };
  }
</script>
</html>