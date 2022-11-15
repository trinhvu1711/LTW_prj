package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Status;

public class StatusDAO extends DBContext {
	public List<Status> getall(){
		List<Status> list = new ArrayList<>();
		String sql = "select * from status";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Status s = new Status(rs.getString("status_id"), rs.getString("status_name"));
				list.add(s);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}
	
	public Status get(String id) {
		String sql = "select * from status where status_id = ?";
		Status s = null;
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				s = new Status(rs.getString("status_id"), rs.getString("status_name"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return s;
	}
	
}
