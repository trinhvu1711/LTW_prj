package controller.home;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Category;
import model.Movie;
import model.Region;
import model.User;

import java.io.IOException;
import java.util.List;

import dal.CategoryDAO;
import dal.MovieDAO;
import dal.RegionDao;

/**
 * Servlet implementation class HomeServlet
 */
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count = (int) request.getSession().getAttribute("c");
//		HttpSession session = request.getSession();
//		User u = (User) session.getAttribute("account");
//		if (u == null) {
//			response.sendRedirect(request.getContextPath()+"/login");
//			return;	
//		}
//		request.setAttribute("account", u);
		request.getSession().setAttribute("count", count);
		
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
		request.setAttribute("r", r);
		request.setAttribute("c", c);
		
		request.getRequestDispatcher("home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
