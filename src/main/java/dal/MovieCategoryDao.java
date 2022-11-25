package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Category;
import model.Movie;
import model.Tag;

public class MovieCategoryDao extends DBContext {
	public void addAll(Movie m) {
		String sql = "insert into movie_category values(?, ?)";
		List<Category> directors = m.getCategories();
		for (Category t : directors) {
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
		String sql = "delete from movie_category where id_movie =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public List<Category> get(int id) {
		List<Category> list = new ArrayList<>();
		String sql = "select t.id, t.name, t.slug\r\n" + "from category t join movie_category m on t.id = m.id_category\r\n"
				+ "where m.id_movie =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Category c = new Category();
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

	public List<Integer> getListId(int id) {
		List<Integer> list = new ArrayList<>();
		String sql = "select t.id" + "from category t join movie_category m on t.id = m.id_category\r\n"
				+ "where m.id_movie =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				list.add(rs.getInt("id"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}
	
	public static void main(String[] args) {
		List<Category> list = new MovieCategoryDao().get(893918);
		for (Category t : list) {
			System.out.println(t);
		}
	}
}
