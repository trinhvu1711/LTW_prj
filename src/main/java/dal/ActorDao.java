package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Actor;
import model.Region;

public class ActorDao extends DBContext {
	public List<Actor> getAll() {
		List<Actor> list = new ArrayList<>();
		String sql = "select * from actor";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Actor c = new Actor();
				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setSlug(rs.getString("slug"));
				c.setThumb_url(rs.getString("thumb_url"));
				c.setIsMale(rs.getInt("is_male"));
				list.add(c);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	public Actor getById(int id) {
		Actor c = null;
		String sql = "select * from actor where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				c = new Actor();
				c.setId(id);
				c.setName(rs.getString("name"));
				c.setSlug(rs.getString("slug"));
				c.setThumb_url(rs.getString("thumb_url"));
				c.setIsMale(rs.getInt("is_male"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return c;
	}

	public void add(Actor c) {
		String sql = "insert into actor values(?, ?, ?, ?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, c.getId());
			st.setString(2, c.getName());
			st.setString(3, c.getSlug());
			st.setString(4, c.getThumb_url());
			st.setInt(5, c.getIsMale());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void delete(int id) {
		String sql = "delete from actor where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public void edit(Actor c) {
		String sql = "update actor set name =?, slug =?, thumb_url=?, is_male=? where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, c.getName());
			st.setString(2, c.getSlug());
			st.setInt(5, c.getId());
			st.setString(3, c.getThumb_url());
			st.setInt(4, c.getIsMale());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public List<Actor> getAllById(int[] id) {
		List<Actor> result = new ArrayList<>();
		for (int i : id) {
			String sql = "select * from actor where id =?";
			try {
				PreparedStatement st = connection.prepareStatement(sql);
				st.setInt(1, i);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					Actor c = new Actor();
					c.setId(i);
					c.setName(rs.getString("name"));
					c.setSlug(rs.getString("slug"));
					c.setThumb_url(rs.getString("thumb_url"));
					c.setIsMale(rs.getInt("is_male"));
					result.add(c);
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
			
		}
		return result;
	}

	
	public static void main(String[] args) {
		List<Actor> list = new ActorDao().getAll();
		for (Actor a : list) {
			System.out.println(a);
		}
	}
}
