package com.ohgiraffers.projectgin.model.dto;

import com.ohgiraffers.projectgin.model.entity.BoardCategory;
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
