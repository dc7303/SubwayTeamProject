package subway.admin.dao;

import java.sql.SQLException;
import java.util.List;

import subway.admin.dto.IngredientDTO;
import subway.user.model.dto.OrderDTO;
import subway.user.model.dto.UserInfoDTO;

public interface AdminDAO {

    /**
     * �������� �˻�
     * 
     * @return �������� ArrayList�� ��� List�� ������.
     */
    public List<UserInfoDTO> userSearch() throws SQLException;

    /**
     * �޴� �߰�.
     * 
     * @param ingredDTO
     * @return 1�̸� true, 0�̸� false.
     */
    public int menuInsert(IngredientDTO ingredDTO) throws SQLException;

    /**
     * �޴� ����.
     * 
     * @param ingredDTO
     * @return 1�̸� true, 0�̸� false.
     */
    public int menuUpdate(IngredientDTO ingredDTO) throws SQLException;

    /**
     * �޴� ����
     * 
     * @param ingredName
     * @return 1�̸� true, 0�̸� false.
     * @throws SQLException
     */
    public int menuDelete(String ingredName) throws SQLException;

}
