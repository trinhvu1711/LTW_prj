package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.Comment;

public class CommentDao extends DBContext {
	public List<Comment> getComments(int id){
		List<Comment> list = new ArrayList<>();
		String sql = "select * from comment where id_movie =? order by id desc";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rs = st.executeQuery();
			while (rs.next()) {
				Comment c = new Comment();
				c.setContent(rs.getString("comment_content"));
				c.setId_movie(id);
				c.setUsername(rs.getString("username"));
				c.setName(rs.getString("name"));
				c.setPath(rs.getString("path"));
				c.setId(Integer.parseInt(rs.getString("id")));
				list.add(c);
			}
		} catch (SQLException e) {
			System.out.println(e);
		}
		return list;
	}
	public void addComment(Comment comment) {
		Calendar cal = Calendar.getInstance(); 
		java.sql.Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
		String sql = "insert into comment(id_movie, username, name, path, comment_content, date) values(?, ?, ?, ?,?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, comment.getId_movie());
			st.setString(2, comment.getUsername());
			st.setString(3, comment.getName());
			st.setString(4, comment.getPath());
			st.setString(5, comment.getContent());
			st.setTimestamp(6, timestamp);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void deleteComment(int id) {
		String sql = "delete from comment where id =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
