package subway.admin.dao;

import java.sql.SQLException;
import java.util.List;

import subway.admin.dto.IngredientDTO;
import subway.user.model.dto.OrderDTO;
import subway.user.model.dto.UserInfoDTO;

public interface AdminDAO {

    /**
     * 유저정보 검색
     * 
     * @return 유저정보 ArrayList에 담아 List로 리턴함.
     */
    public List<UserInfoDTO> userSearch() throws SQLException;

    /**
     * 메뉴 추가.
     * 
     * @param ingredDTO
     * @return 1이면 true, 0이면 false.
     */
    public int menuInsert(IngredientDTO ingredDTO) throws SQLException;

    /**
     * 메뉴 수정.
     * 
     * @param ingredDTO
     * @return 1이면 true, 0이면 false.
     */
    public int menuUpdate(IngredientDTO ingredDTO) throws SQLException;

    /**
     * 메뉴 삭제
     * 
     * @param ingredName
     * @return 1이면 true, 0이면 false.
     * @throws SQLException
     */
    public int menuDelete(String ingredName) throws SQLException;

}
