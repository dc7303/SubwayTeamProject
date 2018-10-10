package subway.admin.service;

import java.util.List;

import subway.admin.dto.IngredientDTO;
import subway.user.model.dto.UserInfoDTO;

public interface AdminService {
    
    /**
     * 회원정보 조회
     * 
     * @return ArrayList()로 회원정보 리스트 리턴
     */
    public List<UserInfoDTO> userSearch();
    
    /**
     * 메뉴추가. 추가 결과가 0으로 받을 경우 SQLException 발생 
     * 
     * @return 1이상이면 true, 0이면 false.
     */
    public int menuInsert(IngredientDTO ingredDTO);
    
    /**
     * 메뉴 수정. 추가 결과가 0으로 받을 경우 SQLException 발생 
     * 
     * @return 1이상이면 true, 0이면 false.
     */
    public int menuUpdate(IngredientDTO ingredDTO);
}
