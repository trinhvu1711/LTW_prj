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
 * Servlet implementation class EditMovieServlet
 */
public class EditMovieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditMovieServlet() {
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

		String id_raw = request.getParameter("id");
		String msg = request.getParameter("msg");
		try {
			int id = Integer.parseInt(id_raw);
			MovieDAO md = new MovieDAO();
			Movie m = md.get(id);
			System.out.println(m.getIs_shown_in_theater());
			request.setAttribute("m", m);
			request.setAttribute("msg", msg);
			request.getRequestDispatcher("editMovie.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean ok = true;
		
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
		try {
			String id_raw = request.getParameter("id");
			String name = request.getParameter("name");
			String origin_name = request.getParameter("origin_name");
			
			int id = 0, type_id = 0, status_id = 0;
			id = Integer.parseInt(id_raw);
			
			if (name == null || name =="" || origin_name == null || origin_name =="") {
				String url = "EditMovieServlet?id=" + id_raw+"&msg=errorValue";
				response.sendRedirect(url);
				return;
			}
			
			try {
				type_id = Integer.parseInt(type_raw);
				status_id = Integer.parseInt(status_raw);
			} catch (Exception e) {
				ok = false;
			}

			Type type = new TypeDAO().getById(type_id);
			Status status = new StatusDAO().getById(status_id);
			if (type == null || status == null)
				ok = false;
			if (ok) {
				Movie m = new Movie(id, name, origin_name, slug, content, thumb, type, status, episode_time,
						episode_current, episode_total, quality, language, publish_year);
				new MovieTagDao().deleteById(id);
				new MovieRegionDao().deleteById(id);
				new MovieActorDao().deleteById(id);
				new MovieDirectorDao().deleteById(id);
				new MovieStudioDao().deleteById(id);
				new MovieCategoryDao().deleteById(id);

				if (category_raw != null) {
					int[] category = toIntArr(category_raw);
					List<Category> categories = new CategoryDAO().getAllById(category);
					m.setCategories(categories);
					new MovieCategoryDao().addAll(m);
				}
				if (region_raw != null) {
					int[] region = toIntArr(region_raw);
					List<Region> regions = new RegionDao().getAllById(region);
					m.setRegions(regions);
					new MovieRegionDao().addAll(m);
				}
				if (director_raw != null) {
					int[] director = toIntArr(director_raw);
					List<Director> directors = new DirectorDao().getAllById(director);
					m.setDirectors(directors);
					new MovieDirectorDao().addAll(m);
				}
				if (tag_raw != null && tag_raw.length > 0) {
					int[] tag = toIntArr(tag_raw);
					List<Tag> tags = new TagDao().getAllById(tag);
					m.setTags(tags);
					new MovieTagDao().addAll(m);
				}
				if (studio_raw != null) {
					int[] studio = toIntArr(studio_raw);
					List<Studio> studios = new StudioDao().getAllById(studio);
					m.setStudios(studios);
					new MovieStudioDao().addAll(m);
				}
				if (actor_raw != null) {
					int[] actor = toIntArr(actor_raw);
					List<Actor> actors = new ActorDao().getAllById(actor);
					m.setActors(actors);
					new MovieActorDao().addAll(m);
				}

				m.setPoster_url(poster);
				m.setNotify(notify);
				m.setShowtimes(showtimes);
				m.setTrailer_url(trailer_url);

				String chieu_rap = request.getParameter("is_shown_in_theater");
				String ban_quyen_phim = request.getParameter("is_copyright");
				String noi_dung_nguoi_lon = request.getParameter("is_sensitive_content");
				String de_cu = request.getParameter("is_recommended");
				
//				System.out.println(chieu_rap);
				
				m.setIs_shown_in_theater(0);
				m.setIs_sensitive_content(0);
				m.setIs_copyright(0);
				m.setIs_recommended(0);
				
				System.out.println(chieu_rap);
				System.out.println(ban_quyen_phim);
				System.out.println(noi_dung_nguoi_lon);
				System.out.println(de_cu);
				
				if (chieu_rap != null) m.setIs_shown_in_theater(1);
				if (ban_quyen_phim!= null) m.setIs_copyright(1);
				if (noi_dung_nguoi_lon!= null) m.setIs_sensitive_content(1);
				if (de_cu!= null) m.setIs_recommended(1);
				
				if (episodeName.length > 0) {
					List<Episode> episodes = new ArrayList<>();
					for (int i = 0; i < episodeName.length; i++) {
						int id_episode = (int) (Math.floor(Math.random() * 89999) + 10000);
						episodes.add(new Episode(id_episode, episodeName[i], episodeSlug[i], link[i], id));
					}
					m.setEpisode(episodes);
				}

				MovieDAO md = new MovieDAO();
				md.edit(m);
				EpisodeDao ed = new EpisodeDao();
				ed.deleteById(id);
				ed.addAll(m);
			}

		} catch (NullPointerException e) {
			System.out.println(e);
			
		}
		response.sendRedirect("movie");
		return;

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
