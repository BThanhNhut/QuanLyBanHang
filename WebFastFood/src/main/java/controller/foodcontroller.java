package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import database.MenuDAO;
import model.Menu;

/**
 * Servlet implementation class foodcontroller
 */
@WebServlet("/foodcontroller")
public class foodcontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public foodcontroller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		if(action.equals("showfood")){
			showFoodbyid(request, response);
		}
		else if(action.equals("showdetail")){
			showdetail(request,response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	
	private void showFoodbyid(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Vao thanh cong");
		List<Menu> lst_menu = new ArrayList<>();
		MenuDAO menuDAO = new MenuDAO();
		HttpSession session = request.getSession();
		String url;

		int id = Integer.valueOf(request.getParameter("id"));
		lst_menu = menuDAO.getAllMenusById(id);
		session.setAttribute("lst_monan", lst_menu);
		System.out.println("ID là = " + id);
		if (id == 1) {
			url = "/slide_burger.jsp";
		} else if (id == 2) {
			url = "/slide_chicken.jsp";
		} else if (id == 5) {
			url = "/slide_bento.jsp";
		} else if (id == 6) {
			url = "/slide_snack.jsp";
		} else {
			url = "/slide_drinks.jsp";
		}
		RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void showdetail(HttpServletRequest request, HttpServletResponse response) {
		MenuDAO MenuDAO = new MenuDAO();
		int id = Integer.valueOf(request.getParameter("id"));

		Menu menu = MenuDAO.getMenuById(id);
		request.setAttribute("product", menu);

		RequestDispatcher rd = getServletContext().getRequestDispatcher("/food_info.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
//	
	

}
