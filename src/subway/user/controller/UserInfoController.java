package subway.user.controller;

import subway.user.model.dto.OrderDTO;
import subway.user.model.dto.UserInfoDTO;
import subway.user.model.service.UserInfoService;
import subway.user.model.service.UserInfoServiceImpl;

public class UserInfoController {
	private UserInfoService service = new UserInfoServiceImpl();
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
	public static void userMyMenu(OrderDTO orderDTO) {
		
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
