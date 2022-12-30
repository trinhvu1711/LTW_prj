package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Episode;
import model.MovieError;

public class MovieErrorDao extends DBContext {
	public List<MovieError> getAll() {
		List<MovieError> list = new ArrayList<>();
		String sql = "select * from movie_error";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				MovieError m = new MovieError();
				m.setId_episode(rs.getInt("id_episode"));
				m.setId_movie(rs.getInt("id_movie"));
				m.setLink(rs.getString("link"));
				m.setName_episode(rs.getString("name_episode"));
				m.setName_movie(rs.getString("name_movie"));
				m.setTap(rs.getString("tap"));
				list.add(m);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}
	
	public MovieError get(int id) {
	
		String sql = "select * from movie_error where id_episode=?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				MovieError m = new MovieError();
				m.setId_episode(rs.getInt("id_episode"));
				m.setId_movie(rs.getInt("id_movie"));
				m.setLink(rs.getString("link"));
				m.setName_episode(rs.getString("name_episode"));
				m.setName_movie(rs.getString("name_movie"));
				m.setTap(rs.getString("tap"));
				return m;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}
	
	public void add(MovieError m) {
		String sql = "insert into movie_error values(?, ?, ?, ?,?, ?, ?)";
		Calendar cal = Calendar.getInstance(); 
		java.sql.Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, m.getId_movie());
			st.setInt(2, m.getId_episode());
			st.setString(3, m.getName_movie());
			st.setString(4, m.getName_episode());
			st.setString(5, m.getLink());
			st.setString(7, m.getTap());
			st.setTimestamp(6, timestamp);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void edit(MovieError me) {
		String sql = "update movie_error set link =? where id_episode =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, me.getLink());
			st.setInt(2, me.getId_episode());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void delete(int id_episode) {
		String sql = "delete from movie_error where id_episode =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id_episode);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
