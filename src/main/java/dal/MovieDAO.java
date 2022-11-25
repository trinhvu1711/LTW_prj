package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
				+ "episode_time, episode_current, episode_total, quality, language, publish_year) values(?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?,?,?)";
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
				return m;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void edit(Movie m) {
		String sql = "update movie set name=?, origin_name=?, slug= ?, content=?, thumb_url=?, poster_url=?, type_id=?, status_id=?, "
				+ "episode_time=?, episode_current=?, episode_total=?, quality=?, language=?, publish_year=? where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(15, m.getId());
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
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
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
//		List<Movie> list = new MovieDAO().getAll();
//		for (Movie m : list) {
//			System.out.println(m.toString());
//		}
//		System.out.println(new MovieDAO().get(893918));
		new MovieDAO().delete(456115);
	}
}
