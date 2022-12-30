package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Movie;

import java.io.IOException;
import java.util.List;

import dal.MovieDAO;

/**
 * Servlet implementation class StatisticalServlet
 */
public class StatisticalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public StatisticalServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MovieDAO md = new MovieDAO();
		List<Movie> listMonth = md.getTopViewMonth();
		List<Movie> listWeek = md.getTopViewWeek();
		List<Movie> listDay = md.getTopViewDay();
		int totalMovie = md.getTotalMovie();
		int totalEpisode = md.getTotalEpisode();
		int totalMovieError = md.getTotalMovieError();
		int totalMember = md.getTotalMember();
		int totalView = md.getTotalView();
		int totalVisit = md.getTotalVisit();
		request.setAttribute("lm", listMonth);
		request.setAttribute("lw", listWeek);
		request.setAttribute("ld", listDay);
		request.setAttribute("totalMovie", totalMovie);
		request.setAttribute("totalEpisode", totalEpisode);
		request.setAttribute("totalMovieError", totalMovieError);
		request.setAttribute("totalMember", totalMember);
		request.setAttribute("totalView", totalView);
		request.setAttribute("totalVisit", totalVisit);
		request.getRequestDispatcher("statistical.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
