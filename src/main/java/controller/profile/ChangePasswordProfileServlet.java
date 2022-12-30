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
 * Servlet implementation class ChangePasswordProfileServlet
 */
public class ChangePasswordProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChangePasswordProfileServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendRedirect("profile");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String npass = request.getParameter("npass");
		String opass = request.getParameter("opass");
		String rpass = request.getParameter("rpass");
		String username = request.getParameter("username");
		String name = request.getParameter("name");
		UserDAO ud = new UserDAO();
		if (rpass == null || rpass == "" || npass == null || npass == "" || opass == "" || opass == null) {
			HttpSession session = request.getSession();
			session.setAttribute("msg", "nullError");
			response.sendRedirect("userprofile");
			return;
		}
		if (!rpass.equals(npass)) {
			HttpSession session = request.getSession();
			session.setAttribute("msg", "notDuplicatecpass");
			response.sendRedirect("userprofile");
			return;
		}
		if (npass.equals(opass)) {
			HttpSession session = request.getSession();
			session.setAttribute("msg", "duplicateopass");
			response.sendRedirect("userprofile");
			return;
		}
		if (ud.get(username, opass) == null) {
			HttpSession session = request.getSession();
			session.setAttribute("msg", "opassFail");
			response.sendRedirect("userprofile");
			return;
		} else {
			User u = new User(username, npass, name, 2);
			ud.changePassword(u);
			HttpSession session = request.getSession();
			session.setAttribute("account", u);
			session.setAttribute("msg", "success");
			response.sendRedirect("userprofile");
		}
	}

}
