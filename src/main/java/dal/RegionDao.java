package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Region;

public class RegionDao extends DBContext {
	public List<Region> getAll() {
		List<Region> list = new ArrayList<>();
		String sql = "select * from region order by name";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
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

	public List<Region> getAllById(int id[]) {
		List<Region> list = new ArrayList<>();
		String sql = "select * from region where id =?";
		for (int i : id) {

			try {
				PreparedStatement st = connection.prepareStatement(sql);
				st.setInt(1, i);
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

		}
		return list;
	}

	public Region getById(int id) {
		Region c = null;
		String sql = "select * from region where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				c = new Region();
				c.setId(id);
				c.setName(rs.getString("name"));
				c.setSlug(rs.getString("slug"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return c;
	}

	public Region get(String name, String slug) {
		Region c = null;
		String sql = "select * from region where name = ? or slug =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, slug);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				c = new Region();
				c.setName(rs.getString("name"));
				c.setSlug(rs.getString("slug"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return c;
	}

	public void add(Region c) {
		String sql = "insert into region values(?, ?, ?)";
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
		String sql = "delete from region where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void edit(Region c) {
		String sql = "update region set name =?, slug =? where id =?";
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
//		List<Category> list = new CategoryDAO().getAll();
//		for (Category c:list) {
//			System.out.println(c);
//		}
		System.out.println(new RegionDao().getById(123124));
	}
}
