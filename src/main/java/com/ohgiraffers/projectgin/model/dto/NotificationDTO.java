package com.ohgiraffers.projectgin.model.dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class NotificationDTO {
    private int notificationNo;
    private String notificationTitle;
    private String notificationContent;
    private LocalDate notificationDate;
    private int notificationCount;
}
