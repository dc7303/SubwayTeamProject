package subway.admin.controller;

import java.util.List;

import subway.admin.dto.IngredientDTO;
import subway.user.model.dto.UserInfoDTO;

public class AdminController {

    /**
     * ���� ���� ��ȸ.
     * 
     * @return UserInfoDTO �����Ͽ� �������� List�� �����Ѵ�.
     */
    public static List<UserInfoDTO> userSearch() {

        return null;
    }

    /**
     * �޴��߰� ���
     * 
     * @param ingredDTO
     * @return 1�̻��̸� true, 0�̸� false;
     */
    public static int menuInsert(IngredientDTO ingredDTO) {

        return 0;
    }
    
    /**
     * �޴� ����
     * 
     * @param ingredDTO
     * @return 1�̻��̸� true, 0�̸� false;
     */
    public static int menuUpdate(IngredientDTO ingredDTO) {
        
        return 0;
    }
    
    
}














