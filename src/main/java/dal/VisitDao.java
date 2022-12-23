package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.Calendar;

public class VisitDao extends DBContext {
	public void addVisit() {
		Calendar cal = Calendar.getInstance(); 
		java.sql.Timestamp timestamp = new Timestamp(cal.getTimeInMillis());
		String sql = "insert into visit values(?, ?)";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setTimestamp(1, timestamp);
			st.setInt(2, 1);
			st.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public int getViewByYear() {
		LocalDate currentdate = LocalDate.now();
		int result = 0;
		String sql = "select sum(num_visit) from visit where year(date) = ? ";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, currentdate.getYear());
			ResultSet rs = st.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}

	public int getViewByMonth() {
		int result = 0;
		LocalDate currentdate = LocalDate.now();
		String sql = "select sum(num_visit) from visit where month(date) = ? and year(date) = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, currentdate.getMonthValue());
			st.setInt(2, currentdate.getYear());
			ResultSet rs = st.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}

	public int getViewByDay() {
		LocalDate currentdate = LocalDate.now();
		int result = 0;
		String sql = "select sum(num_visit) from visit where day(date) =? and month(date) = ? and year(date) = ?";
		try {
			PreparedStatement st = connection.prepareStatement(sql);
			st.setInt(1, currentdate.getDayOfMonth());
			st.setInt(2, currentdate.getMonthValue());
			st.setInt(3, currentdate.getYear());
			ResultSet rs = st.executeQuery();
			if (rs.next())
				return rs.getInt(1);
		} catch (SQLException e) {
			System.out.println(e);
		}
		return result;
	}
}
