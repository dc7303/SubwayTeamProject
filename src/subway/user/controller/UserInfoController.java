package subway.user.controller;

import subway.user.model.dto.UserInfoDTO;
import subway.user.model.service.UserInfoService;
import subway.user.model.service.UserInfoServiceImpl;
import subway.user.view.SuccessView;

public class UserInfoController {
	private static UserInfoService service = new UserInfoServiceImpl();
	/**
	 * ȸ������
	 * @param userDTO
	 */
	public static int userSignUp(UserInfoDTO userDTO) {
		int result=0;
		try {
			result = service.userSignUp(userDTO);
			SuccessView.successMessage(userDTO.getUserName()+"�� ���� �Ǿ����ϴ�.");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		return result;
	}
	
	/**
	 * �α���
	 * @param id
	 * @param pw
	 */
	public static int userSignIn(String id, String pw) {
		
		return 0;
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
