package subway.admin.controller;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.List;

import subway.admin.dto.IngredientDTO;
import subway.admin.service.AdminService;
import subway.admin.service.AdminServiceImpl;
import subway.user.model.dto.UserInfoDTO;
import subway.admin.view.FailView;
import subway.admin.view.SuccessView;

public class AdminController {
    private static AdminService service = new AdminServiceImpl();

    /**
     * 유저 정보 조회.
     * 
     * @return UserInfoDTO 재사용하여 유저정보 List로 리턴한다.
     */
    public static List<UserInfoDTO> userSearch() {
        List<UserInfoDTO> list = new ArrayList();
        try {
            list = service.userSearch();
            SuccessView.userSearch(list);
        } catch (SQLException e) {
            e.printStackTrace();
            FailView.errorMessage(e.getMessage());
        }
        return list;
    }

    /**
     * 메뉴추가 기능
     * 
     * @param ingredDTO
     * @return 1이상이면 true, 0이면 false;
     */
    public static int menuInsert(IngredientDTO ingredDTO) {
        int result = 0;
        try {
            result = service.menuInsert(ingredDTO);
            SuccessView.successMessage("등록되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
            FailView.errorMessage(e.getMessage());
        }
        return result;
    }

    /**
     * 메뉴 수정
     * 
     * @param ingredDTO
     * @return 1이상이면 true, 0이면 false;
     */
    public static int menuUpdate(IngredientDTO ingredDTO) {
        int result = 0;
        try {
            result = service.menuUpdate(ingredDTO);
            SuccessView.successMessage("수정되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
            FailView.errorMessage(e.getMessage());
        }
        return result;
    }

    public static int menuDelete(String ingredName) {
        int result = 0;
        try {
            result = service.menuDelete(ingredName);
            SuccessView.successMessage("삭제되었습니다.");
        } catch (SQLException e) {
            e.printStackTrace();
            FailView.errorMessage(e.getMessage());
        }
        return result;
    }

}
