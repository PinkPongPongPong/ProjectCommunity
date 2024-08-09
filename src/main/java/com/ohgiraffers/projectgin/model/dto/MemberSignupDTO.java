package com.ohgiraffers.projectgin.model.dto;

import lombok.*;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberSignupDTO {
    private int memberNo;
    private String memberId;
    private String password;
    private String memberNickName;
    private String name;
    private String phone;
    private String email;
    private LocalDate regDate;
    private LocalDate susDate;
    private int susCount;
    private String role;

}
