package subway.user.model.dto;

/**
 * ����� ���� DTO, toString�� ������ ����
 */
public class UserInfoDTO {
	private String userId;		//ID
	private String userPw;		//PW
	private String userName;	//NAME
	private String userPhone;	//PHONE
	private String userEmail;	//EMAIL

	
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
	
	//�׽�Ʈ �� �ӽ� toString �޼ҵ�
	@Override
	public String toString() {
		return userId + " | " + userPw + " | " + userName + " | "
				+ userPhone + " | " + userEmail;
	}
	
	
	
	
}
