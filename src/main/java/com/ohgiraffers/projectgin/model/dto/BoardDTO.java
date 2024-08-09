package com.ohgiraffers.projectgin.model.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class BoardDTO{

    private int postNo;
    private Date postDate;
    private int postCount;
    private int postUpvoteCount;
    private String title;
    private String content;


}
