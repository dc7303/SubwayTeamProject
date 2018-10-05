package subway.user.model.service;

import java.sql.SQLException;

import subway.user.model.dao.UserDAO;
import subway.user.model.dto.UserInfoDTO;
import subway.user.model.dto.UserMenuDTO;

public interface UserService {
	
	/**
	 * ȸ������ Service
	 * �ͼ����� throws�ϰ� ������ service���� success
	 * @param userDAO
	 */
	public void userSignUp(UserDAO userDAO) throws SQLException;
	
	/**
	 * �α��� Service
	 * @param id
	 * @param pw
	 * @return UserInfoDTO
	 */
	public UserInfoDTO userSignIn(String id, String pw) throws SQLException;
	
	/**
	 * ȸ������ ���� Service
	 * �ͼ����� throws�ϰ� ������ service���� success
	 * @param userDTO
	 */
	public void userUpdate(UserInfoDTO userDTO) throws SQLException;
	
	/**
	 * ������ �޴� Service 
	 * �ͼ����� throws�ϰ� ������ service���� success
	 * @param menuDTO
	 */
	public void userMyMenu(UserMenuDTO menuDTO) throws SQLException;
	
	/**
	 * ȸ�� Ż�� Service
	 * �ͼ����� throws�ϰ� ������ service���� success
	 * @param id
	 * @param pw
	 * @param phone
	 * @return
	 */
	public int userDelete(String id, String pw, String phone) throws SQLException;
}
