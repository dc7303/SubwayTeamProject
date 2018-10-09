package subway.user.controller;

import subway.user.model.dto.OrderDTO;
import subway.user.model.dto.UserInfoDTO;
import subway.user.model.service.UserInfoService;
import subway.user.model.service.UserInfoServiceImpl;

public class UserInfoController {
	private static UserInfoService service = new UserInfoServiceImpl();
	/**
	 * 회원가입
	 * @param userDTO
	 */
	public static int userSignUp(UserInfoDTO userDTO) {
		
		return 0;
	}
	
	/**
	 * 로그인
	 * @param id
	 * @param pw
	 * 
	 */
	public static UserInfoDTO userSignIn(String id, String pw) {
		
		UserInfoDTO user = new UserInfoDTO("C62", "123123");
		
		//return user;
		return null;
	}
	
	/**
	 * 회원정보 수정
	 * @param userDTO
	 */
	public static int userUpdate(UserInfoDTO userDTO) {
		
		return 0;
	}
	
	
	/**
	 * 회원탈퇴
	 * @param id
	 * @param pw
	 * @param phone
	 */
	public static int userDelete(String id, String pw, String phone) {
		
		return 0;
	}
}
