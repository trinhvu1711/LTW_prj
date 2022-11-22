package controller.movie;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Actor;
import model.Category;
import model.Director;
import model.Episode;
import model.Movie;
import model.Region;
import model.Status;
import model.Studio;
import model.Tag;
import model.Type;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import dal.ActorDao;
import dal.CategoryDAO;
import dal.DirectorDao;
import dal.EpisodeDao;
import dal.MovieActorDao;
import dal.MovieCategoryDao;
import dal.MovieDAO;
import dal.MovieDirectorDao;
import dal.MovieRegionDao;
import dal.MovieStudioDao;
import dal.MovieTagDao;
import dal.RegionDao;
import dal.StatusDAO;
import dal.StudioDao;
import dal.TagDao;
import dal.TypeDAO;

/**
 * Servlet implementation class AddMovieServlet
 */
public class AddMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddMovieServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
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
		request.getRequestDispatcher("addMovie.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id = (int) (Math.floor(Math.random() * 899999) + 100000);
		String name = request.getParameter("name");
		String origin_name = request.getParameter("origin_name");
		String slug = request.getParameter("slug");
		String poster = request.getParameter("poster");
		String thumb = request.getParameter("thumb");
		String content = request.getParameter("content");
		String notify = request.getParameter("notify");
		String showtimes = request.getParameter("showtimes");
		String trailer_url = request.getParameter("trailer_url");
		String episode_time = request.getParameter("episode_time");
		String episode_current = request.getParameter("episode_current");
		String episode_total = request.getParameter("episode_total");
		String language = request.getParameter("language");
		String quality = request.getParameter("quality");
		String publish_year = request.getParameter("publish_year");

		String type_raw = request.getParameter("type");
		String status_raw = request.getParameter("status");
		String[] category_raw = request.getParameterValues("category");
		String[] region_raw = request.getParameterValues("region");
		String[] actor_raw = request.getParameterValues("actor");
		String[] director_raw = request.getParameterValues("director");
		String[] tag_raw = request.getParameterValues("tag");
		String[] studio_raw = request.getParameterValues("studio");

		String[] episodeName = request.getParameterValues("episode_name");
		String[] episodeSlug = request.getParameterValues("episode_slug");
		String[] link = request.getParameterValues("link");
		if (type_raw == null || status_raw == null || category_raw.length == 0 || region_raw.length == 0
				|| actor_raw.length == 0 || director_raw.length == 0 || tag_raw.length == 0 || studio_raw.length == 0)
			try {
				int type_id = Integer.parseInt(type_raw);
				int status_id = Integer.parseInt(status_raw);
				int[] category = toIntArr(category_raw);
				int[] region = toIntArr(region_raw);
				int[] director = toIntArr(director_raw);
				int[] tag = toIntArr(tag_raw);
				int[] studio = toIntArr(studio_raw);
				int[] actor = toIntArr(actor_raw);
				List<Category> categories = new CategoryDAO().getAllById(category);
				List<Region> regions = new RegionDao().getAllById(region);
				List<Director> directors = new DirectorDao().getAllById(director);
				List<Tag> tags = new TagDao().getAllById(tag);
				List<Studio> studios = new StudioDao().getAllById(studio);
				List<Actor> actors = new ActorDao().getAllById(actor);

				Type type = new TypeDAO().getById(type_id);
				Status status = new StatusDAO().getById(status_id);

				Movie m = new Movie(id, name, origin_name, slug, content, thumb, type, status, episode_time,
						episode_current, episode_total, quality, language, publish_year);
				m.setPoster_url(poster);
				m.setNotify(notify);
				m.setShowtimes(showtimes);
				m.setTrailer_url(trailer_url);
				m.setCategories(categories);
				m.setRegions(regions);
				m.setDirectors(directors);
				m.setTags(tags);
				m.setStudios(studios);
				m.setActors(actors);

				if (episodeName.length > 0) {
					List<Episode> episodes = new ArrayList<>();
					for (int i = 0; i < episodeName.length; i++) {
						int id_episode = (int) (Math.floor(Math.random() * 89999) + 10000);
						episodes.add(new Episode(id_episode, episodeName[i], episodeSlug[i], link[i], id));
					}
					m.setEpisode(episodes);
				}

				MovieDAO md = new MovieDAO();
				md.addAll(m);
				EpisodeDao ed = new EpisodeDao();
				ed.addAll(m);
				new MovieTagDao().addAll(m);
				new MovieRegionDao().addAll(m);
				new MovieActorDao().addAll(m);
				new MovieDirectorDao().addAll(m);
				new MovieStudioDao().addAll(m);
				new MovieCategoryDao().addAll(m);
			} catch (Exception e) {
				System.out.println(e);
			}
		response.sendRedirect("movie");
	}

	public int[] toIntArr(String[] arr) {
		int[] result = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			try {
				result[i] = Integer.parseInt(arr[i]);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		return result;
	}
}
