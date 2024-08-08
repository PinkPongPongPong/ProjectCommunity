package com.ohgiraffers.projectgin.model.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@ToString
public class NotificationDTO {
    private int notificationNo;
    private String adminNo;
    private String notificationTitle;
    private String notificationContent;
    private String notificationDate;
    private String notificationCount;
}
