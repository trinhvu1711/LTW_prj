package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MovieViewDao extends DBContext {
	public void addView(Date date, int id) {
		if (new MovieViewDao().check(date, id)) {
			String sql = "insert into movie_view values(?, ?,?)";
			try {
				PreparedStatement st = connection.prepareStatement(sql);
				st.setInt(1, id);
				st.setInt(2, 1);
				st.setDate(3, date);
				st.executeUpdate();
			} catch (SQLException e) {
				System.out.println(e);
			}
		}
		else {
			String sql = "update movie_view set num_view = num_view+1 where id_movie =?";
			String sql1 = "update movie set view_total = ? where id_movie =?";
			String sql2 = "update movie set view_day = ? where id_movie =?";
			String sql3 = "update movie set view_week = ? where id_movie =?";
			String sql4 = "update movie set view_month = ? where id_movie =?";
			try {
				PreparedStatement st = connection.prepareStatement(sql);
				st.setInt(1, id);
				st.executeUpdate();
				
				st = connection.prepareStatement(sql1);
				st.setInt(1, new MovieViewDao().getView(id));
				st.setInt(2, id);
				
				st = connection.prepareStatement(sql2);
				st.setInt(1, new MovieViewDao().getViewByDay(id, new Date(System.currentTimeMillis())));
				st.setInt(2, id);
				st.executeUpdate();
				
//				st = connection.prepareStatement(sql3);
//				st.setInt(1, new MovieViewDao().getViewByWeek(id, new Date(System.currentTimeMillis())));
//				st.setInt(2, id);
//				st.executeUpdate();
				
				st = connection.prepareStatement(sql4);
				st.setInt(1, new MovieViewDao().getViewByMonth(id, new Date(System.currentTimeMillis())));
				st.setInt(2, id);
				st.executeUpdate();
			} catch (SQLException e1) {
				System.out.println(e1);
			}
		}
	}
	
	public int getViewByYear(int id_movie, Date date) {
		int result =0;
		String sql = "  select sum(num_view) from movie_view where id_movie =? and year(date) =? ";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setDate(2, date);
			st.setInt(1, id_movie);
			ResultSet rs = st.executeQuery();
			if (rs.next()) return rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	public int getViewByMonth(int id_movie, Date date) {
		int result =0;
		String sql = "  select sum(num_view) from movie_view where id_movie =? and year(date) =? and month(date) =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setDate(3, date);
			st.setDate(2, date);
			st.setInt(1, id_movie);
			ResultSet rs = st.executeQuery();
			if (rs.next()) return rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	public int getViewByDay(int id_movie, Date date) {
		int result =0;
		String sql = "select sum(num_view) from movie_view where id_movie =? and date =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setDate(2, date);
			st.setInt(1, id_movie);
			ResultSet rs = st.executeQuery();
			if (rs.next()) return  rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
//	public int getViewByWeek(int id_movie, Date date) {
//		int result =0;
//		String sql = "select sum(num_view) from movie_view where id_movie =? and datediff(ww,date,? as date) < 1 ";
//		try {
//			PreparedStatement st = connection.prepareStatement(sql);
//		
//			st.setDate(2, date);
//			st.setInt(1, id_movie);
//			ResultSet rs = st.executeQuery();
//			if (rs.next()) return  rs.getInt(1);
//		} catch (SQLException e) {
//			System.out.println(e);
//		}
//		return result;
//	}
	
	public int getView(int id_movie) {
		int result =0;
		String sql = "select sum(num_view) from movie_view where id_movie =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
		
			st.setInt(1, id_movie);
			ResultSet rs = st.executeQuery();
			if (rs.next()) return  rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}
	
	public boolean check(Date date, int id) {
		String sql = "select * from movie_view where date = ? and id_movie =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setDate(1, date);
			st.setInt(2, id);
			ResultSet rs = st.executeQuery();
			if (rs.next()) return false;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(new MovieViewDao().getViewByDay(169435, new Date(System.currentTimeMillis())));
	}
}
