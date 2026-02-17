package io.github.mma.money_management_application.request;

import lombok.Data;

@Data
public class UserRequest {
    private Long userId;
    private String username;
    private String password;
    private String emailId;
    private Long mobileNo;


}
