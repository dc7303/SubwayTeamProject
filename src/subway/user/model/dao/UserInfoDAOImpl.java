package subway.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import subway.dbUtil.DBUtil;
import subway.user.model.dto.OrderDTO;
import subway.user.model.dto.UserInfoDTO;

public class UserInfoDAOImpl implements UserInfoDAO {
	private Properties proFile = new DBUtil().getProFile();
	
	@Override
	public int userSignUp(UserInfoDTO userDTO) throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		try {
		con=DBUtil.getConnection();
		ps=con.prepareStatement("INSERT INTO USERS(USER_ID, USER_PASS, USER_NAME, USER_PHONE, USER_EMAIL) VALUES(?,?,?,?,?)");
		ps.setString(1, userDTO.getUserId());
		ps.setString(2, userDTO.getUserPw());
		ps.setString(3, userDTO.getUserName());
		ps.setString(4, userDTO.getUserPhone());
		ps.setString(5, userDTO.getUserEmail());
		
		result = ps.executeUpdate();
		}finally{
			DBUtil.dbClose( ps , con);
		}
		return result;
	}

	@Override 
	public UserInfoDTO userSignIn(String id, String pw) throws SQLException {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		UserInfoDTO userDTO = null;
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("SELECT USER_ID, USER_PASS, USER_NAME, USER_PHONE, USER_EMAIL FROM USERS WHERE USER_ID=? AND USER_PASS=?");
			ps.setString(1, id);
			ps.setString(2, pw);
			rs = ps.executeQuery();
			
			if(rs.next()) {   //???????
				userDTO = new UserInfoDTO(rs.getString(1), rs.getString(2), rs.getString(3),
						rs.getString(4), rs.getString(5));
			}
		}finally {
			DBUtil.dbClose(rs, ps, con);
		}
		return userDTO;
	}

	@Override
	public int userUpdate(UserInfoDTO userDTO) throws SQLException{
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		
		try {
			con = DBUtil.getConnection();
			ps = con.prepareStatement("UPDATE USERS SET USER_PASS=?, USER_NAME=?,USER_PHONE=?,USER_EMAIL=? WHERE USER_ID=?");
			ps.setString(1, userDTO.getUserPw());
			ps.setString(2, userDTO.getUserName());
			ps.setString(3, userDTO.getUserPhone());
			ps.setString(4, userDTO.getUserEmail());
			ps.setString(5, userDTO.getUserId());
			result = ps.executeUpdate();
			
		}finally {
			DBUtil.dbClose(ps, con);
		}
		return result;
	}

	@Override
	public int userMyMenu(OrderDTO orderDTO) throws SQLException{
		Connection con=null;
		PreparedStatement ps=null;
		int result=0;
		try {
		con=DBUtil.getConnection();
		ps=con.prepareStatement("SELECT * FROM ORDERS WHERE ORDER_USER = 'À¯ÀúID' AND ORDER_IS_MY_MENU = 'TRUE'");
		ps.setString(1, orderDTO.getOrderUser());
		ps.setString(2, orderDTO.getOrderIsMyMenu());
		result = ps.executeUpdate();
		}finally {
			DBUtil.dbClose( ps , con);
		}
		return 0;
	}

	@Override
	public int userDelete(String id, String pw, String phone) throws SQLException{
		// TODO Auto-generated method stub
		return 0;
	}

}
