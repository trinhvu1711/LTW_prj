package controller.actor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Actor;
import model.Region;
import model.User;

import java.io.IOException;

import dal.ActorDao;
import dal.RegionDao;

/**
 * Servlet implementation class EditActorServlet
 */
public class EditActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditActorServlet() {
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
			ActorDao cd = new ActorDao();
			Actor c = cd.getById(id);
//			System.out.println(id);
			request.setAttribute("c", c);
			request.getRequestDispatcher("editActor.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("account");
		if (u == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		request.setAttribute("account", u);
		String name = request.getParameter("name");
		String slug = request.getParameter("slug");
		String id_raw = request.getParameter("id");
		String is_male_raw =request.getParameter("is_male");
		System.out.println(id_raw);
//		System.out.println(name);
//		System.out.println(slug);
		try {
			int id = Integer.parseInt(id_raw);
			int is_male = Integer.parseInt(is_male_raw);
			ActorDao cd = new ActorDao();
			Actor c = new Actor();
			c.setId(id);
			c.setName(name);
			c.setSlug(slug);
			c.setIsMale(is_male);
			cd.edit(c);
			response.sendRedirect("actor");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
