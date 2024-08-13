package com.ohgiraffers.projectgin.model.dto;

import lombok.*;

import java.sql.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@ToString
public class CommentDTO {
    private int commentNo;
    private String userNickname;
    private Date commentDate;
    private int commentUpvoteCount;
    private String comment;
    private int boardNo;
    private int memberNo;
}