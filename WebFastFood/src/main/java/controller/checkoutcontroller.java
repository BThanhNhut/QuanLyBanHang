package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.internet.NewsAddress;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import database.ChiTietDonHangOnlineDAO;
import database.DonHangOnlineDAO;
import model.ChiTiet;
import model.ChiTietDonHangOnline;
import model.DonHangOnline;
import utils.Email;

/**
 * Servlet implementation class checkoutcontroller
 */
@WebServlet("/checkoutcontroller")
public class checkoutcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public checkoutcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if (action.equals("checkout")) {
			System.out.println("vao checkout");
			checkout(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void checkout (HttpServletRequest request, HttpServletResponse response)
	{
		String a = "";
		HttpSession session = request.getSession();
		List<ChiTiet> lst_chitiet = (List<ChiTiet>)session.getAttribute("cart");
		ChiTietDonHangOnlineDAO chitietdao = new ChiTietDonHangOnlineDAO();
		
		//
		int total = 0;
		for(ChiTiet item : lst_chitiet){
			total += item.getThanhtien() + 20000;
		}
		String diachi, hoten, sdt, email;
		hoten = request.getParameter("firstName");
		sdt = request.getParameter("phone");
		email = request.getParameter("email");
		diachi = request.getParameter("address");
		
		DonHangOnlineDAO dao = new DonHangOnlineDAO();
		int id_dho = dao.countDonHang()+1;
		System.out.println("id đơn hàng" + id_dho);
		DonHangOnline dho = new DonHangOnline(id_dho,new java.sql.Date(new Date().getTime()),diachi,hoten,sdt,total,"Thanh toán trực tiếp",0);
		dao.addDonHangOnline(dho);
		for(ChiTiet item : lst_chitiet)
		{
			ChiTietDonHangOnline ctdho = new ChiTietDonHangOnline(id_dho,item.getId_mon(),item.getSl(),item.getThanhtien(),item.getGiaban());;
			chitietdao.addChiTietDonHangOnline(ctdho);
			a += "(x" + item.getSl()+ ")" + item.getTenmon()+",";
		}
		session.removeAttribute("cart");
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/success.jsp");
		
		Email gui = new Email();
		String content = "<html><body>";
		content += "<h1>Xác nhận đơn hàng</h1>";
		content += "<p>Đặt hàng thành công, nhân viên sẽ liên hệ với bạn trong thời gian sớm nhất.</p>";
		content += "<p>Đơn hàng của bạn bao gồm: <span style='color: green;'>" + a + "</span></p>";
		content += "<p>Cảm ơn quý khách đã ủng hộ.</p>";
		content += "<img src='https://posapp.vn/wp-content/uploads/2022/02/menu.jpg' alt='Hình ảnh đơn hàng'>"; // Đặt URL hình ảnh tại đây
		content += "</body></html>";

		gui.sendEmail("bthanhnhut10@gmail.com", "ovlq sekg vgcf fbiu", email, "Xác nhận đơn hàng", content);

		
		
		
		
//		
//		Document donHangDocument  = new Document();
//		donHangDocument.append("id_dho", donhang.getIdDho());  
//		donHangDocument.append("ngaydat", new Date());  
//		donHangDocument.append("tongtien", donhang.getTongtien()+ 20000);
//		donHangDocument.append("phuongthucthanhtoan", "Thanh toán trực tiếp");
//		donHangDocument.append("tinhtranghoadon", 0);
//		donHangDocument.append("tienship", 20000);
//		donHangDocument.append("tiendo","Chờ duyệt");
//		for(ChiTiet ct : donhang.getChitiet())
//		{
//			Document item = new Document("id_mon", ct.getIdMon())
//			        .append("sl", ct.getSl())
//			        .append("giaban", ct.getGiaban())
//			        .append("tenmon", ct.getTenmon())
//			        .append("tongtien", ct.getGiaban()*ct.getSl());
//			lst_ct.add(item);
//			a += "(x" + ct.getSl()+ ")" + ct.getTenmon()+",";
//		}
//	
//		Document khachhang = new Document();
//		khachhang.append("diachi", diachi);
//		khachhang.append("hoten", hoten);
//		khachhang.append("sdt", sdt);
//		khachhang.append("email", email);
//		
//		System.out.println("thông tin khách hàng gồm" + diachi + hoten + sdt + email);
//		
//		donHangDocument.append("chitiet", lst_ct);
//		donHangDocument.append("khachhang", khachhang);
//		dao.addDonHang(donHangDocument);
//		
//		String content = "<html><body>";
//		content += "<h1>Xác nhận đơn hàng</h1>";
//		content += "<p>Đặt hàng thành công, nhân viên sẽ liên hệ với bạn trong thời gian sớm nhất.</p>";
//		content += "<p>Đơn hàng của bạn bao gồm: <span style='color: green;'>" + a + "</span></p>";
//		content += "<p>Cảm ơn quý khách đã ủng hộ.</p>";
//		content += "<img src='https://posapp.vn/wp-content/uploads/2022/02/menu.jpg' alt='Hình ảnh đơn hàng'>"; // Đặt URL hình ảnh tại đây
//		content += "</body></html>";
//
//		gui.sendEmail("bthanhnhut10@gmail.com", "ovlq sekg vgcf fbiu", email, "Xác nhận đơn hàng", content);
		
//		List<ChiTiet> lst_chitiet = new ArrayList<ChiTiet>();
//		donhang.setChitiet(lst_chitiet);
		
//		RequestDispatcher rd = getServletContext().getRequestDispatcher("/success.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
