package controller.detail;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Actor;
import model.Category;
import model.Comment;
import model.Director;
import model.ImageProfile;
import model.Movie;
import model.MovieRegion;
import model.Region;
import model.User;

import java.io.IOException;
import java.util.List;

import dal.ActorDao;
import dal.CategoryDAO;
import dal.CommentDao;
import dal.ImageProfileDao;
import dal.MovieActorDao;
import dal.MovieCategoryDao;
import dal.MovieDAO;
import dal.MovieDirectorDao;
import dal.MovieFollowDao;
import dal.MovieHistoryDao;
import dal.MovieRegionDao;
import dal.RegionDao;

/**
 * Servlet implementation class DetailServlet
 */
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("account");
		if (u != null) {
			request.setAttribute("account", u);
			ImageProfile imageProfile = new ImageProfileDao().getImage(u.getUsername());;
			request.setAttribute("image", imageProfile);
		}
		String id_raw = request.getParameter("id");
		try {
			int id = Integer.parseInt(id_raw);
			Movie movie = new MovieDAO().get(id);
			request.setAttribute("movie", movie);
			
			List<Movie> phimle = new MovieDAO().getByType(21314);
			List<Movie> phimbo = new MovieDAO().getByType(23432);
			List<Movie> recommend = new MovieDAO().getRecommend();
			
			List<Movie> topphimle = new MovieDAO().getByTopType(21314);
			List<Movie> topphimbo = new MovieDAO().getByTopType(23432);
			
			request.setAttribute("recommend", recommend);
			request.setAttribute("phimbo", phimbo);
			request.setAttribute("phimle", phimle);
			request.setAttribute("topphimbo", topphimbo);
			request.setAttribute("topphimle", topphimle);
			
			CategoryDAO td = new CategoryDAO();
			RegionDao rd = new RegionDao();
			List<Category> c = td.getAll();
			List<Region> r = rd.getAll();
			List<Category> category = new MovieCategoryDao().get(id);
			List<Region> region = new MovieRegionDao().get(id);
			List<Director> directors = new MovieDirectorDao().get(id);
			List<Actor> actors = new MovieActorDao().get(id);
			request.setAttribute("r", r);
			request.setAttribute("c", c);
			request.setAttribute("region", region);
			request.setAttribute("category", category);
			request.setAttribute("directors", directors);
			request.setAttribute("actors", actors);
			List<Comment> comments = new CommentDao().getComments(id);
			request.setAttribute("comments", comments);
			System.out.println(actors.size());
			boolean check;
			if (u != null) {
				new MovieHistoryDao().add(id, u.getUsername());
				check =new MovieFollowDao().checkByUser(u.getUsername(), id);
			}
			else check = true;
			request.setAttribute("check", check);
			request.getRequestDispatcher("detail.jsp").forward(request, response);
		} catch (Exception e) {
			// TODO: handle exception
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
