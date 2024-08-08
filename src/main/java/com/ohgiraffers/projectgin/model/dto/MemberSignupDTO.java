package com.ohgiraffers.projectgin.model.dto;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class MemberSignupDTO {
    private int memberNo;
    private String memberId;
    @NotBlank(message = "비밀번호를 입력해주세요.")
    private String password;
    private String memberNickName;
    @NotBlank(message = "닉네임을 입력해주세요.")
    private String name;
    private String phone;
    @NotBlank(message="이메일을 입력해주세요.")
    @Email(message = "올바른 이메일 주소를 입력해주세요.")
    private String email;
    private LocalDate regDate;
    private LocalDate susDate;
    private int susCount;
    private String role;

}
