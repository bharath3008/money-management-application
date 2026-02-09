package io.github.mma.money_management_application.controller;

import io.github.mma.money_management_application.Config.ApiResponse;
import io.github.mma.money_management_application.request.UserRequest;
import io.github.mma.money_management_application.response.UserResponse;
import io.github.mma.money_management_application.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserResponse>> getUser(@PathVariable Long userId) {
        try{
            UserRequest request = new UserRequest();
            request.setUserId(userId);
            UserResponse response = userService.getUser(request);
            return ResponseEntity.ok(new ApiResponse(true,"User Found",response));
        }
        catch (Exception e){
            return ResponseEntity.status(404).body(new ApiResponse(false,"User Not Found",null));
        }
    }

    @PatchMapping("/{userId}")
    public ResponseEntity<ApiResponse<UserResponse>> updateUserEmailIdAndMobile(@PathVariable Long userId ,@RequestBody UserRequest userRequest) {
        userRequest.setUserId(userId);
        UserResponse response = userService.updateUserEmailIdAndMobile(userRequest);
        return ResponseEntity.ok(new ApiResponse(true,"User Email Id and Mobile Number Updated",null));
    }



}
