package com.ohgiraffers.projectgin.model.service;

import com.ohgiraffers.projectgin.model.dto.NotificationDTO;
import com.ohgiraffers.projectgin.model.entity.Notification;
import com.ohgiraffers.projectgin.model.repository.NotificationRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
//@RequiredArgsConstructor
public class NotificationService {

    private final NotificationRepository notificationRepository;
//    private final ModelMapper modelMapper;

    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
//        this.modelMapper = modelMapper;
    }

    @Transactional
    public void create(NotificationDTO notificationDTO) {

//        Notification notification = modelMapper.map(notificationDTO, Notification.class);

        Notification notification = new Notification().builder()
                .notificationNo(notificationDTO.getNotificationNo())
                .adminNo(notificationDTO.getAdminNo())
                .notificationTitle(notificationDTO.getNotificationTitle())
                .notificationCount(notificationDTO.getNotificationContent())
                .notificationDate(notificationDTO.getNotificationDate())
                .notificationCount(notificationDTO.getNotificationCount())
                .build();

        notificationRepository.save(notification);

    }

}
