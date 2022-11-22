package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Status;
import model.Type;
import model.User;

public class TypeDAO extends DBContext {
	public List<Type> getAll() {
		List<Type> list = new ArrayList<>();
		String sql = "select * from type";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Type t = new Type(rs.getInt("id"), rs.getString("name"), rs.getString("slug"));
				list.add(t);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	public List<Type> getAllById(int[] id) {
		List<Type> list = new ArrayList<>();
		String sql = "select * from type where id =?";
		for (int i : id) {

			try {
				PreparedStatement st = connection.prepareStatement(sql);
				st.setInt(1, i);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					Type t = new Type(rs.getInt("id"), rs.getString("name"), rs.getString("slug"));
					list.add(t);
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return list;
	}

	public Type getById(int id) {
		String sql = "select * from type where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Type t = new Type(rs.getInt("id"), rs.getString("name"), rs.getString("slug"));
				return t;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return null;
	}

	public static void main(String[] args) {
		List<Type> list = new TypeDAO().getAll();
		for (Type s : list) {
			System.out.println(s);
		}
	}
}
