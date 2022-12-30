package controller.category;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Category;
import model.User;

import java.io.IOException;

import dal.CategoryDAO;

/**
 * Servlet implementation class EditCategoryServlet
 */
public class EditCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditCategoryServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("account");
		if (u == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		request.setAttribute("account", u);
		String id_raw = request.getParameter("id");
		try {
			int id = Integer.parseInt(id_raw);
			CategoryDAO cd = new CategoryDAO();
			Category c = cd.getById(id);
//			System.out.println(id);
			request.setAttribute("c", c);
			request.getRequestDispatcher("editCategory.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String slug = request.getParameter("slug");
		String id_raw = request.getParameter("id");
		System.out.println(id_raw);
//		System.out.println(name);
//		System.out.println(slug);
		try {
			int id = Integer.parseInt(id_raw);
			CategoryDAO cd = new CategoryDAO();
			Category c = new Category(id, name, slug);
			cd.edit(c);
			response.sendRedirect("category");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
