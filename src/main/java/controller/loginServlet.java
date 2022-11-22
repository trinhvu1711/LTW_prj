package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;

import dal.UserDAO;

/**
 * Servlet implementation class loginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("form.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String user = request.getParameter("email");
		String password = request.getParameter("password");
		String rem = request.getParameter("rem");

		Cookie cname = new Cookie("cname", user);
		Cookie cpass = new Cookie("cpass", password);
		Cookie crem = new Cookie("crem", rem);

		if (crem != null) {
			cname.setMaxAge(60 * 60 * 24 * 7);
			cpass.setMaxAge(60 * 60 * 24 * 7);
			crem.setMaxAge(60 * 60 * 24 * 7);
		} else {
			cname.setMaxAge(0);
			cpass.setMaxAge(0);
			crem.setMaxAge(0);
		}

		response.addCookie(cname);
		response.addCookie(cpass);
		response.addCookie(crem);

		UserDAO ud = new UserDAO();
		System.out.println("user " +user);
		System.out.println("pass "+password);
		User u = ud.get(user, password);
//		System.out.println(u);
		if (u == null || user =="" || password == "") {
			request.setAttribute("msg", "signinError");
			request.getRequestDispatcher("form.jsp").forward(request, response);
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("account", u);
			response.sendRedirect("dashboard");
		}
	}

}
