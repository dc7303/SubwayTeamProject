package subway.dbUtil;
/**
 * DB������ ���� �ε�, ����, �ݱ� ��� Ŭ����
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
	 * �ε�
	 */
	static {	//���κ��ٵ� ���� ����ȴ�.
		try {
			//2���� properties file �ε��ϱ�
			//properies�� ����ϴ� ������ ����ؼ� key���� ����ؾ��ϱ� ������ ResourceBundle���ٴ� porperties�� �����ϴ�.
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
	 * ����
	 */
	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(proFile.getProperty("url"), proFile.getProperty("userName"),proFile.getProperty("userPass"));
	}
	
	/**
	 * �ݱ� (insert, update, delete�� ���)
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
	 * �ݱ� (select�� ���)
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
