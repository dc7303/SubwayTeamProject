package subway.admin.dao;

import java.util.List;

import subway.admin.dto.IngredientDTO;
import subway.user.model.dto.UserInfoDTO;

public interface AdminDAO {
    
    /**
     * �������� �˻�
     * 
     * @return �������� ArrayList�� ��� List�� ������.
     */
    public List<UserInfoDTO> userSearch();
    
    /**
     * �޴� �߰�.
     * 
     * @param ingredDTO
     * @return 1�̸� true, 0�̸� false.
     */
    public int menuInsert(IngredientDTO ingredDTO);
    
    /**
     * �޴� ����.
     * 
     * @param ingredDTO
     * @return 1�̸� true, 0�̸� false.
     */
    public int menuUpdate(IngredientDTO ingredDTO);
}
