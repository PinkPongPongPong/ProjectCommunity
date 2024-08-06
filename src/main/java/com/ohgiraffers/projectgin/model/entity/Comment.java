package com.ohgiraffers.projectgin.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@Table(name ="tbl_comment")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="comment_no")
    private int commentNo;

    @Column(name="user_nickname")
    private String userNickname;

    @Column(name="comment_date")
    private Date commentDate;

    @Column(name ="comment_upvote_count")
    private Date commentUpvoteCount;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name ="user_no")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "tbl_board",nullable = false)
    private Board board;


}
