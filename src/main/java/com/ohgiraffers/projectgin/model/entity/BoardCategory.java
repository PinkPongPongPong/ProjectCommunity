package com.ohgiraffers.projectgin.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="tbl_board_category")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BoardCategory {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int boardCategoryNo;
    private String boardCategory;

}
