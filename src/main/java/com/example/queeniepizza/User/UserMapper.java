package com.example.queeniepizza.User;

import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public User toUser(RegisterRequest request){
        return User.builder()
                .userId(request.getId())
                .userName(request.getUserName())
                .userEmail(request.getEmail())
                .phoneNumber(request.getPhonenumber())
                .userAddress(request.getAddress())
                .password(request.getPassword())
                .build();
    }
    public UserResponse toResponse(User user){
        return UserResponse.builder()
                .id(user.getUserId())
                .userName(user.getUserName())
                .email(user.getUserEmail())
                .phoneNumber(user.getPhoneNumber())
                .address(user.getUserAddress())
                .build();
    }
}
