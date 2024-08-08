package com.ohgiraffers.projectgin.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_comment_upvote")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentUpvote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="comment_upvote_no")
    private int commentUpvoteNo;

    @Column(name ="comment_upvote")
    private boolean commentUpvote;

    @ManyToOne(fetch= FetchType.LAZY)
    @JoinColumn(name ="member_no")
    private MemberEntity member;

    @ManyToOne( fetch= FetchType.LAZY)
    @JoinColumn(name = "comment_no")
    private Comment comment;
    }
