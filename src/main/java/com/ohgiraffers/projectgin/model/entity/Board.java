package com.ohgiraffers.projectgin.model.entity;

import java.sql.Date;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_board")
public class Board {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String post_Id;

    @Column(name = "user_nickname")
    private String user_NickName;
    @Column(name = "post_title")
    private String post_Title;
    @Column(name = "category_date")
    private Date category_Date;
    @Column (name = "name_view")
    private int views;
    @Column (name ="like")
    private int like;
    @Column (name ="hate")
    private int hate;
    @Column (name ="division")
    private String division;
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn (name = "user_id")
    @Column User user;

}
