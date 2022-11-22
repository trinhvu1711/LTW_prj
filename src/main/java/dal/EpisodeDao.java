package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Actor;
import model.Episode;
import model.Movie;

public class EpisodeDao extends DBContext {
	public void addAll(Movie m) {
		String sql = "insert into episode values(?, ?, ?, ?, ?)";
		List<Episode> directors = m.getEpisode();
		for (Episode t : directors) {
			try {
				PreparedStatement st = connection.prepareStatement(sql);
				st.setInt(1, t.getId());
				st.setString(2, t.getName());
				st.setString(3, t.getSlug());
				st.setInt(4, m.getId());
				st.setString(5, t.getLink());
				st.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}
	
	public void deleteById(int id) {
		String sql = "delete from episode where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public List<Episode> get(int id) {
		List<Episode> list = new ArrayList<>();
		String sql ="select * from episode where id_movie=?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Episode c = new Episode();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setSlug(rs.getString("slug"));
				c.setLink(rs.getString("link"));
				list.add(c);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	public static void main(String[] args) {
		List<Episode> list = new EpisodeDao().get(893918);
		for (Episode t : list) {
			System.out.println(t);
		}
	}
}
