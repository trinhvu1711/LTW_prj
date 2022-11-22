package controller.actor;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Actor;
import model.Region;

import java.io.IOException;

import dal.ActorDao;
import dal.RegionDao;

/**
 * Servlet implementation class AddActorServlet
 */
public class AddActorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddActorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("addActor.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = (int) (Math.floor(Math.random()*89999)+10000);
		String name =request.getParameter("name");
		String slug =request.getParameter("slug");
		String thumb_url =request.getParameter("thumb_url");
		String is_male_raw =request.getParameter("is_male");
		System.out.println(name);
		System.out.println(slug);
		try {
			int is_male =0;
			is_male = Integer.parseInt(is_male_raw);
			ActorDao cd = new ActorDao();
			Actor c = cd.getById(id);
			if (c == null) {
				cd.add(new Actor(id, name, slug, thumb_url, is_male));
				response.sendRedirect("actor");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
