package subway.user.model.service;

import java.sql.SQLException;

import subway.user.model.dao.UserInfoDAO;
import subway.user.model.dto.OrderDTO;
import subway.user.model.dto.UserInfoDTO;

public interface UserInfoService {
	
	/**
	 * 회원가입 Service
	 * 익셉션은 throws하고 성공시 service에서 success
	 * @param userDAO
	 */
	public void userSignUp(UserInfoDAO userDAO) throws SQLException;
	
	/**
	 * 로그인 Service
	 * @param id
	 * @param pw
	 * @return UserInfoDTO
	 */
	public UserInfoDTO userSignIn(String id, String pw) throws SQLException;
	
	/**
	 * 회원정보 수정 Service
	 * 익셉션은 throws하고 성공시 service에서 success
	 * @param userDTO
	 */
	public void userUpdate(UserInfoDTO userDTO) throws SQLException;
	
	/**
	 * 나만의 메뉴 Service 
	 * 익셉션은 throws하고 성공시 service에서 success
	 * @param menuDTO
	 */
	public void userMyMenu(OrderDTO orderDTO) throws SQLException;
	
	/**
	 * 회원 탈퇴 Service
	 * 익셉션은 throws하고 성공시 service에서 success
	 * @param id
	 * @param pw
	 * @param phone
	 * @return
	 */
	public int userDelete(String id, String pw, String phone) throws SQLException;
}
