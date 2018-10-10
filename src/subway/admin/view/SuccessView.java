package subway.admin.view;

import java.util.List;

import subway.user.model.dto.UserInfoDTO;

public class SuccessView {
    /**
     * ���� �޼��� ���
     * 
     * @param message
     */
    public static void successMessage(String message) {
        System.out.println(message);
    }

    /**
     * ���� ���� ���
     * 
     * @param list
     */
    public static void userSearch(List<UserInfoDTO> list) {
        for (UserInfoDTO dto : list) {
            System.out.println(dto);
        }
    }
}
