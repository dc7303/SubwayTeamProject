package subway.user.model.dao;

import java.sql.SQLException;

import subway.user.model.dto.UserInfoDTO;
import subway.user.model.dto.UserMenuDTO;

public interface UserDAO {
	
	/**
	 * ȸ������ insert ������ ���
	 */
	int userSignUp (UserInfoDTO userDTO) throws SQLException; 
	
	/**
	 * �α��� id�� pw �޾Ƽ� select ������ ���
	 */
	UserInfoDTO userSignIn (String id, String pw) throws SQLException;
	
	/**
	 * ȸ������ ���� update ������ ���
	 */
	int userUpdate (UserInfoDTO userDTO) throws SQLException;
	
	/**
	 * ������ �޴� update ������ ����ؼ� menuDTO.getMenuNO ����ؼ� ������ �޴� �߰�
	 */
	int userMyMenu (UserMenuDTO menuDTO) throws SQLException;
	
	/**
	 * ȸ�� Ż�� delete ������ ����ؼ� ����. ����� Ȯ���� �ӽ÷� phone ��ȣ �����ϴ� �ɷ� �ӽ�����
	 */
	int userDelete (String id, String pw, String phone) throws SQLException;
}
