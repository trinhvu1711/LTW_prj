package controller.director;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Actor;
import model.Director;

import java.io.IOException;

import dal.ActorDao;
import dal.DirectorDao;

/**
 * Servlet implementation class EditDirectorServlet
 */
public class EditDirectorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditDirectorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_raw = request.getParameter("id");
		try {
			int id = Integer.parseInt(id_raw);
			DirectorDao cd = new DirectorDao();
			Director c = cd.getById(id);
//			System.out.println(id);
			request.setAttribute("c", c);
			request.getRequestDispatcher("editDirector.jsp").forward(request, response);
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
		String is_male_raw =request.getParameter("is_male");
		System.out.println(id_raw);
//		System.out.println(name);
//		System.out.println(slug);
		try {
			int id = Integer.parseInt(id_raw);
			int is_male = Integer.parseInt(is_male_raw);
			DirectorDao cd = new DirectorDao();
			Director c = new Director();
			c.setId(id);
			c.setName(name);
			c.setSlug(slug);
			c.setMale(is_male);
			cd.edit(c);
			response.sendRedirect("director");

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
