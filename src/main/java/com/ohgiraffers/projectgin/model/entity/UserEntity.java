package com.ohgiraffers.projectgin.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_member")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
    @Enumerated(EnumType.STRING)
    private RoleType role;
}
