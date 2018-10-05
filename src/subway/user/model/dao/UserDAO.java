package subway.user.model.dao;

import java.sql.SQLException;

import subway.user.model.dto.UserInfoDTO;
import subway.user.model.dto.UserMenuDTO;

public interface UserDAO {
	
	/**
	 * 회원가입 insert 쿼리문 사용
	 */
	int userSignUp (UserInfoDTO userDTO) throws SQLException; 
	
	/**
	 * 로그인 id와 pw 받아서 select 쿼리문 사용
	 */
	UserInfoDTO userSignIn (String id, String pw) throws SQLException;
	
	/**
	 * 회원정보 수정 update 쿼리문 사용
	 */
	int userUpdate (UserInfoDTO userDTO) throws SQLException;
	
	/**
	 * 나만의 메뉴 update 쿼리문 사용해서 menuDTO.getMenuNO 사용해서 나만의 메뉴 추가
	 */
	int userMyMenu (UserMenuDTO menuDTO) throws SQLException;
	
	/**
	 * 회원 탈퇴 delete 쿼리문 사용해서 삭제. 사용자 확인은 임시로 phone 번호 기입하는 걸로 임시적용
	 */
	int userDelete (String id, String pw, String phone) throws SQLException;
}
