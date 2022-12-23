package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;

public class MovieViewDao extends DBContext {
	public void addView(int id) {
		Calendar cal = Calendar.getInstance(); 
		java.sql.Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
		String sql = "insert into movie_view values(?, ?,?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id);
			st.setInt(2, 1);
			st.setTimestamp(3, timestamp);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
		sql = "update movie set view_total = ?, view_day=?, view_week=?, view_month=? where id=?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			MovieViewDao mvd = new MovieViewDao();
			st.setInt(1, mvd.getView(id));
			st.setInt(2, mvd.getViewByDay(id));
			st.setInt(3, mvd.getViewByWeek(id));
			st.setInt(4, mvd.getViewByMonth(id));
			st.setInt(5, id);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

	public int getViewByYear(int id_movie) {
		LocalDate currentdate = LocalDate.now();
		int result = 0;
		String sql = "select sum(num_view) from movie_view where id_movie =? and year(date) = ? ";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(2, currentdate.getYear());
			st.setInt(1, id_movie);
			ResultSet rs = st.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}

	public int getViewByMonth(int id_movie) {
		int result = 0;
		LocalDate currentdate = LocalDate.now();
		String sql = "select sum(num_view) from movie_view where id_movie =? and month(date) = ? and year(date) = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(2, currentdate.getMonthValue());
			st.setInt(3, currentdate.getYear());
			st.setInt(1, id_movie);
			ResultSet rs = st.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}

	public int getViewByDay(int id_movie) {
		LocalDate currentdate = LocalDate.now();
		int result = 0;
		String sql = "select sum(num_view) from movie_view where id_movie =? and day(date) =? and month(date) = ? and year(date) = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, id_movie);
			st.setInt(2, currentdate.getDayOfMonth());
			st.setInt(3, currentdate.getMonthValue());
			st.setInt(4, currentdate.getYear());
			ResultSet rs = st.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}

	public int getViewByWeek(int id_movie) {
		int result =0;
		String sql = "select sum(num_view) from movie_view where id_movie =? and datediff(ww,date,?) < 1 ";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setDate(2, java.sql.Date.valueOf(java.time.LocalDate.now()));
			st.setInt(1, id_movie);
			ResultSet rs = st.executeQuery();
			if (rs.next()) return  rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}

	public int getView(int id_movie) {
		int result = 0;
		String sql = "select sum(num_view) from movie_view where id_movie =?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);

			st.setInt(1, id_movie);
			ResultSet rs = st.executeQuery();
			if (rs.next())
				return rs.getInt(1);
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
			if (rs.next())
				return false;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(new MovieViewDao().getViewByYear(115876));
		LocalDate currentdate = LocalDate.now();
		System.out.println(currentdate.getDayOfMonth());
	}
}
