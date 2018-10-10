package subway.admin.controller;

import java.util.List;

import subway.admin.dto.IngredientDTO;
import subway.user.model.dto.UserInfoDTO;

public class AdminController {

    /**
     * 유저 정보 조회.
     * 
     * @return UserInfoDTO 재사용하여 유저정보 List로 리턴한다.
     */
    public static List<UserInfoDTO> userSearch() {

        return null;
    }

    /**
     * 메뉴추가 기능
     * 
     * @param ingredDTO
     * @return 1이상이면 true, 0이면 false;
     */
    public static int menuInsert(IngredientDTO ingredDTO) {

        return 0;
    }
    
    /**
     * 메뉴 수정
     * 
     * @param ingredDTO
     * @return 1이상이면 true, 0이면 false;
     */
    public static int menuUpdate(IngredientDTO ingredDTO) {
        
        return 0;
    }
    
    
}














