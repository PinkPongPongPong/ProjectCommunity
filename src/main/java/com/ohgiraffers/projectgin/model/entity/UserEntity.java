package com.ohgiraffers.projectgin.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_user")
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
    private String userNickName;
    private String name;
    private String phone;
    private String email;
    private LocalDate regDate;
    private LocalDate susDate;
    private int susCount;
    @Enumerated(EnumType.STRING)
    private RoleType role;
}
