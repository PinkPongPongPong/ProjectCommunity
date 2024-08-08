package com.ohgiraffers.projectgin.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tbl_notification")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@ToString
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="notification_no")
    private String notificationNo;

    @Column(name="admin_no")
    private String adminNo;

    @Column(name="notification_title")
    private String notificationTitle;

    @Column(name="notification_content")
    private String notificationContent;

    @Column(name="notification_date")
    private String notificationDate;

    @Column(name="notification_count")
    private String notificationCount;
}
