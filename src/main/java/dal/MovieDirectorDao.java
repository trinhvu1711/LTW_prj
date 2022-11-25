package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Director;
import model.Movie;

public class MovieDirectorDao extends DBContext {
	public void addAll(Movie m) {
		String sql = "insert into movie_director values(?, ?)";
		List<Director> directors = m.getDirectors();
		for (Director t : directors) {
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
		String sql = "delete from movie_director where id_movie =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public List<Director> get(int id) {
		List<Director> list = new ArrayList<>();
		String sql = "select t.id, t.name, t.slug\r\n" + "from director t join movie_director m on t.id = m.id_director\r\n"
				+ "where m.id_movie =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Director c = new Director();
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
		List<Director> list = new MovieDirectorDao().get(893918);
		for (Director t : list) {
			System.out.println(t);
		}
	}
}
