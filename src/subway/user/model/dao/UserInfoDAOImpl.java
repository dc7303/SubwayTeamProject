package subway.user.model.dao;

import java.sql.SQLException;
import java.util.Properties;

import subway.model.util.DBUtil;
import subway.user.model.dto.OrderDTO;
import subway.user.model.dto.UserInfoDTO;

public class UserInfoDAOImpl implements UserInfoDAO {
	private Properties proFile = new DBUtil().getProperties();
	
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
		// TODO Auto-generated method stub
		return 0;
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
