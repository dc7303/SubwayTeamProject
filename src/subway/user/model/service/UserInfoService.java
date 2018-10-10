package subway.user.model.service;

import java.sql.SQLException;

import subway.user.model.dao.UserInfoDAO;
import subway.user.model.dto.OrderDTO;
import subway.user.model.dto.UserInfoDTO;

public interface UserInfoService {
	
	/**
	 * 회원가입 Service
	 * 
	 * @param userDAO
	 */
	public int userSignUp(UserInfoDTO userDTO) throws SQLException;
	
	/**
	 * 유저 아이디 체크
	 * @param id
	 * @return UserInfoDTO
	 * @throws SQLException
	 */
	public UserInfoDTO userIdCheck(String id) throws SQLException;
	
	/**
	 * 로그인 Service
	 * @param id
	 * @param pw
	 * @return UserInfoDTO
	 */
	public UserInfoDTO userSignIn(String id, String pw) throws SQLException;
	
	/**
	 * 회원정보 수정 Service
	 * 
	 * @param userDTO
	 */
	public int userUpdate(UserInfoDTO userDTO) throws SQLException;
	
	/**
	 * 나만의 메뉴 Service 
	 * 
	 * @param menuDTO
	 */
	public int userMyMenu(OrderDTO orderDTO) throws SQLException;
	
	/**
	 * 회원 탈퇴 Service
	 * 
	 * @param id
	 * @param pw
	 * @param phone
	 * @return
	 */
	public int userDelete(String id, String pw, String phone) throws SQLException;


}
