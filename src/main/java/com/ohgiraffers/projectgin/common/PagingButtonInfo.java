package com.ohgiraffers.projectgin.common;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class PagingButtonInfo {
    private int startPage;
    private int currentPage;
    private int endPage;
}
