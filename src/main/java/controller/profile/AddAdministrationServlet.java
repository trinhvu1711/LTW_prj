package controller.profile;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;

import dal.UserDAO;

/**
 * Servlet implementation class AddAdministrationServlet
 */
public class AddAdministrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddAdministrationServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String gmail = request.getParameter("email");
		String pass = request.getParameter("password");
		String rpass = request.getParameter("repassword");

		if (gmail != null || pass != null) {
			UserDAO ud = new UserDAO();
			User u = ud.findByUser(gmail);
			if (u == null && !pass.equals(rpass)) {
				ud.signup(name, gmail, pass);
				response.sendRedirect("administration");
			}
		} else {
			request.getRequestDispatcher("addadministration.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String gmail = request.getParameter("email");
		String pass = request.getParameter("password");
		String rpass = request.getParameter("repassword");

		if (gmail != null || pass != null) {
			UserDAO ud = new UserDAO();
			User u = ud.findByUser(gmail);
			if (u == null && pass.equals(rpass)) {
				ud.signup(name, gmail, pass);
				response.sendRedirect("administration");
				return;
			}
		} 
		request.getRequestDispatcher("addadministration.jsp").forward(request, response);
		
	}

}
