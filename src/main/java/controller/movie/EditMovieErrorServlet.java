package controller.movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Episode;
import model.MovieError;

import java.io.IOException;

import dal.EpisodeDao;
import dal.MovieErrorDao;

/**
 * Servlet implementation class EditMovieErrorServlet
 */
public class EditMovieErrorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditMovieErrorServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id_episode_raw = request.getParameter("id_episode");
		try {
			int id_episode = Integer.parseInt(id_episode_raw);
			MovieErrorDao med = new MovieErrorDao();
			MovieError m = med.get(id_episode);
			request.setAttribute("m", m);
			request.getRequestDispatcher("editmovieerror.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String link = request.getParameter("link");
		String isError = request.getParameter("isError");
		String id_episode_raw = request.getParameter("id_episode");
		try {
			int id_episode = Integer.parseInt(id_episode_raw);
			MovieError me = new MovieError();
			me.setId_episode(id_episode);
			me.setLink(link);
			Episode e = new Episode();
			e.setId(id_episode);
			e.setLink(link);
			new EpisodeDao().edit(e);
			MovieErrorDao med= new MovieErrorDao();
			med.edit(me);
			if (isError == null) {
				med.delete(id_episode);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		
		response.sendRedirect("movieerror");
	}

}
