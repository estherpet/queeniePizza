package com.example.queeniepizza.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ChangePasswordRequest {
    private  String userName;
    private  String oldPassword;
    private String newPassword;
}
