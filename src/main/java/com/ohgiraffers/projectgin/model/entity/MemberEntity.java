package com.ohgiraffers.projectgin.model.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "tbl_member")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class MemberEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="member_no")
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
    @Enumerated(EnumType.STRING)
    private RoleType role;

//    public MemberEntity update(String name, String email, String password) {
//    }
}
