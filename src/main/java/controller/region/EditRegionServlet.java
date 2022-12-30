package controller.region;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Category;
import model.Region;
import model.User;

import java.io.IOException;

import dal.CategoryDAO;
import dal.RegionDao;

/**
 * Servlet implementation class EditRegionServlet
 */
public class EditRegionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditRegionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
			RegionDao cd = new RegionDao();
			Region c = cd.getById(id);
//			System.out.println(id);
			request.setAttribute("c", c);
			request.getRequestDispatcher("editRegion.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String slug = request.getParameter("slug");
		String id_raw = request.getParameter("id");
		System.out.println(id_raw);
//		System.out.println(name);
//		System.out.println(slug);
		try {
			int id = Integer.parseInt(id_raw);
			RegionDao cd = new RegionDao();
			Region c = new Region(id, name, slug);
			cd.edit(c);
			response.sendRedirect("region");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
