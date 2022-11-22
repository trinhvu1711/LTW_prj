package controller.movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Actor;
import model.Category;
import model.Director;
import model.Movie;
import model.Region;
import model.Status;
import model.Studio;
import model.Tag;
import model.Type;

import java.io.IOException;
import java.util.List;

import dal.ActorDao;
import dal.CategoryDAO;
import dal.DirectorDao;
import dal.MovieDAO;
import dal.RegionDao;
import dal.StatusDAO;
import dal.StudioDao;
import dal.TagDao;
import dal.TypeDAO;

/**
 * Servlet implementation class EditMovieServlet
 */
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMovieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CategoryDAO td = new CategoryDAO();
		RegionDao rd = new RegionDao();
		DirectorDao dd = new DirectorDao();
		ActorDao ad = new ActorDao();
		List<Category> c = td.getAll();
		List<Region> r = rd.getAll();
		List<Director> d = dd.getAll();
		List<Actor> a = ad.getAll();

		TagDao tagDao = new TagDao();
		List<Tag> t = tagDao.getAll();

		StudioDao sd = new StudioDao();
		List<Studio> s = sd.getAll();

		StatusDAO cd = new StatusDAO();
		List<Status> status = cd.getall();
		TypeDAO typedao = new TypeDAO();
		List<Type> type = typedao.getAll();

		request.setAttribute("r", r);
		request.setAttribute("c", c);
		request.setAttribute("d", d);
		request.setAttribute("a", a);
		request.setAttribute("t", t);
		request.setAttribute("s", s);
		request.setAttribute("status", status);
		request.setAttribute("type", type);
		
		String id_raw = request.getParameter("id");
		try {
			int id = Integer.parseInt(id_raw);
			MovieDAO md = new MovieDAO();
			Movie m = md.get(id);
			request.setAttribute("m", m);
			request.getRequestDispatcher("editMovie.jsp").forward(request, response);
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
