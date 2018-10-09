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
		int re = userDAO.userSignUp(userDTO);
		if(re==0)throw new SQLException("가입되지 않았습니다.");
		return re;
	}

	@Override
	public UserInfoDTO userSignIn(String id, String pw) throws SQLException{
<<<<<<< HEAD
			UserInfoDTO userDTO = userDAO.userSignIn(id, pw);
			if(userDTO == null) {
				throw new SQLException ("로그인 실패");
			}
			return userDTO;
=======
		UserInfoDTO userInfoDTO = userDAO.userSignIn(id, pw);
		if(userInfoDTO == null) {
			throw new SQLException ("로그인 실패");
		}
		return userInfoDTO;
>>>>>>> 411382a5dab6e6d265612c9f46c2ea57f396b063
	}

	@Override
	public int userUpdate(UserInfoDTO userDTO) throws SQLException{
		int userUpdate = userDAO.userUpdate(userDTO);
		if(userUpdate == 0) {
<<<<<<< HEAD
			throw new SQLException("수정실패");
=======
			throw new SQLException("수정 실패");
>>>>>>> 411382a5dab6e6d265612c9f46c2ea57f396b063
		}
		return userUpdate;
	}

	@Override
	public int userMyMenu(OrderDTO orderDTO) throws SQLException{
		int re = userDAO.userMyMenu(orderDTO);
		if(re==0) throw new SQLException("MY MENU가 존재하지 않습니다.");
		return re;
	}

	@Override
	public int userDelete(String id, String pw, String phone) throws SQLException{
		// TODO Auto-generated method stub
		return 0;
	}

}
