package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import model.Movie;
import model.Tag;
import model.Type;

public class MovieDAO extends DBContext {
	public List<Movie> getAll() {
		List<Movie> list = new ArrayList<>();
		String sql = "select * from movie";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Movie m = new Movie();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setOrigin_name(rs.getString("origin_name"));
				m.setSlug(rs.getString("slug"));
				m.setContent(rs.getString("content"));
				m.setThumb_url(rs.getString("thumb_url"));
				m.setPoster_url(rs.getString("poster_url"));
				int id_type = rs.getInt("type_id");
				m.setType(new TypeDAO().getById(id_type));
				int id_status = rs.getInt("status_id");
				m.setStatus(new StatusDAO().getById(id_status));
				m.setEpisode_time(rs.getString("episode_time"));
				m.setEpisode_current(rs.getString("episode_current"));
				m.setEpisode_total(rs.getString("episode_total"));
				m.setQuality(rs.getString("quality"));
				m.setLanguage(rs.getString("language"));
				m.setPublish_year(rs.getString("publish_year"));
				list.add(m);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	public void addAll(Movie m) {
		String sql = "insert into movie(id, name, origin_name, slug, content, thumb_url, poster_url, type_id, status_id, "
				+ "episode_time, episode_current, episode_total, quality, language, publish_year, is_shown_in_theater, is_recommended, is_copyright, is_sensitive_content) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, m.getId());
			st.setString(2, m.getName());
			st.setString(3, m.getOrigin_name());
			st.setString(4, m.getSlug());
			st.setString(5, m.getContent());
			st.setString(6, m.getThumb_url());
			st.setString(7, m.getPoster_url());
			st.setInt(8, m.getType().getId());
			st.setInt(9, m.getStatus().getId());

			st.setString(10, m.getEpisode_time());
			st.setString(11, m.getEpisode_current());
			st.setString(12, m.getEpisode_total());
			st.setString(13, m.getQuality());
			st.setString(14, m.getLanguage());
			st.setString(15, m.getPublish_year());
			st.setInt(16, m.getIs_shown_in_theater());
			st.setInt(17, m.getIs_recommended());
			st.setInt(18, m.getIs_recommended());
			st.setInt(19, m.getIs_sensitive_content());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}

	}

