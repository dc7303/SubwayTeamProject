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
	 */
	public static int userSignIn(String id, String pw) {
		
		return 0;
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
