package subway.user.controller;

import subway.user.model.dto.UserInfoDTO;
import subway.user.model.service.UserInfoService;
import subway.user.model.service.UserInfoServiceImpl;
import subway.user.view.FailView;
import subway.user.view.SuccessView;

public class UserInfoController {
	private static UserInfoService service = new UserInfoServiceImpl();
	/**
	 * 회원가입
	 * @param userDTO
	 */
	public static int userSignUp(UserInfoDTO userDTO) {
		int result=0;
		try {
			result = service.userSignUp(userDTO);
			SuccessView.successMessage(userDTO.getUserName()+"님 가입 되었습니다.");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		return result;
	}
	
	/**
	 * 로그인
	 * @param id
	 * @param pw
	 */
	public static UserInfoDTO userSignIn(String id, String pw) {
		UserInfoDTO userDTO = null;
		try {
			userDTO = service.userSignIn(id, pw);
			SuccessView.successMessage(id+"님 환영합니다.");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		return userDTO;
	}
	
	/**
	 * 회원정보 수정
	 * @param userDTO
	 */
	public static int userUpdate(UserInfoDTO userDTO) {
		int result=0;
		try {
			result = service.userUpdate(userDTO);
			SuccessView.successMessage("수정이 완료되었습니다.");
		}catch(Exception e) {
			FailView.errorMessage(e.getMessage());
		}
		return result;
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
