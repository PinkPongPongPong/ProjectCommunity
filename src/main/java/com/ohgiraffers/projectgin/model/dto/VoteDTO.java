package com.ohgiraffers.projectgin.model.dto;

import lombok.*;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class VoteDTO {

    private int postNo;
    private boolean postUpdate;


}
