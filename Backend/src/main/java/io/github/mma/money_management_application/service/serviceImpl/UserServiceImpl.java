package io.github.mma.money_management_application.service.serviceImpl;

import io.github.mma.money_management_application.entity.User;
import io.github.mma.money_management_application.repository.UserRepository;
import io.github.mma.money_management_application.request.UserRequest;
import io.github.mma.money_management_application.response.UserResponse;
import io.github.mma.money_management_application.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponse createUser(UserRequest request) {
        userRepository.findByEmailId(request.getEmailId())
                .ifPresent(n->{throw new RuntimeException("Duplicate Email ID");});
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmailId(request.getEmailId());
        user.setMobileNo(request.getMobileNo());
        User saved = userRepository.save(user);
        return new UserResponse(saved.getUserId(), saved.getUsername(), saved.getEmailId(), saved.getMobileNo());
    }
    @Override
    public UserResponse getUser(UserRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(()->new RuntimeException("User Not Found"));
        return new UserResponse(user.getUserId(), user.getUsername(), user.getEmailId(), user.getMobileNo());
    }

    @Override
    public UserResponse updateUserEmailIdAndMobile(UserRequest userRequest) {
        User user = userRepository.findById(userRequest.getUserId()).orElseThrow(()->new RuntimeException("User Not Found"));
        user.setEmailId(userRequest.getEmailId());
        user.setMobileNo(userRequest.getMobileNo());
        userRepository.save(user);
        return new UserResponse(user.getEmailId(),user.getMobileNo());
    }
    @Override
    public UserResponse deleteUser(UserRequest request) {
        User user = userRepository.findById(request.getUserId()).orElseThrow(()->new RuntimeException("User Not Found"));
        userRepository.delete(user);
        return new UserResponse(user.getUserId(),user.getUsername(),user.getEmailId(),user.getMobileNo());
    }
}
