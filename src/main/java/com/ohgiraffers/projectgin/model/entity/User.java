package com.ohgiraffers.projectgin.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name="User")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="user_no")
    private int userNo;

    @Column(name="user_nickname")
    private String userNickname;

    @Column(name="user_account")
    private String userAccount;

    @Column(name="user_pwd")
    private String userPwd;

    @Column(name="phone")
    private String phone;

    @Column(name="email")
    private String email;

    @Column(name="reg_date")
    private Date regDate;

    @Column(name="sus_date")
    private Date susDate;

    @Column(name="sus_count")
    private int susCount;



}
