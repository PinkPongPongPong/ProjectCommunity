package com.ohgiraffers.projectgin.model.service;

import com.ohgiraffers.projectgin.model.dto.NotificationDTO;
import com.ohgiraffers.projectgin.model.entity.Notification;
import com.ohgiraffers.projectgin.model.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final ModelMapper modelMapper;

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

    public List<NotificationDTO> getNotificationList(){
        return  notificationRepository.findAll().stream()
                .map(notification -> modelMapper.map(notification, NotificationDTO.class))
                .collect(Collectors.toList());
    }

    public Page<NotificationDTO> findAllnotification(Pageable pageable) {

        pageable = PageRequest.of( // PageRequest.of -> Pageable 객체 조작
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("notificationNo").descending());

        Page<Notification> notifications = notificationRepository.findAll(pageable);

        return notifications.map(notification -> modelMapper.map(notification, NotificationDTO.class));

    }

//    public NotificationDTO findNotificationByCode(int notificationNo) {
//
//        Notification notification = notificationRepository.findById(notificationNo)
//                .orElseThrow(IllegalArgumentException::new);
//
//        log.info("notification : {}", notification);
//
//        return modelMapper.map(notification, NotificationDTO.class);
//    }




}
