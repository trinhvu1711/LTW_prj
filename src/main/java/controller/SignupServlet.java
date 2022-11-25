package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.User;

import java.io.IOException;

import dal.UserDAO;

/**
 * Servlet implementation class SignupServlet
 */
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SignupServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("login").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String gmail = request.getParameter("user");
		String pass = request.getParameter("pass");
		if (gmail == null || pass == null) {
			request.setAttribute("msg", "signupError");
			request.getRequestDispatcher("form.jsp").forward(request, response);
		} else {
			try {
				UserDAO ud = new UserDAO();
				User u = ud.findByUser(gmail);
				if (u == null) {
					ud.signup(name, gmail, pass);
					request.setAttribute("msg", "signupSuccess");
					request.getRequestDispatcher("form.jsp").forward(request, response);
				} else {
					request.setAttribute("msg", "signupError");
					request.getRequestDispatcher("form.jsp").forward(request, response);
				}
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

}
