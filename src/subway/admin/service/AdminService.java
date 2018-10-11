package subway.admin.service;

import java.sql.SQLException;
import java.util.List;

import subway.admin.dto.IngredientDTO;
import subway.user.model.dto.UserInfoDTO;

public interface AdminService {
    
    /**
     * ȸ������ ��ȸ
     * 
     * @return ArrayList()�� ȸ������ ����Ʈ ����
     */
    public List<UserInfoDTO> userSearch() throws SQLException;
    
    /**
     * �޴��߰�. �߰� ����� 0���� ���� ��� SQLException �߻� 
     * 
     * @return 1�̻��̸� true, 0�̸� false.
     */
    public int menuInsert(IngredientDTO ingredDTO) throws SQLException;
    
    /**
     * �޴� ����. �߰� ����� 0���� ���� ��� SQLException �߻� 
     * 
     * @return 1�̻��̸� true, 0�̸� false.
     */
    public int menuUpdate(IngredientDTO ingredDTO) throws SQLException;
}
