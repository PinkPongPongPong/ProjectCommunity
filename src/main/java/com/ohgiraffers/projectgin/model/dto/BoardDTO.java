package com.ohgiraffers.projectgin.model.dto;

import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class BoardDTO{

    private int BoardNo;
    private Date BoardDate;
    private int BoardCount;
    private int BoardUpvoteCount;
    private String BoardTitle;
    private String BoardDetail;



}