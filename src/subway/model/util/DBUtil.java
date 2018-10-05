package subway.model.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
	private static Properties proFile = new Properties();
	
	static {
		try {
			Class.forName(proFile.getProperty("driverName"));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public static Properties getProperties () {
		return proFile;
	}
	
	public static Connection getConnection() throws SQLException{
		return DriverManager.getConnection(proFile.getProperty("url"), proFile.getProperty("userName"), proFile.getProperty("userPass"));
		
	}
	
	public static void dbClose(Connection con, PreparedStatement ps) {
		try {
			if(con != null) con.close();
			if(ps != null) ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void dbClose(Connection con, PreparedStatement ps, ResultSet rs) {
		try {
			dbClose(con,ps);
			if(rs != null) rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
