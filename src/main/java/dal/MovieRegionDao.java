package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Director;
import model.Movie;
import model.Region;

public class MovieRegionDao extends DBContext {
	public void addAll(Movie m) {
		String sql = "insert into movie_region values(?, ?)";
		List<Region> regions = m.getRegions();
		for (Region t : regions) {
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
		String sql = "delete from movie_region where id_movie =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public List<Region> get(int id) {
		List<Region> list = new ArrayList<>();
		String sql = "select t.id, t.name, t.slug\r\n" + "from region t join movie_region m on t.id = m.id_region\r\n"
				+ "where m.id_movie =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Region c = new Region();
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
		List<Region> list = new MovieRegionDao().get(893918);
		for (Region t : list) {
			System.out.println(t);
		}
	}
}
