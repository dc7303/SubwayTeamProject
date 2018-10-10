package subway.user.model.dao;

import java.sql.SQLException;

import subway.user.model.dto.OrderDTO;
import subway.user.model.dto.UserInfoDTO;

public interface UserInfoDAO {

    /**
     * ȸ������ insert ������ ���
     */
    int userSignUp(UserInfoDTO userDTO) throws SQLException;

    /**
     * ���� ���̵� üũ
     * 
     * @param id
     * @return UserInfoDTO
     * @throws SQLException
     */
    UserInfoDTO userIdCheck(String id) throws SQLException;

    /**
     * �α��� id�� pw �޾Ƽ� select ������ ���
     */
    UserInfoDTO userSignIn(String id, String pw) throws SQLException;

    /**
     * ȸ������ ���� update ������ ���
     */
    int userUpdate(UserInfoDTO userDTO) throws SQLException;

    /**
     * ������ �޴� update ������ ����ؼ� menuDTO.getMenuNO ����ؼ� ������ �޴� �߰�
     */
    int userMyMenu(OrderDTO orderDTO) throws SQLException;

    /**
     * ȸ�� Ż�� delete ������ ����ؼ� ����. ����� Ȯ���� �ӽ÷� phone ��ȣ �����ϴ� �ɷ� �ӽ�����
     */
    int userDelete(String id, String pw, String phone) throws SQLException;

}
