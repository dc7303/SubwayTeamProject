package subway.user.controller;

import subway.user.model.dto.OrderDTO;
import subway.user.model.dto.UserInfoDTO;
import subway.user.model.service.UserInfoService;
import subway.user.model.service.UserInfoServiceImpl;

public class UserInfoController {
	private static UserInfoService service = new UserInfoServiceImpl();
	/**
	 * ȸ������
	 * @param userDTO
	 */
	public static int userSignUp(UserInfoDTO userDTO) {
		
		return 0;
	}
	
	/**
	 * �α���
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
	 * ȸ������ ����
	 * @param userDTO
	 */
	public static int userUpdate(UserInfoDTO userDTO) {
		
		return 0;
	}
	
	
	/**
	 * ȸ��Ż��
	 * @param id
	 * @param pw
	 * @param phone
	 */
	public static int userDelete(String id, String pw, String phone) {
		
		return 0;
	}
}
