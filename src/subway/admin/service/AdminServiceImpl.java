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
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public int menuUpdate(IngredientDTO ingredDTO) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
