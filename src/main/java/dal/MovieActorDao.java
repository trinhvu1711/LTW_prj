	package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Actor;
import model.Movie;
import model.Tag;

public class MovieActorDao extends DBContext {
	public void addAll(Movie m) {
		String sql = "insert into movie_actor values(?, ?)";
		List<Actor> actors = m.getActors();
		for (Actor t : actors) {
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
		String sql = "delete from movie_actor where id_movie =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public List<Actor> get(int id) {
		List<Actor> list = new ArrayList<>();
		String sql = "select t.id, t.name, t.slug\r\n" + "from actor t join movie_actor m on t.id = m.id_actor\r\n"
				+ "where m.id_movie =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Actor c = new Actor();
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
		List<Actor> list = new MovieActorDao().get(893918);
		for (Actor t : list) {
			System.out.println(t);
		}
		System.out.println(new MovieActorDao().get(169435));
	}
}
