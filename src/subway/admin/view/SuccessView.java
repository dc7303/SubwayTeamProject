package subway.admin.view;

import java.util.List;

import subway.user.model.dto.UserInfoDTO;

public class SuccessView {
    /**
     * 성공 메세지 출력
     * 
     * @param message
     */
    public static void successMessage(String message) {
        System.out.println(message);
    }

    /**
     * 유저 정보 출력
     * 
     * @param list
     */
    public static void userSearch(List<UserInfoDTO> list) {
        for (UserInfoDTO dto : list) {
            System.out.println(dto);
        }
    }
}
