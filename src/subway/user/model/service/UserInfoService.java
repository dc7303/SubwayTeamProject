package subway.user.model.service;

import java.sql.SQLException;

import subway.user.model.dao.UserInfoDAO;
import subway.user.model.dto.OrderDTO;
import subway.user.model.dto.UserInfoDTO;

public interface UserInfoService {
	
	/**
	 * ȸ������ Service
	 * 
	 * @param userDAO
	 */
	public int userSignUp(UserInfoDTO userDTO) throws SQLException;
	
	/**
	 * ���� ���̵� üũ
	 * @param id
	 * @return UserInfoDTO
	 * @throws SQLException
	 */
	public UserInfoDTO userIdCheck(String id) throws SQLException;
	
	/**
	 * �α��� Service
	 * @param id
	 * @param pw
	 * @return UserInfoDTO
	 */
	public UserInfoDTO userSignIn(String id, String pw) throws SQLException;
	
	/**
	 * ȸ������ ���� Service
	 * 
	 * @param userDTO
	 */
	public int userUpdate(UserInfoDTO userDTO) throws SQLException;
	
	/**
	 * ������ �޴� Service 
	 * 
	 * @param menuDTO
	 */
	public int userMyMenu(OrderDTO orderDTO) throws SQLException;
	
	/**
	 * ȸ�� Ż�� Service
	 * 
	 * @param id
	 * @param pw
	 * @param phone
	 * @return
	 */
	public int userDelete(String id, String pw, String phone) throws SQLException;


}
