package controller.movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Category;
import model.ImageProfile;
import model.Movie;
import model.Region;
import model.User;

import java.io.IOException;
import java.util.List;

import dal.CategoryDAO;
import dal.ImageProfileDao;
import dal.MovieFollowDao;
import dal.RegionDao;

/**
 * Servlet implementation class FilmFollowServlet
 */
public class FilmFollowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilmFollowServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		int count = (int) request.getSession().getAttribute("c");
		
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("account");
		if (u == null) {
			response.sendRedirect(request.getContextPath()+"/login");
			return;
		}
		request.setAttribute("account", u);
		ImageProfile imageProfile = new ImageProfileDao().getImage(u.getUsername());;
		request.setAttribute("image", imageProfile);
//		request.getSession().setAttribute("count", count);
		
		CategoryDAO td = new CategoryDAO();
		RegionDao rd = new RegionDao();
		List<Category> c = td.getAll();
		List<Region> r = rd.getAll();
		request.setAttribute("r", r);
		request.setAttribute("c", c);
		List<Movie> list = new MovieFollowDao().get(u.getUsername());
		request.setAttribute("phim", list);
		request.getRequestDispatcher("filmfollow.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
