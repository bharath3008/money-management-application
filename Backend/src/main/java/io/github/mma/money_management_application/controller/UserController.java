package io.github.mma.money_management_application.controller;

import io.github.mma.money_management_application.Config.ApiResponse;
import io.github.mma.money_management_application.request.UserRequest;
import io.github.mma.money_management_application.response.UserResponse;
import io.github.mma.money_management_application.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/createUser")
    public ResponseEntity<ApiResponse<UserResponse>> createUser(@RequestBody UserRequest userRequest) {
        UserResponse response = userService.createUser(userRequest);
        ApiResponse<UserResponse> apiResponse = new ApiResponse(true,"User Created",response);
        return ResponseEntity.ok(apiResponse);
    }
}
