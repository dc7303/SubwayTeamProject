package subway.admin.dto;

public class AdminUserDTO {
    private String userId;
    private String userPass;
    private String userName;
    private String phone;
    private String userEmail;
    
    public AdminUserDTO() {}
    
    public AdminUserDTO(String userId, String userPass, String userName, String phone, String userEmail) {
        super();
        this.userId = userId;
        this.userPass = userPass;
        this.userName = userName;
        this.phone = phone;
        this.userEmail = userEmail;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPass() {
        return userPass;
    }

    public void setUserPass(String userPass) {
        this.userPass = userPass;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Override
    public String toString() {
        return userId + " | " + userPass + " | " + userName + " | " + phone + " | " + userEmail;
    }
    
    
}
