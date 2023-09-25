package com.example.queeniepizza.User;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserResponse {
    private int id;
    private String userName;
    private String email;
    private String address;
    private  String phoneNumber;
}
