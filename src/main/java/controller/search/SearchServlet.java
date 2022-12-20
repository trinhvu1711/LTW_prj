package controller.search;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Movie;
import model.Region;

import java.io.IOException;
import java.util.List;

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
