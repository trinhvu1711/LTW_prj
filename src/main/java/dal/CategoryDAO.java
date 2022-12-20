package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Actor;
import model.Category;

public class CategoryDAO extends DBContext {
	
	public List<Category> getAll(){
		List<Category> list = new ArrayList<>();
		String sql = "select * from category order by name";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
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
	
	public List<Category> getAllById(int[] id){
		List<Category> result = new ArrayList<>();
		for (int i : id) {
			String sql = "select * from Category where id =?";
			try {
				PreparedStatement st = connection.prepareStatement(sql);
				st.setInt(1, i);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					Category c = new Category();
					c.setId(rs.getInt("id"));
					c.setName(rs.getString("name"));
					c.setSlug(rs.getString("slug"));
					result.add(c);
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
			
		}
		return result;
	}
	
	public Category getById(int id){
		Category c = null;
		String sql = "select * from category where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				c = new Category();
				c.setId(id);
				c.setName(rs.getString("name"));
				c.setSlug(rs.getString("slug"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return c;
	}
	
	public Category get(String name, String slug){
		Category c = null;
		String sql = "select * from category where name = ? or slug =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, name);
			st.setString(2, slug);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				c = new Category();
				c.setName(rs.getString("name"));
				c.setSlug(rs.getString("slug"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return c;
	}
	
	public void add(Category c) {
		String sql = "insert into category values(?, ?, ?)";
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
		String sql = "delete from category where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void edit(Category c) {
		String sql = "update category set name =?, slug =? where id =?";
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
		System.out.println(new CategoryDAO().getById(123124));
	}
}
