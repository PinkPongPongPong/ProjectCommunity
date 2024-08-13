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
    @Column(name="post_no")
    private int postNo;

    @Column(name="post_date")
    private Date postDate;

    @Column(name="post_views")
    private int postViews;

    @Column(name="post_upvote_count")
    private int postUpvoteCount;

    @Column(name="title", unique = true)
    private String title;

    @Column(name="content")
    private String content;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "member_no")
    private MemberEntity member;

    @ManyToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name = "board_category")
    private BoardCategory BoardCategory;

    @ManyToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name = "post_category")
    private PostCategory postCategory;


    public String getMemberNickname(Board board) {
        return board.getMember() != null ? board.getMember().getMemberNickName() : null;
    }

    public Board getBoardWithMember(int boardId) {
        EntityManager entityManager = null;
        return entityManager.createQuery("SELECT b FROM Board b JOIN FETCH b.member WHERE b.postNo = :boardId", Board.class)
                .setParameter("boardId", boardId)
                .getSingleResult();
    }

}
