package subway.user.model.service;

import java.sql.SQLException;

import subway.user.model.dao.UserInfoDAO;
import subway.user.model.dao.UserInfoDAOImpl;
import subway.user.model.dto.OrderDTO;
import subway.user.model.dto.UserInfoDTO;

public class UserInfoServiceImpl implements UserInfoService {
	private UserInfoDAO userDAO = new UserInfoDAOImpl();
	@Override
	public int userSignUp(UserInfoDTO userDTO) throws SQLException{
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public UserInfoDTO userSignIn(String id, String pw) throws SQLException{
		UserInfoDTO userInfoDTO = userDAO.userSignIn(id, pw);
		if(userInfoDTO == null) {
			throw new SQLException ("로그인 실패");
		}
		return userInfoDTO;
	}

	@Override
	public int userUpdate(UserInfoDTO userDTO) throws SQLException{
		int userUpdate = userDAO.userUpdate(userDTO);
		if(userUpdate == 0) {
			throw new SQLException("수정 실패");
		}
		return userUpdate;
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
