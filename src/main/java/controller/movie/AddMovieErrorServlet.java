package controller.movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Episode;
import model.Movie;
import model.MovieError;
import model.User;

import java.io.IOException;

import dal.EpisodeDao;
import dal.MovieDAO;
import dal.MovieErrorDao;

/**
 * Servlet implementation class AddMovieErrorServlet
 */
public class AddMovieErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddMovieErrorServlet() {
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
		String id_movie_raw = request.getParameter("id_movie");
		String id_episode_raw = request.getParameter("id_episode");
		String tap = request.getParameter("tap");
		try {
			int id_movie = Integer.parseInt(id_movie_raw);
			int id_Episode = Integer.parseInt(id_episode_raw);
			EpisodeDao ed = new EpisodeDao();
			Episode e = ed.getById(id_Episode);
			MovieDAO md = new MovieDAO();
			Movie m = md.get(id_movie);
			String name_movie = m.getName();
			String name_episode = e.getName();
			String link = e.getLink();
			MovieError movieError = new MovieError();
			movieError.setId_movie(id_movie);
			movieError.setId_episode(id_Episode);
			movieError.setLink(link);
			movieError.setName_episode(name_episode);
			movieError.setName_movie(name_movie);
			movieError.setTap(tap);
			new MovieErrorDao().add(movieError);
		} catch (Exception e) {
			System.out.println(e);
		}
//		request.setAttribute("id", id_movie_raw);
//		request.setAttribute("tap", tap);
		request.getRequestDispatcher("view?id="+id_movie_raw+"&tap="+tap).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
