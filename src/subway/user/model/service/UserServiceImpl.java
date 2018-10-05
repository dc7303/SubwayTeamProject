package subway.user.model.service;

import java.sql.SQLException;

import subway.user.model.dao.UserDAO;
import subway.user.model.dao.UserDAOImpl;
import subway.user.model.dto.UserInfoDTO;
import subway.user.model.dto.UserMenuDTO;

public class UserServiceImpl implements UserService {
	private UserDAO userDAO = new UserDAOImpl();
	@Override
	public void userSignUp(UserDAO userDAO) throws SQLException{
		// TODO Auto-generated method stub

	}

	@Override
	public UserInfoDTO userSignIn(String id, String pw) throws SQLException{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void userUpdate(UserInfoDTO userDTO) throws SQLException{
		// TODO Auto-generated method stub

	}

	@Override
	public void userMyMenu(UserMenuDTO menuDTO) throws SQLException{
		// TODO Auto-generated method stub

	}

	@Override
	public int userDelete(String id, String pw, String phone) throws SQLException{
		// TODO Auto-generated method stub
		return 0;
	}

}
