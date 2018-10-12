package subway.user.model.service;

import java.sql.SQLException;

import subway.user.model.dao.UserInfoDAO;
import subway.user.model.dao.UserInfoDAOImpl;
import subway.user.model.dto.OrderDTO;
import subway.user.model.dto.UserInfoDTO;

public class UserInfoServiceImpl implements UserInfoService {
    private UserInfoDAO userDAO = new UserInfoDAOImpl();

    @Override
    public int userSignUp(UserInfoDTO userDTO) throws SQLException {
        int re = userDAO.userSignUp(userDTO);
        
        return re;
    }

    @Override
    public UserInfoDTO userIdCheck(String id) throws SQLException {
        UserInfoDTO userDTO = userDAO.userIdCheck(id);
        return userDTO;
    }

    @Override
    public UserInfoDTO userSignIn(String id, String pw) throws SQLException {
        UserInfoDTO userDTO = userDAO.userSignIn(id, pw);
       
        return userDTO;
    }

    @Override
    public int userUpdate(UserInfoDTO userDTO) throws SQLException {
        int userUpdate = userDAO.userUpdate(userDTO);
        
        return userUpdate;
    }

    @Override
    public int userMyMenu(OrderDTO orderDTO) throws SQLException {
        int re = userDAO.userMyMenu(orderDTO);
        
        return re;
    }

    @Override
    public int userDelete(String id, String pw, String phone) throws SQLException {
        // TODO Auto-generated method stub
        return 0;
    }

}
