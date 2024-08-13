package com.ohgiraffers.projectgin.model.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tbl_notification")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class Notification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="notification_no")
    private int notificationNo;

    @Column(name="notification_title")
    private String notificationTitle;

    @Column(name="notification_content")
    private String notificationContent;

    @Column(name="notification_date")
    private LocalDate notificationDate;

    @Column(name="notification_count")
    private int notificationCount;

}
