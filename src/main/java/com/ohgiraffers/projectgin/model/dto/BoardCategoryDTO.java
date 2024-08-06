package com.ohgiraffers.projectgin.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class BoardCategoryDTO {

    private int boardCategoryNo;
    private String boardCategory;
}