package subway.user.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

import subway.dbUtil.DBUtil;
import subway.user.model.dto.OrderDTO;
import subway.user.model.dto.UserInfoDTO;

public class UserInfoDAOImpl implements UserInfoDAO {
	private Properties proFile = new DBUtil().getProFile();
	
	@Override
	public int userSignUp(UserInfoDTO userDTO) throws SQLException{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfoDTO userSignIn(String id, String pw) throws SQLException {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int userDelete(String id, String pw, String phone) throws SQLException{
		// TODO Auto-generated method stub
		return 0;
	}

}
