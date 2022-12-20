package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Actor;
import model.Movie;
import model.Region;
import model.User;

public class MovieFollowDao extends DBContext {
	public void add(int id, String username) {
		String sql = "insert into movie_follow values(?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.setString(2, username);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void delete(String username, int id) {
		String sql = "delete from movie_follow where username =? and id_movie=?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1,username);
			st.setInt(2,id);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public List<Movie> get(String username) {
		List<Movie> list = new ArrayList<>();
		String sql = "select * from movie t join movie_follow m on t.id = m.id_movie where m.username =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, username);
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

	public boolean checkByUser(String username, int id) {
		String sql = "select * from movie_follow where username =? and id_movie =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, username);
			st.setInt(2, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) return false;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return true;
	}
	
	public static void main(String[] args) {
		
	}
}
