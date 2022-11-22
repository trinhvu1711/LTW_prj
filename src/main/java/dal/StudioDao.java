package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Studio;

public class StudioDao extends DBContext {
	public List<Studio> getAll() {
		List<Studio> list = new ArrayList<>();
		String sql = "select * from studio";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Studio c = new Studio();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setSlug(rs.getString("slug"));
				c.setThumb_url(rs.getString("thumb_url"));
				list.add(c);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	public List<Studio> getAllById(int[] id) {
		List<Studio> list = new ArrayList<>();
		String sql = "select * from Studio where id =?";
		for (int i : id) {
			try {
				PreparedStatement st = connection.prepareStatement(sql);
				st.setInt(1, i);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					Studio c = new Studio();
					c.setId(rs.getInt("id"));
					c.setName(rs.getString("name"));
					c.setSlug(rs.getString("slug"));
					c.setThumb_url(rs.getString("thumb_url"));
					list.add(c);
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return list;
	}

	public Studio getById(int id) {
		Studio c = null;
		String sql = "select * from Studio where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				c = new Studio();
				c.setId(id);
				c.setName(rs.getString("name"));
				c.setSlug(rs.getString("slug"));
				c.setThumb_url(rs.getString("thumb_url"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return c;
	}

	public void add(Studio c) {
		String sql = "insert into Studio values(?, ?, ?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, c.getId());
			st.setString(2, c.getName());
			st.setString(3, c.getSlug());
			st.setString(4, c.getThumb_url());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void delete(int id) {
		String sql = "delete from Studio where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void edit(Studio c) {
		String sql = "update Studio set name =?, slug =?, thumb_url=? where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, c.getName());
			st.setString(2, c.getSlug());
			st.setInt(4, c.getId());
			st.setString(3, c.getThumb_url());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		List<Studio> list = new StudioDao().getAll();
		for (Studio a : list) {
			System.out.println(a);
		}
	}
}
