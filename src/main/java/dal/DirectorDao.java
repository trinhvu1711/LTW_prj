package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Actor;
import model.Director;

public class DirectorDao extends DBContext {
	public List<Director> getAll() {
		List<Director> list = new ArrayList<>();
		String sql = "select * from director";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Director c = new Director();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setSlug(rs.getString("slug"));
				c.setThumb_url(rs.getString("thumb_url"));
				c.setMale(rs.getInt("is_male"));
				list.add(c);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	public List<Director> getAllById(int[] id) {
		List<Director> list = new ArrayList<>();
		String sql = "select * from Director where id =?";
		for (int i : id) {
			try {
				PreparedStatement st = connection.prepareStatement(sql);
				st.setInt(1, i);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					Director c = new Director();
					c.setId(rs.getInt("id"));
					c.setName(rs.getString("name"));
					c.setSlug(rs.getString("slug"));
					c.setThumb_url(rs.getString("thumb_url"));
					c.setMale(rs.getInt("is_male"));
					list.add(c);
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return list;
	}

	public Director getById(int id) {
		Director c = null;
		String sql = "select * from Director where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				c = new Director();
				c.setId(id);
				c.setName(rs.getString("name"));
				c.setSlug(rs.getString("slug"));
				c.setThumb_url(rs.getString("thumb_url"));
				c.setMale(rs.getInt("is_male"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return c;
	}

	public void add(Director c) {
		String sql = "insert into Director values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, c.getId());
			st.setString(2, c.getName());
			st.setString(3, c.getSlug());
			st.setString(4, c.getThumb_url());
			st.setInt(5, c.getMale());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void delete(int id) {
		String sql = "delete from Director where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void edit(Director c) {
		String sql = "update Director set name =?, slug =?, thumb_url=?, is_male=? where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, c.getName());
			st.setString(2, c.getSlug());
			st.setInt(5, c.getId());
			st.setString(3, c.getThumb_url());
			st.setInt(4, c.getMale());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		List<Director> list = new DirectorDao().getAll();
		for (Director a : list) {
			System.out.println(a);
		}
	}
}
