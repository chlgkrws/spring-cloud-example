package com.example.userservice.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
public class UserDto {

    private String email;
    private String name;
    private String pwd;
    private String userId;

    private Date createAt;
    private String encryptedPwd;
}