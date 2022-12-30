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
 * Servlet implementation class EditAdministrationServler
 */
public class EditAdministrationServler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditAdministrationServler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		User u = new UserDAO().get(username, password);
		request.setAttribute("u", u);
		request.getRequestDispatcher("editadministration.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String username = request.getParameter("email");
		String password = request.getParameter("password");
		String repassword = request.getParameter("repassword");
		String role_raw = request.getParameter("role");
		int role = 2;
		if (role_raw != null) {
			role = 1;
		}
		if ( password == null || password == "") {
			request.setAttribute("msg", "nullError");
			request.getRequestDispatcher("editadministration.jsp").forward(request, response);
			System.out.println("lol");
			return;	
		}
		if (repassword.equals(password)) {
			UserDAO ud = new UserDAO();
			ud.delete(username);
//			User user = new User(username, password, name, role);
			ud.signup(name, username, password);
			response.sendRedirect("adminisstration");
		}
	}

}
