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
    @Column(name ="comment_upvote")
    private int commentUpvote;

    @ManyToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name ="member_no")
    private MemberEntity member;

    @ManyToOne(cascade = CascadeType.ALL, fetch= FetchType.LAZY)
    @JoinColumn(name = "comment_no")
    private Comment comment;
    }
