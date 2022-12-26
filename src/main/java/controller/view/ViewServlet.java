package controller.view;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Category;
import model.Comment;
import model.Episode;
import model.ImageProfile;
import model.Movie;
import model.Region;
import model.User;

import java.io.IOException;
import java.sql.Date;
import java.util.List;

import dal.CategoryDAO;
import dal.CommentDao;
import dal.ImageProfileDao;
import dal.MovieDAO;
import dal.MovieViewDao;
import dal.RegionDao;

/**
 * Servlet implementation class ViewServlet
 */
public class ViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewServlet() {
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
		
		List<Movie> phimle = new MovieDAO().getByType(21314);
		List<Movie> phimbo = new MovieDAO().getByType(23432);
		List<Movie> recommend = new MovieDAO().getRecommend();
		
		List<Movie> topphimle = new MovieDAO().getByTopType(21314);
		List<Movie> topphimbo = new MovieDAO().getByTopType(23432);

		CategoryDAO td = new CategoryDAO();
		RegionDao rd = new RegionDao();
		List<Category> c = td.getAll();
		List<Region> r = rd.getAll();
		
		request.setAttribute("r", r);
		request.setAttribute("c", c);
		
		request.setAttribute("recommend", recommend);
		request.setAttribute("phimbo", phimbo);
		request.setAttribute("phimle", phimle);
		request.setAttribute("topphimbo", topphimbo);
		request.setAttribute("topphimle", topphimle);
		
		System.out.println("run");
		String id_raw = request.getParameter("id");
		String xtap = request.getParameter("tap");
		int tap, num;
		try {
			if (xtap == null ) tap = 0;
			else {
				tap = Integer.parseInt(xtap);
			}
			int id = Integer.parseInt(id_raw);
			new MovieViewDao().addView(id);
			Movie movie = new MovieDAO().get(id);
			List<Episode> episode = movie.getEpisode();
			request.setAttribute("movie", movie);
			request.setAttribute("episode", episode.get(tap));
			request.setAttribute("ep", episode);
			System.out.println(episode.get(tap).getLink());
			num = episode.size();
			request.setAttribute("tap", tap);
			request.setAttribute("num", num);
			List<Comment> comments = new CommentDao().getComments(id);
			request.setAttribute("comments", comments);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	
		request.getRequestDispatcher("view.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
