package subway.admin.dao;

import java.util.List;

import subway.admin.dto.IngredientDTO;
import subway.user.model.dto.UserInfoDTO;

public interface AdminDAO {
    
    /**
     * 유저정보 검색
     * 
     * @return 유저정보 ArrayList에 담아 List로 리턴함.
     */
    public List<UserInfoDTO> userSearch();
    
    /**
     * 메뉴 추가.
     * 
     * @param ingredDTO
     * @return 1이면 true, 0이면 false.
     */
    public int menuInsert(IngredientDTO ingredDTO);
    
    /**
     * 메뉴 수정.
     * 
     * @param ingredDTO
     * @return 1이면 true, 0이면 false.
     */
    public int menuUpdate(IngredientDTO ingredDTO);
}
