package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.ImageProfile;

public class ImageProfileDao extends DBContext{
	public ImageProfile getImage(String username) {
		String sql ="select * from image_profile where username =?";
		ImageProfile image = new ImageProfile();
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				image.setName(rs.getString("image_name"));
				image.setPath(rs.getString("image_path"));
				image.setUsername(username);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return image;
	}
	
	public String getImagePath(int id) {
		String result="";
		String sql ="select * from image_profile where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				result = rs.getString("image_path");
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	public void addImage(ImageProfile imageProfile) {
		String sql ="insert into image_profile(image_name, image_path, username) values (?, ?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setString(1, imageProfile.getName());
			st.setString(2, imageProfile.getPath());
			st.setString(3, imageProfile.getUsername());
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
