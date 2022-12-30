package controller.movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.User;

import java.io.IOException;

import dal.CategoryDAO;
import dal.EpisodeDao;
import dal.MovieActorDao;
import dal.MovieCategoryDao;
import dal.MovieDAO;
import dal.MovieDirectorDao;
import dal.MovieRegionDao;
import dal.MovieStudioDao;
import dal.MovieTagDao;

/**
 * Servlet implementation class DeleteMovieServlet
 */
public class DeleteMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteMovieServlet() {
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
//			System.out.println(id);
			MovieDAO md = new MovieDAO();
			md.delete(id);
			new MovieTagDao().deleteById(id);
			new MovieRegionDao().deleteById(id);
			new MovieActorDao().deleteById(id);
			new MovieDirectorDao().deleteById(id);
			new MovieStudioDao().deleteById(id);
			new MovieCategoryDao().deleteById(id);
			EpisodeDao ed = new EpisodeDao();
			ed.deleteById(id);
			response.sendRedirect("movie");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
