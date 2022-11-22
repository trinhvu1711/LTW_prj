package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Region;
import model.Status;
import model.Type;

public class StatusDAO extends DBContext {
	public List<Status> getall() {
		List<Status> list = new ArrayList<>();
		String sql = "select * from status";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Status s = new Status(rs.getInt("id"), rs.getString("name"), rs.getString("slug"));
				list.add(s);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	public List<Status> getallById(int[] id) {
		List<Status> list = new ArrayList<>();
		String sql = "select * from status where id =?";
		for (int i : id) {
			try {
				PreparedStatement st = connection.prepareStatement(sql);
				st.setInt(1, i);
				ResultSet rs = st.executeQuery();
				while (rs.next()) {
					Status s = new Status(rs.getInt("id"), rs.getString("name"), rs.getString("slug"));
					list.add(s);
				}
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		return list;
	}

	public Status getById(int id) {
		String sql = "select * from status where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Status t = new Status(rs.getInt("id"), rs.getString("name"), rs.getString("slug"));
				return t;
			}
		} catch (SQLException e) {
			System.out.println(e);
		}

		return null;
	}
	
	public static void main(String[] args) {
		List<Status> list = new StatusDAO().getall();
		for (Status s : list) {
			System.out.println(s);
		}
	}
}
