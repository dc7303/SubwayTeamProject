package subway.user.controller;

import subway.user.model.dto.UserInfoDTO;
import subway.user.model.dto.UserMenuDTO;
import subway.user.model.service.UserService;
import subway.user.model.service.UserServiceImpl;

public class UserController {
	private UserService service = new UserServiceImpl();
	/**
	 * ȸ������
	 * @param userDTO
	 */
	public static void userSignUp(UserInfoDTO userDTO) {
		
	}
	
	/**
	 * �α���
	 * @param id
	 * @param pw
	 */
	public static void userSignIn(String id, String pw) {
		
	}
	
	/**
	 * ȸ������ ����
	 * @param userDTO
	 */
	public static void userUpdate(UserInfoDTO userDTO) {
		
	}
	
	/**
	 * ������ �޴�
	 * @param menuDTO
	 */
	public static void userMyMenu(UserMenuDTO menuDTO) {
		
	}
	
	/**
	 * ȸ��Ż��
	 * @param id
	 * @param pw
	 * @param phone
	 */
	public static void userDelete(String id, String pw, String phone) {
		
	}
}
