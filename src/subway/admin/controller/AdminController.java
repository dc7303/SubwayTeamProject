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
     * ���� ���� ��ȸ.
     * 
     * @return UserInfoDTO �����Ͽ� �������� List�� �����Ѵ�.
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
     * �޴��߰� ���
     * 
     * @param ingredDTO
     * @return 1�̻��̸� true, 0�̸� false;
     */
    public static int menuInsert(IngredientDTO ingredDTO) {
        int result = 0;
        try {
            result = service.menuInsert(ingredDTO);
            SuccessView.successMessage("��ϵǾ����ϴ�.");
        } catch (SQLException e) {
            e.printStackTrace();
            FailView.errorMessage(e.getMessage());
        }
        return result;
    }

    /**
     * �޴� ����
     * 
     * @param ingredDTO
     * @return 1�̻��̸� true, 0�̸� false;
     */
    public static int menuUpdate(IngredientDTO ingredDTO) {
        int result = 0;
        try {
            result = service.menuUpdate(ingredDTO);
            SuccessView.successMessage("�����Ǿ����ϴ�.");
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
            SuccessView.successMessage("�����Ǿ����ϴ�.");
        } catch (SQLException e) {
            e.printStackTrace();
            FailView.errorMessage(e.getMessage());
        }
        return result;
    }

}