	public Movie get(int id) {
		String sql = "select * from movie where id=?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Movie m = new Movie();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setOrigin_name(rs.getString("origin_name"));
				m.setSlug(rs.getString("slug"));
				m.setContent(rs.getString("content"));
				m.setThumb_url(rs.getString("thumb_url"));
				m.setPoster_url(rs.getString("poster_url"));
				int id_type = rs.getInt("type_id");
				m.setType(new TypeDAO().getById(id_type));
				int id_status = rs.getInt("status_id");
				m.setStatus(new StatusDAO().getById(id_status));
				m.setEpisode_time(rs.getString("episode_time"));
				m.setEpisode_current(rs.getString("episode_current"));
				m.setEpisode_total(rs.getString("episode_total"));
				m.setQuality(rs.getString("quality"));
				m.setLanguage(rs.getString("language"));
				m.setPublish_year(rs.getString("publish_year"));
				m.setIs_shown_in_theater(rs.getInt("is_shown_in_theater"));
				m.setIs_copyright(rs.getInt("is_copyright"));
				m.setIs_sensitive_content(rs.getInt("is_sensitive_content"));
				m.setIs_recommended(rs.getInt("is_recommended"));
				m.setTrailer_url(rs.getString("trailer_url"));
				m.setActors(new MovieActorDao().get(m.getId()));
				m.setCategories(new MovieCategoryDao().get(m.getId()));
				m.setDirectors(new MovieDirectorDao().get(m.getId()));
				m.setRegions(new MovieRegionDao().get(m.getId()));
				m.setStudios(new MovieStudioDao().get(m.getId()));
				m.setEpisode(new EpisodeDao().get(m.getId()));
				m.setTags(new MovieTagDao().get(m.getId()));
//				m.setView_day(new MovieViewDao().getViewByDay(id, new Date(System.currentTimeMillis())));
//				m.setView_month(new MovieViewDao().getViewByYear(id, new Date(System.currentTimeMillis())));
//				m.setView_total(new MovieViewDao().getView(id));
//				m.setView_week(new MovieViewDao().getViewByWeek(id, new Date(System.currentTimeMillis())));
				return m;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	
	public void edit(Movie m) {
		String sql = "update movie set name=?, origin_name=?, slug= ?, content=?, thumb_url=?, poster_url=?, type_id=?, status_id=?, "
				+ "episode_time=?, episode_current=?, episode_total=?, quality=?, language=?, publish_year=?,  is_shown_in_theater=?, is_recommended =?, is_copyright=?, is_sensitive_content=?, trailer_url=? where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(20, m.getId());
			st.setString(1, m.getName());
			st.setString(2, m.getOrigin_name());
			st.setString(3, m.getSlug());
			st.setString(4, m.getContent());
			st.setString(5, m.getThumb_url());
			st.setString(6, m.getPoster_url());
			st.setInt(7, m.getType().getId());
			st.setInt(8, m.getStatus().getId());

			st.setString(9, m.getEpisode_time());
			st.setString(10, m.getEpisode_current());
			st.setString(11, m.getEpisode_total());
			st.setString(12, m.getQuality());
			st.setString(13, m.getLanguage());
			st.setString(14, m.getPublish_year());
			st.setInt(15, m.getIs_shown_in_theater());
			st.setInt(16, m.getIs_recommended());
			st.setInt(17, m.getIs_recommended());
			st.setInt(18, m.getIs_sensitive_content());
			st.setString(19, m.getTrailer_url());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public List<Movie> getByType(int id) {
		List<Movie> list = new ArrayList<>();
		String sql = "select top 24 * from movie m join type t on m.type_id = t.id where t.id = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Movie m = new Movie();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setOrigin_name(rs.getString("origin_name"));
				m.setSlug(rs.getString("slug"));
				m.setContent(rs.getString("content"));
				m.setThumb_url(rs.getString("thumb_url"));
				m.setPoster_url(rs.getString("poster_url"));
				int id_type = rs.getInt("type_id");
				m.setType(new TypeDAO().getById(id_type));
				int id_status = rs.getInt("status_id");
				m.setStatus(new StatusDAO().getById(id_status));
				m.setEpisode_time(rs.getString("episode_time"));
				m.setEpisode_current(rs.getString("episode_current"));
				m.setEpisode_total(rs.getString("episode_total"));
				m.setQuality(rs.getString("quality"));
				m.setLanguage(rs.getString("language"));
				m.setPublish_year(rs.getString("publish_year"));
				m.setIs_shown_in_theater(rs.getInt("is_shown_in_theater"));
				m.setIs_copyright(rs.getInt("is_copyright"));
				m.setIs_sensitive_content(rs.getInt("is_sensitive_content"));
				m.setIs_recommended(rs.getInt("is_recommended"));
				m.setTrailer_url(rs.getString("trailer_url"));
				m.setActors(new MovieActorDao().get(m.getId()));
				m.setCategories(new MovieCategoryDao().get(m.getId()));
				m.setDirectors(new MovieDirectorDao().get(m.getId()));
				m.setRegions(new MovieRegionDao().get(m.getId()));
				m.setStudios(new MovieStudioDao().get(m.getId()));
				m.setEpisode(new EpisodeDao().get(m.getId()));
				m.setTags(new MovieTagDao().get(m.getId()));
//				m.setView_day(new MovieViewDao().getViewByDay(id, new Date(System.currentTimeMillis())));
//				m.setView_month(new MovieViewDao().getViewByYear(id, new Date(System.currentTimeMillis())));
//				m.setView_total(new MovieViewDao().getView(id));
//				m.setView_week(new MovieViewDao().getViewByWeek(id, new Date(System.currentTimeMillis())));
				

				list.add(m);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}
	public List<Movie> search(String search) {
		String sql = "select * from movie where name like ? or origin_name like ?";
		List<Movie> list = new ArrayList<>();
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, "%"+search+"%");
			st.setString(2, "%"+search+"%");
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Movie m = new Movie();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setOrigin_name(rs.getString("origin_name"));
				m.setSlug(rs.getString("slug"));
				m.setContent(rs.getString("content"));
				m.setThumb_url(rs.getString("thumb_url"));
				m.setPoster_url(rs.getString("poster_url"));
				int id_type = rs.getInt("type_id");
				m.setType(new TypeDAO().getById(id_type));
				int id_status = rs.getInt("status_id");
				m.setStatus(new StatusDAO().getById(id_status));
				m.setEpisode_time(rs.getString("episode_time"));
				m.setEpisode_current(rs.getString("episode_current"));
				m.setEpisode_total(rs.getString("episode_total"));
				m.setQuality(rs.getString("quality"));
				m.setLanguage(rs.getString("language"));
				m.setPublish_year(rs.getString("publish_year"));

				list.add(m);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}
	
	public List<Movie> getByAllType(int id) {
		List<Movie> list = new ArrayList<>();
		String sql = "select * from movie m join type t on m.type_id = t.id where t.id = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Movie m = new Movie();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setOrigin_name(rs.getString("origin_name"));
				m.setSlug(rs.getString("slug"));
				m.setContent(rs.getString("content"));
				m.setThumb_url(rs.getString("thumb_url"));
				m.setPoster_url(rs.getString("poster_url"));
				int id_type = rs.getInt("type_id");
				m.setType(new TypeDAO().getById(id_type));
				int id_status = rs.getInt("status_id");
				m.setStatus(new StatusDAO().getById(id_status));
				m.setEpisode_time(rs.getString("episode_time"));
				m.setEpisode_current(rs.getString("episode_current"));
				m.setEpisode_total(rs.getString("episode_total"));
				m.setQuality(rs.getString("quality"));
				m.setLanguage(rs.getString("language"));
				m.setPublish_year(rs.getString("publish_year"));
				m.setIs_shown_in_theater(rs.getInt("is_shown_in_theater"));
				m.setIs_copyright(rs.getInt("is_copyright"));
				m.setIs_sensitive_content(rs.getInt("is_sensitive_content"));
				m.setIs_recommended(rs.getInt("is_recommended"));
				m.setTrailer_url(rs.getString("trailer_url"));
				m.setActors(new MovieActorDao().get(m.getId()));
				m.setCategories(new MovieCategoryDao().get(m.getId()));
				m.setDirectors(new MovieDirectorDao().get(m.getId()));
				m.setRegions(new MovieRegionDao().get(m.getId()));
				m.setStudios(new MovieStudioDao().get(m.getId()));
				m.setEpisode(new EpisodeDao().get(m.getId()));
				m.setTags(new MovieTagDao().get(m.getId()));
//				m.setView_day(new MovieViewDao().getViewByDay(id, new Date(System.currentTimeMillis())));
//				m.setView_month(new MovieViewDao().getViewByYear(id, new Date(System.currentTimeMillis())));
//				m.setView_total(new MovieViewDao().getView(id));
//				m.setView_week(new MovieViewDao().getViewByWeek(id, new Date(System.currentTimeMillis())));
			

				list.add(m);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	public List<Movie> getByAllCategory(int id) {
		List<Movie> list = new ArrayList<>();
		String sql = "select * from movie m join movie_category t on m.id = t.id_movie where t.id_category = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Movie m = new Movie();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setOrigin_name(rs.getString("origin_name"));
				m.setSlug(rs.getString("slug"));
				m.setContent(rs.getString("content"));
				m.setThumb_url(rs.getString("thumb_url"));
				m.setPoster_url(rs.getString("poster_url"));
				int id_type = rs.getInt("type_id");
				m.setType(new TypeDAO().getById(id_type));
				int id_status = rs.getInt("status_id");
				m.setStatus(new StatusDAO().getById(id_status));
				m.setEpisode_time(rs.getString("episode_time"));
				m.setEpisode_current(rs.getString("episode_current"));
				m.setEpisode_total(rs.getString("episode_total"));
				m.setQuality(rs.getString("quality"));
				m.setLanguage(rs.getString("language"));
				m.setPublish_year(rs.getString("publish_year"));
				m.setIs_shown_in_theater(rs.getInt("is_shown_in_theater"));
				m.setIs_copyright(rs.getInt("is_copyright"));
				m.setIs_sensitive_content(rs.getInt("is_sensitive_content"));
				m.setIs_recommended(rs.getInt("is_recommended"));
				m.setTrailer_url(rs.getString("trailer_url"));
				m.setActors(new MovieActorDao().get(m.getId()));
				m.setCategories(new MovieCategoryDao().get(m.getId()));
				m.setDirectors(new MovieDirectorDao().get(m.getId()));
				m.setRegions(new MovieRegionDao().get(m.getId()));
				m.setStudios(new MovieStudioDao().get(m.getId()));
				m.setEpisode(new EpisodeDao().get(m.getId()));
				m.setTags(new MovieTagDao().get(m.getId()));
//				m.setView_day(new MovieViewDao().getViewByDay(id, new Date(System.currentTimeMillis())));
//				m.setView_month(new MovieViewDao().getViewByYear(id, new Date(System.currentTimeMillis())));
//				m.setView_total(new MovieViewDao().getView(id));
//				m.setView_week(new MovieViewDao().getViewByWeek(id, new Date(System.currentTimeMillis())));
			

				list.add(m);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	public List<Movie> getByAllRegion(int id) {
		List<Movie> list = new ArrayList<>();
		String sql = "select * from movie m join movie_region t on m.id = t.id_movie where t.id_region = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Movie m = new Movie();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setOrigin_name(rs.getString("origin_name"));
				m.setSlug(rs.getString("slug"));
				m.setContent(rs.getString("content"));
				m.setThumb_url(rs.getString("thumb_url"));
				m.setPoster_url(rs.getString("poster_url"));
				int id_type = rs.getInt("type_id");
				m.setType(new TypeDAO().getById(id_type));
				int id_status = rs.getInt("status_id");
				m.setStatus(new StatusDAO().getById(id_status));
				m.setEpisode_time(rs.getString("episode_time"));
				m.setEpisode_current(rs.getString("episode_current"));
				m.setEpisode_total(rs.getString("episode_total"));
				m.setQuality(rs.getString("quality"));
				m.setLanguage(rs.getString("language"));
				m.setPublish_year(rs.getString("publish_year"));
				m.setIs_shown_in_theater(rs.getInt("is_shown_in_theater"));
				m.setIs_copyright(rs.getInt("is_copyright"));
				m.setIs_sensitive_content(rs.getInt("is_sensitive_content"));
				m.setIs_recommended(rs.getInt("is_recommended"));
				m.setTrailer_url(rs.getString("trailer_url"));
				m.setActors(new MovieActorDao().get(m.getId()));
				m.setCategories(new MovieCategoryDao().get(m.getId()));
				m.setDirectors(new MovieDirectorDao().get(m.getId()));
				m.setRegions(new MovieRegionDao().get(m.getId()));
				m.setStudios(new MovieStudioDao().get(m.getId()));
				m.setEpisode(new EpisodeDao().get(m.getId()));
				m.setTags(new MovieTagDao().get(m.getId()));
//				m.setView_day(new MovieViewDao().getViewByDay(id, new Date(System.currentTimeMillis())));
//				m.setView_month(new MovieViewDao().getViewByYear(id, new Date(System.currentTimeMillis())));
//				m.setView_total(new MovieViewDao().getView(id));
//				m.setView_week(new MovieViewDao().getViewByWeek(id, new Date(System.currentTimeMillis())));
			

				list.add(m);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	public List<Movie> getByAllTheater() {
		List<Movie> list = new ArrayList<>();
		String sql = "select * from movie where is_shown_in_theater =1";
		try {
			PreparedStatement st = connection.prepareStatement(sql);

			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Movie m = new Movie();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setOrigin_name(rs.getString("origin_name"));
				m.setSlug(rs.getString("slug"));
				m.setContent(rs.getString("content"));
				m.setThumb_url(rs.getString("thumb_url"));
				m.setPoster_url(rs.getString("poster_url"));
				int id_type = rs.getInt("type_id");
				m.setType(new TypeDAO().getById(id_type));
				int id_status = rs.getInt("status_id");
				m.setStatus(new StatusDAO().getById(id_status));
				m.setEpisode_time(rs.getString("episode_time"));
				m.setEpisode_current(rs.getString("episode_current"));
				m.setEpisode_total(rs.getString("episode_total"));
				m.setQuality(rs.getString("quality"));
				m.setLanguage(rs.getString("language"));
				m.setPublish_year(rs.getString("publish_year"));

				list.add(m);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	public List<Movie> getByAllFilmFilter(Integer type, Integer region, Integer year, Integer category, String sort) {
		List<Movie> list = new ArrayList<>();
		String sql = "select DISTINCT m.[id]\r\n" + "      ,m.[name]\r\n" + "      ,[origin_name]\r\n"
				+ "      ,m.[slug]\r\n" + "      ,[content]\r\n" + "      ,[notify]\r\n" + "      ,[showtimes]\r\n"
				+ "      ,[thumb_url]\r\n" + "      ,[poster_url]\r\n" + "      ,[is_shown_in_theater]\r\n"
				+ "      ,[is_recommended]\r\n" + "      ,[is_copyright]\r\n" + "      ,[is_sensitive_content]\r\n"
				+ "      ,[type_id]\r\n" + "      ,[status_id]\r\n" + "      ,[trailer_url]\r\n"
				+ "      ,[episode_time]\r\n" + "      ,[episode_current]\r\n" + "      ,[episode_total]\r\n"
				+ "      ,[quality]\r\n" + "      ,[language]\r\n" + "      ,[publish_year]\r\n"
				+ "      ,[view_total]\r\n" + "      ,[view_day]\r\n" + "      ,[view_week]\r\n"
				+ "      ,[view_month]\r\n" + "      ,[rating_count]\r\n" + "      ,[rating_start]\r\n"
				+ "      ,[created]\r\n"
				+ "      ,[updated] from movie m inner join movie_region r on m.id = r.id_movie inner join movie_category c on m.id = c.id_movie inner join type t on m.type_id = t.id where 1=1";
		try {
			if (type > 0)
				sql += "and m.type_id = " + type;
			if (region > 0)
				sql += "and r.id_region = " + region;
			if (category > 0)
				sql += "and c.id_category = " + category;
			if (year > 0)
				sql += "and publish_year = " + year;
			if (!sort.equals("") && sort != null)
				sql += "order by " + sort;
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Movie m = new Movie();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setOrigin_name(rs.getString("origin_name"));
				m.setSlug(rs.getString("slug"));
				m.setContent(rs.getString("content"));
				m.setThumb_url(rs.getString("thumb_url"));
				m.setPoster_url(rs.getString("poster_url"));
				int id_type = rs.getInt("type_id");
				m.setType(new TypeDAO().getById(id_type));
				int id_status = rs.getInt("status_id");
				m.setStatus(new StatusDAO().getById(id_status));
				m.setEpisode_time(rs.getString("episode_time"));
				m.setEpisode_current(rs.getString("episode_current"));
				m.setEpisode_total(rs.getString("episode_total"));
				m.setQuality(rs.getString("quality"));
				m.setLanguage(rs.getString("language"));
				m.setPublish_year(rs.getString("publish_year"));

				list.add(m);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	public List<Movie> getRecommend() {
		List<Movie> list = new ArrayList<>();
		String sql = "select top 10 * from movie order by view_total";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Movie m = new Movie();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setOrigin_name(rs.getString("origin_name"));
				m.setSlug(rs.getString("slug"));
				m.setContent(rs.getString("content"));
				m.setThumb_url(rs.getString("thumb_url"));
				m.setPoster_url(rs.getString("poster_url"));
				int id_type = rs.getInt("type_id");
				m.setType(new TypeDAO().getById(id_type));
				int id_status = rs.getInt("status_id");
				m.setStatus(new StatusDAO().getById(id_status));
				m.setEpisode_time(rs.getString("episode_time"));
				m.setEpisode_current(rs.getString("episode_current"));
				m.setEpisode_total(rs.getString("episode_total"));
				m.setQuality(rs.getString("quality"));
				m.setLanguage(rs.getString("language"));
				m.setPublish_year(rs.getString("publish_year"));

				list.add(m);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	
	
	public List<Movie> getByTopType(int id) {
		List<Movie> list = new ArrayList<>();
		String sql = "select Top 5 * from movie m join type t on m.type_id = t.id  where t.id = ? order by view_total";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Movie m = new Movie();
				m.setId(rs.getInt("id"));
				m.setName(rs.getString("name"));
				m.setOrigin_name(rs.getString("origin_name"));
				m.setSlug(rs.getString("slug"));
				m.setContent(rs.getString("content"));
				m.setThumb_url(rs.getString("thumb_url"));
				m.setPoster_url(rs.getString("poster_url"));
				int id_type = rs.getInt("type_id");
				m.setType(new TypeDAO().getById(id_type));
				int id_status = rs.getInt("status_id");
				m.setStatus(new StatusDAO().getById(id_status));
				m.setEpisode_time(rs.getString("episode_time"));
				m.setEpisode_current(rs.getString("episode_current"));
				m.setEpisode_total(rs.getString("episode_total"));
				m.setQuality(rs.getString("quality"));
				m.setLanguage(rs.getString("language"));
				m.setPublish_year(rs.getString("publish_year"));
//				m.setView_day(new MovieViewDao().getViewByDay(id, new Date(System.currentTimeMillis())));
//				m.setView_month(new MovieViewDao().getViewByYear(id, new Date(System.currentTimeMillis())));
//				m.setView_total(new MovieViewDao().getView(id));
//				m.setView_week(new MovieViewDao().getViewByWeek(id, new Date(System.currentTimeMillis())));
				list.add(m);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	public List<Movie> getListByPage(List<Movie> list, int start, int end) {
		ArrayList<Movie> arr = new ArrayList<>();
		for (int i = start; i < end; i++) {
			arr.add(list.get(i));
		}
		return arr;
	}

	public void delete(int id) {
		String sql = "delete from movie where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		System.out.println("run");

		List<Movie> list = new MovieDAO().getByAllType(21314);
		List<Movie> movie = new MovieDAO().getListByPage(list, 24, 27);
//		System.out.println(list.size());
//		for (Movie m : movie) {
//			System.out.println(m.toString());
//		}
//		System.out.println(new MovieDAO().get(893918).getEpisode().size());
//		System.out.println(new MovieDAO().get(893918));
		System.out.println(new MovieDAO().search("th").size());
	}
}
