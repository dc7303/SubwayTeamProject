package subway.admin.service;

import java.util.List;

import subway.admin.dto.IngredientDTO;
import subway.user.model.dto.UserInfoDTO;

public interface AdminService {
    
    /**
     * ȸ������ ��ȸ
     * 
     * @return ArrayList()�� ȸ������ ����Ʈ ����
     */
    public List<UserInfoDTO> userSearch();
    
    /**
     * �޴��߰�. �߰� ����� 0���� ���� ��� SQLException �߻� 
     * 
     * @return 1�̻��̸� true, 0�̸� false.
     */
    public int menuInsert(IngredientDTO ingredDTO);
    
    /**
     * �޴� ����. �߰� ����� 0���� ���� ��� SQLException �߻� 
     * 
     * @return 1�̻��̸� true, 0�̸� false.
     */
    public int menuUpdate(IngredientDTO ingredDTO);
}
