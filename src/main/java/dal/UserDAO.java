package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserDAO extends DBContext {
	public List<User> getAll() {
		List<User> list = new ArrayList<>();
		String sql = "SELECT [username], [password], [name] ,[role] FROM [dbo].[member]";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				User u = new User(rs.getString("username"), rs.getString("password"), rs.getString("name"),
						rs.getInt("role"));
				list.add(u);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}

	public User get(String username, String password) {
		User u = null;
		String sql = "select * from member where username =? and password = ?";
		try {

			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				u = new User(rs.getString("username"), rs.getString("password"), rs.getString("name"),
						rs.getInt("role"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return u;
	}

	public User findByUser(String username) {
		User u = null;
		String sql = "select * from member where username =? ";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				u = new User(rs.getString("username"), rs.getString("password"), rs.getString("name"),
						rs.getInt("role"));
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return u;
	}

	public void signup(String name, String email, String pass) {
		String sql = "insert into member values(?, ?, ?, 2)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, email);
			st.setString(2, pass);
			st.setString(3, name);
			st.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}

	public void updateProfile(User user, String nusername, String nname) {
		String sql = "update member set username=?, name=? where username=? and password=?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, nusername);
			st.setString(2, nname);
			st.setString(4, user.getPassword());
			st.setString(3, user.getUsername());
			st.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void changePassword(User user) {
		String sql = "update member set password =? where username =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(2, user.getUsername());
			st.setString(1, user.getPassword());
			st.executeUpdate();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		UserDAO ud = new UserDAO();
		User u = ud.get(null, null);
		System.out.println(u == null);
//		ud.signup("sada", "longvu1711@gmail.com", "123");
//		List<User> list = ud.getAll();
//		for (User u : list) {
//			System.out.println(u.getUsername());
//			System.out.println(u.getPassword());
//			System.out.println(u.getRole());
//		}
	}
}
