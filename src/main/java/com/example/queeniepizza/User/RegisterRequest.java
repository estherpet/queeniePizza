package com.example.queeniepizza.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class RegisterRequest {
    private int id;
    private  String address;
    private  String phonenumber;
    private  String email;
    private  String userName;
    private  String password;
}
