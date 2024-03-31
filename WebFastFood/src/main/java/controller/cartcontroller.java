package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.DonHangOnlineDAO;
import database.MenuDAO;
import model.ChiTiet;
import model.ChiTietDonHangOnline;
import model.DonHangOnline;
import model.*;

/**
 * Servlet implementation class cartcontroller
 */
@WebServlet("/cartcontroller")
public class cartcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	private int tien_xoa;
	public cartcontroller() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getParameter("action");
		System.out.println("Vao 2");
		HttpSession session = request.getSession();
		if (action.equals("showcart")) {
			System.out.println("vao show card");
			showcard(request, response);
		} else if (action.equals("delete")) {
			System.out.println("vao xoa");
			delete(request, response);
		}
	}

	private void showcard(HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession();
		MenuDAO menuDAO = new MenuDAO();
		int soluong = Integer.valueOf(request.getParameter("txtnumber"));
		int id_mon = Integer.valueOf(request.getParameter("id"));
		Menu menu = menuDAO.getMenuById(id_mon);

		DonHangOnlineDAO donhangDAO = new DonHangOnlineDAO();
		int id_donhang = donhangDAO.countDonHang();

		if (session.getAttribute("cart") == null) {
//		DonHangOnline donhangonline = new DonHangOnline();
			List<ChiTiet> lst_chitiet = new ArrayList<ChiTiet>();
			ChiTiet ctdh = new ChiTiet();
//		donhangonline.setId(id_donhang+1);
			ctdh.setId_mon(id_mon);
			ctdh.setTenmon(menu.getTenMon());
			ctdh.setHinh(menu.getHinh());
			ctdh.setSl(soluong);
			ctdh.setGiaban(menu.getGiaBan());
			ctdh.setThanhtien(soluong * menu.getGiaBan());
			lst_chitiet.add(ctdh);
			session.setAttribute("cart", lst_chitiet);
		} else {
			List<ChiTiet> lst_chitiet = (List<ChiTiet>) session.getAttribute("cart");
			boolean check = false;
			for (ChiTiet ct : lst_chitiet) {
				if (ct.getId_mon() == menu.getId()) {
					ct.setSl(ct.getSl() + soluong);
					int tong = ct.getThanhtien() + menu.getGiaBan() * soluong;
					ct.setThanhtien(tong);
					check = true;
				}
			}
			if (check == false) {
				System.out.println("zo false");
				ChiTiet ctdh = new ChiTiet();
//				donhangonline.setId(id_donhang+1);
				ctdh.setId_mon(id_mon);
				ctdh.setTenmon(menu.getTenMon());
				ctdh.setHinh(menu.getHinh());
				ctdh.setSl(soluong);
				ctdh.setGiaban(menu.getGiaBan());
				ctdh.setThanhtien(soluong * menu.getGiaBan());
				lst_chitiet.add(ctdh);
			}
			session.setAttribute("cart",lst_chitiet);
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/cart.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public List<ChiTiet> removeItemById(List<ChiTiet> chiTietList, int idToRemove) {
		tien_xoa = 0;
	    Iterator<ChiTiet> iterator = chiTietList.iterator();
	    while (iterator.hasNext()) {
	        ChiTiet chiTiet = iterator.next();
	        if (chiTiet.getId_mon() == idToRemove) {
	            iterator.remove(); 
	            tien_xoa += chiTiet.getGiaban()*chiTiet.getSl();
	        }
	    }
	    return chiTietList; // Return the updated list
	}
	
	private void delete (HttpServletRequest request, HttpServletResponse response)
	{
		int id = Integer.valueOf(request.getParameter("id_xoa"));
		System.out.println("id xóa là " + id);
		HttpSession session = request.getSession();
		List<ChiTiet> lst = (List<ChiTiet>) session.getAttribute("cart");
		
		List<ChiTiet> late_lst = removeItemById(lst, id);
		session.setAttribute("cart", late_lst);
//		int tiensauxoa = donhang.getTongtien() - tien_xoa;
//		donhang.setTongtien(tiensauxoa);
		
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/cart.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
