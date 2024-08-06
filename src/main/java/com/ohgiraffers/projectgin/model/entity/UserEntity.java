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
    @Enumerated(EnumType.STRING)
    private RoleType role;
}
