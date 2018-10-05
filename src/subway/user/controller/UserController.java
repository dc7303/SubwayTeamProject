package subway.user.controller;

import subway.user.model.dto.UserInfoDTO;
import subway.user.model.dto.UserMenuDTO;
import subway.user.model.service.UserService;
import subway.user.model.service.UserServiceImpl;

public class UserController {
	private UserService service = new UserServiceImpl();
	/**
	 * 회원가입
	 * @param userDTO
	 */
	public static void userSignUp(UserInfoDTO userDTO) {
		
	}
	
	/**
	 * 로그인
	 * @param id
	 * @param pw
	 */
	public static void userSignIn(String id, String pw) {
		
	}
	
	/**
	 * 회원정보 수정
	 * @param userDTO
	 */
	public static void userUpdate(UserInfoDTO userDTO) {
		
	}
	
	/**
	 * 나만의 메뉴
	 * @param menuDTO
	 */
	public static void userMyMenu(UserMenuDTO menuDTO) {
		
	}
	
	/**
	 * 회원탈퇴
	 * @param id
	 * @param pw
	 * @param phone
	 */
	public static void userDelete(String id, String pw, String phone) {
		
	}
}
