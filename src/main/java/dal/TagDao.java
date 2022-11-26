package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Tag;

public class TagDao extends DBContext {
	public List<Tag> getAll() {
		List<Tag> list = new ArrayList<>();
		String sql = "select * from tag";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
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

	public List<Tag> getAllById(int[] id) {
		List<Tag> list = new ArrayList<>();
		String sql = "select * from Tag where id =?";
		if (id.length > 0 && id != null)
		for (int i : id) {
			try {
				PreparedStatement st = connection.prepareStatement(sql);
				st.setInt(1, i);
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
		}
		return list;
	}

	public Tag getById(int id) {
		Tag c = null;
		String sql = "select * from Tag where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				c = new Tag();
				c.setId(id);
				c.setName(rs.getString("name"));
				c.setSlug(rs.getString("slug"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return c;
	}

	public Tag get(String name, String slug) {
		Tag c = null;
		String sql = "select * from Tag where name = ? or slug =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, slug);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				c = new Tag();
				c.setName(rs.getString("name"));
				c.setSlug(rs.getString("slug"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return c;
	}

	public void add(Tag c) {
		String sql = "insert into Tag values(?, ?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, c.getId());
			st.setString(2, c.getName());
			st.setString(3, c.getSlug());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void delete(int id) {
		String sql = "delete from Tag where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void edit(Tag c) {
		String sql = "update Tag set name =?, slug =? where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, c.getName());
			st.setString(2, c.getSlug());
			st.setInt(3, c.getId());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		List<Tag> list = new TagDao().getAll();
		for (Tag c : list) {
			System.out.println(c);
		}
//		System.out.println(new RegionDao().getById(123124));
	}
}
