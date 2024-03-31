<%@page import="model.ChiTiet"%>
<%@page import="java.util.List"%>
<%@page import="model.DonHangOnline"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ARNOLD</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="./css/style_cart.css" />
</head>
<body>
    <!-- header -->
    <jsp:include page="header.jsp"></jsp:include>
    <!-- Trang có chứa dữ liệu động -->
    <br>
    <br>
    <div class="body">
        <div class="container px-3 my-5 clearfix">
            <div class="card">
                <div class="card-header">
                    <h2>Giỏ hàng</h2>
                </div>
                <%
                List <ChiTiet> lst_ct = (List <ChiTiet>) session.getAttribute("cart");
                %>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered m-0">
                            <thead>
                                <tr>
                                    <th class="text-center py-3 px-4" style="min-width: 400px;">Tên sản phẩm &amp; Đồ ăn kèm</th>
                                    <th class="text-right py-3 px-4" style="width: 100px;">Giá bán</th>
                                    <th class="text-center py-3 px-4" style="width: 120px;">Số lượng</th>
                                    <th class="text-right py-3 px-4" style="width: 100px;">Tổng</th>
                                    <th class="text-center align-middle py-3 px-0" style="width: 40px;"><a href="#" class="shop-tooltip float-none text-light" title data-original-title="Clear cart"><i class="ino ion-md-trash"></i></a></th>
                                </tr>
                            </thead>
                            <tbody>
                            <%
                            if (lst_ct != null) {
                                for (ChiTiet item : lst_ct) {
                            %>
                                <tr>
                                    <td class="p-4">
                                        <div class="media align-items-center">
                                            <img src="Image/<%=item.getHinh()%>" class="d-block ui-w-40 ui-bordered mr-4" alt>
                                            <div class="media-body">
                                                <a href="#" class="d-block text-dark"><%=item.getTenmon()%></a>
                                                <small> <span class="text-muted">Đồ ăn kèm (nếu có): </span></small>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="text-right font-weight-semibold align-middle p-4"><%=item.getGiaban()%></td>
                                    <td class="align-middle p-4"><input type="text" class="form-control text-center" value="<%=item.getSl()%>"></td>
                                    <td class="text-right font-weight-semibold align-middle p-4"><%=item.getThanhtien()%></td>
                                    <td class="text-center align-middle px-0"><a href="cartcontroller?action=delete&id_xoa=<%=item.getId_mon()%>" class="shop-tooltip close float-none text-danger" title data-original-title="Remove">×</a></td>
                                </tr>
                            <%
                                }
                            } else {
                            %>
                                <tr>
                                    <td colspan="5">
                                        <div style="color: red;">Không có sản phẩm nào</div>
                                    </td>
                                </tr>
                            <%
                            }
                            %>
                            </tbody>
                        </table>
                    </div>

                    <div class="d-flex flex-wrap justify-content-between align-items-center pb-4">
                        <div class="mt-4">
                            <label class="text-muted font-weight-normal" style="display: none;">VOUCHER</label>
                            <input type="text" placeholder="ABC" class="form-control" style="display: none;">
                        </div>
                        <div class="d-flex">
                            <div class="text-right mt-4">
                                <label class="text-muted font-weight-normal m-0">Tổng tiền</label>
                                <div class="text-large">
                                <%
                                int total = 0;
            					for(ChiTiet a : lst_ct)
            					{
            						total += a.getThanhtien();
            					}
                                %>
                                    <strong><%=lst_ct != null ? total : "0.00"%></strong>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="float-right">
                        <a href="arnoldburger.jsp"><button type="button" class="btn btn-lg btn-default md-btn-flat mt-2 mr-3">MUA TIẾP</button></a>
                        <a href="check_out.jsp"><button type="button" class="btn btn-lg btn-primary mt-2">THANH TOÁN</button></a>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- footer -->
    <jsp:include page="footer.jsp"></jsp:include>
    <!-- Trang có chứa dữ liệu động -->
</body>
<script src="https://code.jquery.com/jquery-1.10.2.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.1/dist/js/bootstrap.bundle.min.js"></script>
</html>
