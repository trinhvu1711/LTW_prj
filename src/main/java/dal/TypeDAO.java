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
	public List<Type> getAll(){
		List<Type> list = new ArrayList<>();
		String sql = "select * from type";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Type t = new Type(rs.getString("type_id"), rs.getString("type_name"));
				list.add(t);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}
	
	public Type get(String id) {
		String sql = "select * from type where type_id = ?";
		Type t = null;
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				t = new Type(rs.getString("type_id"), rs.getString("type_name"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return t;
	}
}
