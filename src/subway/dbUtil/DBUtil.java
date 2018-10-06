package subway.dbUtil;
/**
 * DB연동을 위한 로드, 연결, 닫기 기능 클래스
 */

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import subway.user.view.FailView;
 
public class DBUtil { 
	private static Properties proFile = new Properties();
	/**
	 * 로드
	 */
	static {	//메인보다도 먼저 실행된다.
		try {
			//2개의 properties file 로딩하기
			//properies를 사용하는 이유는 계속해서 key값을 사용해야하기 때문에 ResourceBundle보다는 porperties가 적합하다.
			proFile.load(new FileInputStream("properties/board.properties"));
			proFile.load(new FileInputStream("properties/dbInfo.properties"));
			
			Class.forName(proFile.getProperty("driverName"));
		} catch (Exception e) {
			FailView.errorMessage(e.getMessage());
		}
	}
	
	public static Properties getProFile() {
		return proFile;
	}
	
	/**
	 * 연결
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(proFile.getProperty("url"), proFile.getProperty("userName"),proFile.getProperty("userPass"));
	}
	
	/**
	 * 닫기 (insert, update, delete인 경우)
	 */
	public static void dbClose(Statement st, Connection con) {
		try {
			if(st != null) st.close();
			if(con != null) con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 닫기 (select인 경우)
	 */
	public static void dbClose(ResultSet rs, Statement st, Connection con) {
		try {
			if(rs != null) rs.close();
			dbClose(st, con);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
