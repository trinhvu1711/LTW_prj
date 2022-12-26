package controller.movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.ImageProfile;
import model.Movie;
import model.Region;
import model.User;

import java.io.IOException;
import java.util.List;

import dal.ImageProfileDao;
import dal.MovieDAO;

/**
 * Servlet implementation class SearchServlet
 */
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
		MovieDAO md = new MovieDAO();	
		String search = request.getParameter("search");
//		System.out.println("asdsa"+search);
		List<Movie> list = md.search(search);
		List<Movie> topphimle = md.getByTopType(21314);
		List<Movie> topphimbo = md.getByTopType(23432);
		Region r = new Region();
		r.setName("Tìm kiếm phim");
//		System.out.println(list.size());
		request.setAttribute("obj", r);
		request.setAttribute("phim", list);
		request.setAttribute("topphimbo", topphimbo);
		request.setAttribute("topphimle", topphimle);
		request.getRequestDispatcher("catalogfilter").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
