package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Director;
import model.Movie;
import model.Studio;

public class MovieStudioDao extends DBContext{
	public void addAll(Movie m) {
		String sql = "insert into movie_studio values(?, ?)";
		List<Studio> directors = m.getStudios();
		for (Studio t : directors) {
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
		String sql = "delete from movie_studio where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public List<Studio> get(int id) {
		List<Studio> list = new ArrayList<>();
		String sql = "select t.id, t.name, t.slug\r\n" + "from studio t join movie_studio m on t.id = m.id_studio\r\n"
				+ "where m.id_movie =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Studio c = new Studio();
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
		List<Studio> list = new MovieStudioDao().get(893918);
		for (Studio t : list) {
			System.out.println(t);
		}
	}
}
