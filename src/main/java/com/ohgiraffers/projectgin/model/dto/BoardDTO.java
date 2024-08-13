package com.ohgiraffers.projectgin.model.dto;

import com.ohgiraffers.projectgin.model.entity.Board;
import lombok.*;

import java.sql.Date;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class BoardDTO{

    private int postNo;
    private Date postDate;
    private int postViews;
    private int postUpvoteCount;
    private String title;
    private String content;


}
