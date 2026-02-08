package io.github.mma.money_management_application.response;

import lombok.Data;

@Data
public class UserResponse {
    private Long userId;
    private String username;
    private String emailId;
    private Long mobileNo;

    public UserResponse() {
    }
    public UserResponse(Long userId, String username, String emailId, Long mobileNo) {
        this.userId = userId;
        this.username = username;
        this.emailId = emailId;
        this.mobileNo = mobileNo;
    }
}
