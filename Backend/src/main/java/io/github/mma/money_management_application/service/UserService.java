package io.github.mma.money_management_application.service;

import io.github.mma.money_management_application.request.UserRequest;
import io.github.mma.money_management_application.response.UserResponse;

public interface UserService {

    UserResponse createUser(UserRequest userRequest);

    UserResponse getUser(UserRequest userRequest);

    UserResponse updateUserEmailIdAndMobile(UserRequest userRequest);
}
