package subway.user.model.dto;

/**
 * 사용자 정보 DTO, toString은 재정의 보류
 */
public class UserInfoDTO {
	private String userId;		//ID
	private String userPw;		//PW
	private String userName;	//NAME
	private String userPhone;	//PHONE
	private String userEmail;	//EMAIL
	private String userMyMenu1;	//나만의 메뉴1
	private String userMyMenu2;	//나만의 메뉴2
	private String userMyMenu3;	//나만의 메뉴3
	
	public UserInfoDTO() {}

	public UserInfoDTO(String userId, String userPw) {
		super();
		this.userId = userId;
		this.userPw = userPw;
	}

	public UserInfoDTO(String userId, String userPw, String userName, String userPhone, String userEmail) {
		this(userId, userPw);
		this.userName = userName;
		this.userPhone = userPhone;
		this.userEmail = userEmail;
	}

	public UserInfoDTO(String userId, String userPw, String userName, String userPhone, String userEmail,
			String userMyMenu1) {
		this(userId, userPw, userName, userPhone, userEmail);
		this.userMyMenu1 = userMyMenu1;
	}
	
	public UserInfoDTO(String userId, String userPw, String userName, String userPhone, String userEmail,
			String userMyMenu1, String userMyMenu2) {
		this(userId, userPw, userName, userPhone, userEmail, userMyMenu1);
		this.userMyMenu2 = userMyMenu2;
	}
	
	public UserInfoDTO(String userId, String userPw, String userName, String userPhone, String userEmail,
			String userMyMenu1, String userMyMenu2, String userMyMenu3) {
		this(userId, userPw, userName, userPhone, userEmail, userMyMenu1, userMyMenu2);
		this.userMyMenu3 = userMyMenu3;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserPw() {
		return userPw;
	}

	public void setUserPw(String userPw) {
		this.userPw = userPw;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPhone() {
		return userPhone;
	}

	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserMyMenu() {
		return userMyMenu1;
	}

	public void setUserMyMenu(String userMyMenu) {
		this.userMyMenu1 = userMyMenu;
	}

	public String getUserMyMenu2() {
		return userMyMenu2;
	}

	public void setUserMyMenu2(String userMyMenu2) {
		this.userMyMenu2 = userMyMenu2;
	}

	public String getUserMyMenu3() {
		return userMyMenu3;
	}

	public void setUserMyMenu3(String userMyMenu3) {
		this.userMyMenu3 = userMyMenu3;
	}
	
	
	
	
	
}
