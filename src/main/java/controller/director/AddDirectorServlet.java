package controller.director;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Actor;
import model.Director;
import model.User;

import java.io.IOException;

import dal.ActorDao;
import dal.DirectorDao;

/**
 * Servlet implementation class AddDirectorServlet
 */
public class AddDirectorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddDirectorServlet() {
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
		request.getRequestDispatcher("addDirector.jsp").forward(request, response);
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
			DirectorDao cd = new DirectorDao();
			Director c = cd.getById(id);
			if (c == null) {
				cd.add(new Director(id, name, slug, thumb_url, is_male));
				response.sendRedirect("director");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
