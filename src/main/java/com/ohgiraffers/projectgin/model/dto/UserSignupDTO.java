package com.ohgiraffers.projectgin.model.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserSignupDTO {
    private int user_no;
    private String user_id;
    private String password;
    private String nick_name;
    private String name;
    private String phone;
    private String email;
    private LocalDate reg_date;
    private LocalDate sus_date;
    private int sus_count;
    private String role;

}
