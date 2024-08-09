package com.ohgiraffers.projectgin.model.service;

import com.ohgiraffers.projectgin.model.dto.NotificationDTO;
import com.ohgiraffers.projectgin.model.entity.Notification;
import com.ohgiraffers.projectgin.model.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@Service
@Transactional(readOnly = true)
public class NotificationService {

    private final NotificationRepository notificationRepository;
    private final ModelMapper modelMapper;

    public NotificationService(NotificationRepository notificationRepository, ModelMapper modelMapper) {
        this.notificationRepository = notificationRepository;
        this.modelMapper = modelMapper;
    }

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

    public Page<NotificationDTO> findAllNotification(Pageable pageable) {
        //페이지 요청 조정
        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("menuCode").descending());

        //데이터조회
        Page<Notification> notificationList = notificationRepository.findAll(pageable);

        // 변환 및 반환
        try {
            return notificationList.map(menu -> modelMapper.map(menu, NotificationDTO.class));
        } catch (Exception e) {
            // 변환 오류 처리
            log.error("Error mapping Notification to NotificationDTO", e);
            throw new RuntimeException("Error mapping Notification to NotificationDTO", e);
        }

//        return notificationList.map(menu -> modelMapper.map(menu, NotificationDTO.class));
    }

}
