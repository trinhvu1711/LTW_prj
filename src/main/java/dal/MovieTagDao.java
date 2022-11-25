package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Movie;
import model.Tag;

public class MovieTagDao extends DBContext {
	public void addAll(Movie m) {
		String sql = "insert into movie_tag values(?, ?)";
		List<Tag> tags = m.getTags();
		for (Tag t : tags) {
			try {
				PreparedStatement st = connection.prepareStatement(sql);
				st.setInt(1, m.getId());
				st.setInt(2, t.getId());
				st.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
	}
	public void deleteById(int id) {
		String sql = "delete from movie_tag where id_movie =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public List<Tag> get(int id) {
		List<Tag> list = new ArrayList<>();
		String sql = "select t.id, t.name, t.slug\r\n"
				+ "from tag t join movie_tag m on t.id = m.id_tag\r\n"
				+ "where m.id_movie =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Tag c = new Tag();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setSlug(rs.getString("slug"));
				list.add(c);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}
	public static void main(String[] args) {
		List<Tag> list = new MovieTagDao().get(893918);
		for (Tag t: list) {
			System.out.println(t);
		}
	}
}
