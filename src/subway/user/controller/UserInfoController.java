package subway.user.controller;

import subway.user.model.dto.UserInfoDTO;
import subway.user.model.service.UserInfoService;
import subway.user.model.service.UserInfoServiceImpl;
import subway.user.view.FailView;
import subway.user.view.SuccessView;

public class UserInfoController {

    private static UserInfoService service = new UserInfoServiceImpl();

    /**
     * ȸ������
     * 
     * @param userDTO
     */
    public static int userSignUp(UserInfoDTO userDTO) {
        int result = 0;
        try {
            result = service.userSignUp(userDTO);
            SuccessView.successMessage(userDTO.getUserName() + "�� ���� �Ǿ����ϴ�.");
        } catch (Exception e) {
            FailView.errorMessage(e.getMessage());
        }
        return result;
        
    }

    /**
     * ���� IDüũ
     * 
     * @param userId
     * @return
     */
    public static UserInfoDTO userIdCheck(String userId) {
        UserInfoDTO userDTO = null;
        try {
            userDTO = service.userIdCheck(userId);
            if (userDTO == null) {
                SuccessView.successMessage("���� ������ ���̵��Դϴ�.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            FailView.errorMessage(e.getMessage());
        }
        return userDTO;
    }

    /**
     * �α���
     * 
     * @param id
     * @param pw
     */
    public static UserInfoDTO userSignIn(String id, String pw) {
        UserInfoDTO userDTO = null;
        try {
            userDTO = service.userSignIn(id, pw);
            SuccessView.successMessage(id + "�� ȯ���մϴ�.");
        } catch (Exception e) {
            FailView.errorMessage(e.getMessage());
        }
        
        return userDTO;
         
    }

    /**
     * ȸ������ ����
     * 
     * @param userDTO
     */
    public static int userUpdate(UserInfoDTO userDTO) {
        int result = 0;
        try {
            result = service.userUpdate(userDTO);
            SuccessView.successMessage("������ �Ϸ�Ǿ����ϴ�.");
        } catch (Exception e) {
            FailView.errorMessage(e.getMessage());
        }
        return result;
    }

    /**
     * ȸ��Ż��
     * 
     * @param id
     * @param pw
     * @param phone
     */
    public static int userDelete(String id, String pw, String phone) {

        return 0;
    }

}
