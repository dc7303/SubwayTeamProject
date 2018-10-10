package subway.admin.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import subway.admin.dao.AdminDAO;
import subway.admin.dao.AdminDAOImpl;
import subway.admin.dto.IngredientDTO;
import subway.user.model.dto.UserInfoDTO;

public class AdminServiceImpl implements AdminService {
    private AdminDAO adminDAO = new AdminDAOImpl();
    
    @Override
    public List<UserInfoDTO> userSearch() throws SQLException {
        List<UserInfoDTO> list = new ArrayList();
        list = adminDAO.userSearch();
        if(list == null) {
            throw new SQLException("�������� �ҷ����� ���߽��ϴ�.");
        }
        return list;
    }

    @Override
    public int menuInsert(IngredientDTO ingredDTO) throws SQLException {
        int result = 0;
        result = adminDAO.menuInsert(ingredDTO);
        if(result == 0) {
            throw new SQLException("�޴� ��Ͽ� �����Ͽ����ϴ�.");
        }
        return result;
    }

    @Override
    public int menuUpdate(IngredientDTO ingredDTO) throws SQLException {
        int result = 0;
        result = adminDAO.menuUpdate(ingredDTO);
        if(result == 0) {
            throw new SQLException("�޴� ������ �����Ͽ����ϴ�.");
        }
        return result;
    }

}
