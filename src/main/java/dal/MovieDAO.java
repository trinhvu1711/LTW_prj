package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Movie;

public class MovieDAO extends DBContext {
	public List<Movie> getAll() {
		List<Movie> list = new ArrayList<>();
		String sql = "select * from movie";
		StatusDAO sd = new StatusDAO();
		TypeDAO td = new TypeDAO();
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Movie m = new Movie(rs.getString("id"), rs.getString("name"), rs.getString("origin_name"),
						rs.getString("slug"), rs.getString("content"), rs.getString("thumb_url"),
						rs.getString("poster_url"), td.get(rs.getString("type_id")), sd.get(rs.getString("status_id")));
				list.add(m);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}
	public static void main(String[] args) {
		List<Movie> list = new MovieDAO().getAll();
		for (Movie m: list) {
			System.out.println(m.toString());
		}
	}
}
