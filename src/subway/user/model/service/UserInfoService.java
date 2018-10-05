package subway.user.model.service;

import java.sql.SQLException;

import subway.user.model.dao.UserInfoDAO;
import subway.user.model.dto.OrderDTO;
import subway.user.model.dto.UserInfoDTO;

public interface UserInfoService {
	
	/**
	 * ȸ������ Service
	 * �ͼ����� throws�ϰ� ������ service���� success
	 * @param userDAO
	 */
	public void userSignUp(UserInfoDAO userDAO) throws SQLException;
	
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
	public void userMyMenu(OrderDTO orderDTO) throws SQLException;
	
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
