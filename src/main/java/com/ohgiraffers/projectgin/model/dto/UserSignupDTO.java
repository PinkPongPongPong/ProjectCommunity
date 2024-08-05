package com.ohgiraffers.projectgin.model.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserSignupDTO {
    private int userNo;
    private String userId;
    private String password;
    private String nickName;
    private String name;
    private String phone;
    private String email;
    private LocalDate regDate;
    private LocalDate susDate;
    private int susCount;
    private String role;

}
