package com.ohgiraffers.projectgin.model.service;

import com.ohgiraffers.projectgin.model.dto.NotificationDTO;
import com.ohgiraffers.projectgin.model.entity.Notification;
import com.ohgiraffers.projectgin.model.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NotificationService {

    private final NotificationRepository notificationRepository;

    @Transactional
    public void savedNotification(NotificationDTO notificationDTO){

        Notification notification = Notification.builder()
                .notificationTitle(notificationDTO.getNotificationTitle())
                .notificationContent(notificationDTO.getNotificationContent())
                .notificationDate(LocalDate.now())
                .notificationCount(0)
                .build();

        Notification savedNotification = notificationRepository.save(notification);
        log.info("saved : {}",savedNotification);
    }

    public List<Notification> getNotificationList(){
        return  notificationRepository.findAll();
    }

}
