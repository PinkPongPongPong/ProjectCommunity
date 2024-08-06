package com.ohgiraffers.projectgin.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
public class PostCategory {
    @Id
    @Column(name ="post_category_no")
    private int postCategoryNo;

    @Column(name ="post_category")
    private String postCategory;



}
