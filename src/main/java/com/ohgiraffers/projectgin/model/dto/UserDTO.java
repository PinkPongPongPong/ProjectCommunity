package com.ohgiraffers.projectgin.model.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class UserDTO {

    private int userNo;

    private String userNickname;

    private String userAccount;

    private String userPwd;

    private String phone;

    private String email;

    private Date regDate;

    private Date susDate;

    private int susCount;
}
