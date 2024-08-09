package com.ohgiraffers.projectgin.model.entity;

import java.lang.reflect.Member;
import java.sql.Date;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_board")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="board_no")
    private int postNo;

    @Column(name="board_date")
    private Date postDate;

    @Column(name="board_views")
    private int postViews;

    @Column(name="board_upvote_count")
    private int postUpdateCount;

    @Column(name="board_title")
    private String postTitle;

    @Column(name="board_detail")
    private String postDetail;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private MemberEntity member;

    @ManyToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name = "board_category")
    private BoardCategory BoardCategory;

    @ManyToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name = "post_category")
    private PostCategory postCategory;


}
